package es.taw.sampletaw.entity;

import javax.persistence.*;
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
    @Column(name = "ACTIVA", nullable = true)
    private Short activa;
    @Basic
    @Column(name = "SALDOACTUAL", nullable = true, precision = 0)
    private Double saldoactual;
    @ManyToOne
    @JoinColumn(name = "TITULAR", referencedColumnName = "CLIENTEID")
    private ClienteEntity clienteByTitular;
    @OneToMany(mappedBy = "cuentaByCuentaorigen")
    private List<MovimientoEntity> movimientosByCuentaOrigen;
    @OneToMany(mappedBy = "cuentaByCuentadestinatario")
    private List<MovimientoEntity> movimientosByCuentaDestinatario;

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

    public Short getActiva() {
        return activa;
    }

    public void setActiva(Short activa) {
        this.activa = activa;
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
        return Objects.equals(cuentaid, that.cuentaid) && Objects.equals(iban, that.iban) && Objects.equals(activa, that.activa) && Objects.equals(saldoactual, that.saldoactual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuentaid, iban, activa, saldoactual);
    }

    public ClienteEntity getClienteByTitular() {
        return clienteByTitular;
    }

    public void setClienteByTitular(ClienteEntity clienteByTitular) {
        this.clienteByTitular = clienteByTitular;
    }

    public List<MovimientoEntity> getMovimientosByCuentaOrigen() {
        return movimientosByCuentaOrigen;
    }

    public void setMovimientosByCuentaOrigen(List<MovimientoEntity> movimientosByCuentaOrigen) {
        this.movimientosByCuentaOrigen = movimientosByCuentaOrigen;
    }

    public List<MovimientoEntity> getMovimientosByCuentaDestinatario() {
        return movimientosByCuentaDestinatario;
    }

    public void setMovimientosByCuentaDestinatario(List<MovimientoEntity> movimientosByCuentaDestinatario) {
        this.movimientosByCuentaDestinatario = movimientosByCuentaDestinatario;
    }
}
