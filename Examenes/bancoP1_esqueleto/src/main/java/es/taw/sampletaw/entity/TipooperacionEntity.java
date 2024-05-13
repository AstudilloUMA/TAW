package es.taw.sampletaw.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "TIPOOPERACION", schema = "BANCO", catalog = "")
public class TipooperacionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TIPOID", nullable = false)
    private Integer tipoid;
    @Basic
    @Column(name = "OPERACION", nullable = true, length = 30)
    private String operacion;
    @OneToMany(mappedBy = "tipooperacionByTipooperacion")
    private Collection<MovimientoEntity> movimientosByTipoid;

    public Integer getTipoid() {
        return tipoid;
    }

    public void setTipoid(Integer tipoid) {
        this.tipoid = tipoid;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipooperacionEntity that = (TipooperacionEntity) o;
        return Objects.equals(tipoid, that.tipoid) && Objects.equals(operacion, that.operacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoid, operacion);
    }

    public Collection<MovimientoEntity> getMovimientosByTipoid() {
        return movimientosByTipoid;
    }

    public void setMovimientosByTipoid(Collection<MovimientoEntity> movimientosByTipoid) {
        this.movimientosByTipoid = movimientosByTipoid;
    }
}
