package org.amaris.service;

import org.amaris.controller.domain.PostPersonaRequest;
import org.amaris.persistence.model.Persona;
import org.amaris.persistence.model.TipoDocumento;

import java.util.Optional;

public interface PersonaService {

    public void guardarPersona(PostPersonaRequest persona);

    public Optional<Persona> getPersona(TipoDocumento tipoDocumento, Long numeroDocumento);

}
