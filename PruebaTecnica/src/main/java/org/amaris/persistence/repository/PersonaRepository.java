package org.amaris.persistence.repository;

import org.amaris.persistence.model.Persona;
import org.amaris.persistence.model.PersonaID;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<Persona, PersonaID> {
}
