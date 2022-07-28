package org.amaris.persistence.controller;

import org.amaris.persistence.model.Persona;
import org.amaris.persistence.model.PersonaID;
import org.amaris.persistence.model.TipoDocumento;
import org.amaris.persistence.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Repository
public class PersistenceController {
    @Autowired
    private PersonaRepository personaRepository;

    public Optional<Persona> getPersona(TipoDocumento tipoDocumento, Long numeroDocumento){
        return personaRepository.findById(new PersonaID(tipoDocumento, numeroDocumento));
    }

    public void crearPersona(Persona persona){
        personaRepository.save(persona);
    }

}
