package org.amaris.persistence.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

public class PersonaID implements Serializable {
    @Enumerated(EnumType.ORDINAL)
    private TipoDocumento tipoDocumento;
    private Long numeroDocumento;

    public PersonaID(TipoDocumento tipoDocumento, Long numeroDocumento) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
    }

    public PersonaID(){

    }

}
