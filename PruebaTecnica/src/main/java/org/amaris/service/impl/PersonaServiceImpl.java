package org.amaris.service.impl;

import org.amaris.controller.domain.PostPersonaRequest;
import org.amaris.persistence.controller.PersistenceController;
import org.amaris.persistence.model.Persona;
import org.amaris.persistence.model.TipoDocumento;
import org.amaris.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersistenceController persistenceController;

    @Override
    public void guardarPersona(PostPersonaRequest persona) {
        persistenceController.crearPersona(mapToPersona(persona));
    }

    @Override
    public Optional<Persona> getPersona(TipoDocumento tipoDocumento, Long numeroDocumento) {

        return persistenceController.getPersona(tipoDocumento, numeroDocumento);
    }

    private Persona mapToPersona(PostPersonaRequest p){
        Persona persona = Persona.builder()
                .tipoDocumento(TipoDocumento.valueOf(p.getTipoDocumento()))
                .numeroDocumento(p.getNumeroDocumento())
                .primerNombre(p.getPrimerNombre())
                .segundoNombre(p.getSegundoNombre())
                .primerApellido(p.getPrimerApellido())
                .segundoApellido(p.getSegundoApellido())
                .telefono(p.getTelefono())
                .direccion(p.getDireccion())
                .ciudad(p.getCiudad())
                .build();

        return persona;
    }
}
