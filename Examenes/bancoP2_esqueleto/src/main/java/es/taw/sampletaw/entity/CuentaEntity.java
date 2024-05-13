package es.taw.sampletaw.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CUENTA", schema = "BANCO", catalog = "")
public class CuentaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CUENTAID", nullable = false)
    private Integer cuentaid;
    @Basic
    @Column(name = "IBAN", nullable = false, length = 24)
    private String iban;
    @Basic
    @Column(name = "FECHACREACION", nullable = true)
    private Date fechacreacion;
    @Basic
    @Column(name = "SALDOACTUAL", nullable = true, precision = 0)
    private Double saldoactual;
    @ManyToOne
    @JoinColumn(name = "COMISION", referencedColumnName = "TIPOID")
    private TipocomisionEntity tipocomisionByComision;
    @OneToMany(mappedBy = "cuentaByCuentaid")
    private List<CuentaclienteEntity> cuentaclientesByCuentaid;
    @OneToMany(mappedBy = "cuentaByCuentaid")
    private List<MovimientoEntity> movimientosByCuentaid;

    public Integer getCuentaid() {
        return cuentaid;
    }

    public void setCuentaid(Integer cuentaid) {
        this.cuentaid = cuentaid;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Double getSaldoactual() {
        return saldoactual;
    }

    public void setSaldoactual(Double saldoactual) {
        this.saldoactual = saldoactual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuentaEntity that = (CuentaEntity) o;
        return Objects.equals(cuentaid, that.cuentaid) && Objects.equals(iban, that.iban) && Objects.equals(fechacreacion, that.fechacreacion) && Objects.equals(saldoactual, that.saldoactual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuentaid, iban, fechacreacion, saldoactual);
    }

    public TipocomisionEntity getTipocomisionByComision() {
        return tipocomisionByComision;
    }

    public void setTipocomisionByComision(TipocomisionEntity tipocomisionByComision) {
        this.tipocomisionByComision = tipocomisionByComision;
    }

    public List<CuentaclienteEntity> getCuentaclientesByCuentaid() {
        return cuentaclientesByCuentaid;
    }

    public void setCuentaclientesByCuentaid(List<CuentaclienteEntity> cuentaclientesByCuentaid) {
        this.cuentaclientesByCuentaid = cuentaclientesByCuentaid;
    }

    public List<MovimientoEntity> getMovimientosByCuentaid() {
        return movimientosByCuentaid;
    }

    public void setMovimientosByCuentaid(List<MovimientoEntity> movimientosByCuentaid) {
        this.movimientosByCuentaid = movimientosByCuentaid;
    }
}
