package org.amaris.controller.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.amaris.persistence.model.TipoDocumento;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostPersonaRequest {
    private String tipoDocumento;
    private long numeroDocumento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;

    private long telefono;
    private String direccion;
    private String ciudad;

}
