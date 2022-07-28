package org.amaris.controller;

import org.amaris.controller.domain.PostPersonaRequest;
import org.amaris.persistence.model.Persona;
import org.amaris.service.impl.PersonaServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
public class PersonaControllerTest {

    @InjectMocks
    PersonaController controller;

    @Mock
    PersonaServiceImpl personaService;

    @Test
    public void getPersonaSuccess(){
        when(personaService.getPersona(any(), anyLong())).thenReturn(Optional.of(new Persona()));

        ResponseEntity<Persona> entity = controller.getPersona("C", 1234l);

        assertEquals(HttpStatus.OK, entity.getStatusCode());

    }

    @Test
    public void getPersonaNotFound(){
        when(personaService.getPersona(any(), anyLong())).thenReturn(Optional.empty());

        ResponseEntity<Persona> entity = controller.getPersona("C", 1234l);

        assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());

    }

    @Test
    public void getPersonaBadRequest(){
        ResponseEntity<Persona> entity = controller.getPersona("R", 1234l);

        assertEquals(HttpStatus.BAD_REQUEST, entity.getStatusCode());

    }

    @Test
    public void crearPersonaSuccess(){

        PostPersonaRequest personaRequest = PostPersonaRequest.builder()
                .tipoDocumento("C")
                .numeroDocumento(7654)
                .build();

        doNothing().when(personaService).guardarPersona(any());

        ResponseEntity entity = controller.crearPersona(personaRequest);

        assertEquals(HttpStatus.CREATED, entity.getStatusCode());

    }

    @Test
    public void crearPersonaBadRequest(){

        PostPersonaRequest personaRequest = PostPersonaRequest.builder()
                .tipoDocumento("Ra")
                .numeroDocumento(7654)
                .build();

        ResponseEntity entity = controller.crearPersona(personaRequest);

        assertEquals(HttpStatus.BAD_REQUEST, entity.getStatusCode());

    }

    @Test
    public void crearPersonaInternalError(){

        PostPersonaRequest personaRequest = PostPersonaRequest.builder()
                .tipoDocumento("P")
                .numeroDocumento(7654)
                .build();

        doThrow(new NullPointerException("")).when(personaService).guardarPersona(any());

        ResponseEntity entity = controller.crearPersona(personaRequest);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, entity.getStatusCode());

    }

}
