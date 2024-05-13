package es.taw.sampletaw.ui;

import es.taw.sampletaw.entity.TipocomisionEntity;

public class Filtro {
    private TipocomisionEntity tipoComision;
    private Double saldoMin;

    public Filtro()
    {
        this.tipoComision = null;
        this.saldoMin = null;
    }

    public TipocomisionEntity getTipoComision() {
        return tipoComision;
    }

    public void setTipoComision(TipocomisionEntity tipoComision) {
        this.tipoComision = tipoComision;
    }

    public Double getSaldoMin() {
        return this.saldoMin;
    }

    public void setSaldoMin(Double saldoMin) {
        this.saldoMin = saldoMin;
    }
}
