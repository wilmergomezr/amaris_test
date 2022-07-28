package org.amaris.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity(name="persona")
@IdClass(PersonaID.class)
public class Persona {

    @Id
    @Enumerated(EnumType.ORDINAL)
    private TipoDocumento tipoDocumento;
    @Id
    private long numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;

    private long telefono;
    private String direccion;
    private String ciudad;

}
