package es.taw.sampletaw.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TIPOCOMISION", schema = "BANCO", catalog = "")
public class TipocomisionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TIPOID", nullable = false)
    private Integer tipoid;
    @Basic
    @Column(name = "COMISION", nullable = true, length = 30)
    private String comision;
    @Basic
    @Column(name = "VALOR", nullable = true, precision = 0)
    private Double valor;
    @OneToMany(mappedBy = "tipocomisionByComision")
    private List<CuentaEntity> cuentasByTipoid;

    public Integer getTipoid() {
        return tipoid;
    }

    public void setTipoid(Integer tipoid) {
        this.tipoid = tipoid;
    }

    public String getComision() {
        return comision;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipocomisionEntity that = (TipocomisionEntity) o;
        return Objects.equals(tipoid, that.tipoid) && Objects.equals(comision, that.comision) && Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoid, comision, valor);
    }

    public List<CuentaEntity> getCuentasByTipoid() {
        return cuentasByTipoid;
    }

    public void setCuentasByTipoid(List<CuentaEntity> cuentasByTipoid) {
        this.cuentasByTipoid = cuentasByTipoid;
    }
}
