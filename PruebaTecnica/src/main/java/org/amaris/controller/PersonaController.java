package org.amaris.controller;

import lombok.extern.slf4j.Slf4j;
import org.amaris.controller.domain.GetPersonaRequest;
import org.amaris.controller.domain.PostPersonaRequest;
import org.amaris.persistence.model.Persona;
import org.amaris.persistence.model.TipoDocumento;
import org.amaris.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
public class PersonaController {

    @Autowired
    PersonaService personaService;

    @GetMapping("/persona")
    public ResponseEntity<Persona> getPersona(@RequestParam(value = "tipo") String tipoDocumento, @RequestParam(value = "numero") Long numeroDocumento){
        try{
            TipoDocumento.valueOf(tipoDocumento);
        } catch (IllegalArgumentException e){
            log.error("El tipo de documento solo puede ser 'C' o 'P'.", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Persona> persona = personaService.getPersona(TipoDocumento.valueOf(tipoDocumento), numeroDocumento);
        if(!persona.isPresent()) {
            log.info("No se encontro la persona.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(persona.get(), HttpStatus.OK);
    }

    @PostMapping("/persona")
    public ResponseEntity crearPersona(@RequestBody PostPersonaRequest request){
        try{
            TipoDocumento.valueOf(request.getTipoDocumento());
        } catch (IllegalArgumentException e){
            log.error("El tipo de documento solo puede ser 'C' o 'P'.", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            personaService.guardarPersona(request);
        }catch (Exception e) {
            log.error("Error inesperado al persistir persona.", e);
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
