package org.amaris.persistence.model;

public enum TipoDocumento {
    C("Cédula de ciudadania"), P("Pasaporte");

    private String value;
    TipoDocumento(String val){
        this.value = val;
    }

    public String getValue(){
        return this.value;
    }
}
