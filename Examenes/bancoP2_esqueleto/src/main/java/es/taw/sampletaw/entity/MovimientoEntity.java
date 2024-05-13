package es.taw.sampletaw.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "MOVIMIENTO", schema = "BANCO", catalog = "")
public class MovimientoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "MOVIMIENTOID", nullable = false)
    private Integer movimientoid;
    @Basic
    @Column(name = "FECHA", nullable = true)
    private Timestamp fecha;
    @Basic
    @Column(name = "DESCRIPCION", nullable = true, length = 150)
    private String descripcion;
    @Basic
    @Column(name = "CANTIDAD", nullable = true, precision = 0)
    private Double cantidad;
    @Basic
    @Column(name = "COMISIONAPLICADA", nullable = true)
    private Short comisionaplicada;
    @ManyToOne
    @JoinColumn(name = "CUENTAID", referencedColumnName = "CUENTAID")
    private CuentaEntity cuentaByCuentaid;

    public Integer getMovimientoid() {
        return movimientoid;
    }

    public void setMovimientoid(Integer movimientoid) {
        this.movimientoid = movimientoid;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Short getComisionaplicada() {
        return comisionaplicada;
    }

    public void setComisionaplicada(Short comisionaplicada) {
        this.comisionaplicada = comisionaplicada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovimientoEntity that = (MovimientoEntity) o;
        return Objects.equals(movimientoid, that.movimientoid) && Objects.equals(fecha, that.fecha) && Objects.equals(descripcion, that.descripcion) && Objects.equals(cantidad, that.cantidad) && Objects.equals(comisionaplicada, that.comisionaplicada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movimientoid, fecha, descripcion, cantidad, comisionaplicada);
    }

    public CuentaEntity getCuentaByCuentaid() {
        return cuentaByCuentaid;
    }

    public void setCuentaByCuentaid(CuentaEntity cuentaByCuentaid) {
        this.cuentaByCuentaid = cuentaByCuentaid;
    }

    @Override
    public String toString() {
        return this.fecha + " - " + this.descripcion + " - (" + this.cantidad + ")";
    }
}
