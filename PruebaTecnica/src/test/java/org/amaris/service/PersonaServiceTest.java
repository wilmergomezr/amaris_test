package org.amaris.service;

import org.amaris.controller.domain.PostPersonaRequest;
import org.amaris.persistence.controller.PersistenceController;
import org.amaris.service.impl.PersonaServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonaServiceTest {

    @InjectMocks
    PersonaServiceImpl personaService;

    @Mock
    PersistenceController persistenceController;

    private PostPersonaRequest personaRequest;

    @BeforeEach
    public void setup(){
        personaRequest = PostPersonaRequest.builder()
                .tipoDocumento("P")
                .numeroDocumento(2345)
                .build();
    }

    @Test
    public void guardarPersonaSuccess() {

        doNothing().when(persistenceController).crearPersona(any());

        personaService.guardarPersona(personaRequest);

        verify(persistenceController).crearPersona(any());
    }

    @Test
    public void guardarPersonaErrorMap() {
        try {
            personaService.guardarPersona(PostPersonaRequest.builder().build());
        } catch (Exception e) {
            return;
        }
        Assertions.fail();
    }
}
