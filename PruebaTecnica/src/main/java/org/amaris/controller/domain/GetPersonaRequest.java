package org.amaris.controller.domain;

import org.amaris.persistence.model.TipoDocumento;

public class GetPersonaRequest {
    private TipoDocumento tipoDocumento;
    private Long numeroDocumento;

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Long getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Long numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
}
