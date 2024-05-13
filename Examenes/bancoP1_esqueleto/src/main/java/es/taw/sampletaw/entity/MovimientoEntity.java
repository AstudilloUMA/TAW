package es.taw.sampletaw.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "MOVIMIENTO", schema = "BANCO", catalog = "")
public class MovimientoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "OPERACIONID", nullable = false)
    private Integer operacionid;
    @Basic
    @Column(name = "FECHA", nullable = false)
    private Timestamp fecha;
    @Basic
    @Column(name = "DESCRIPCION", nullable = false, length = 150)
    private String descripcion;
    @Basic
    @Column(name = "CANTIDAD", nullable = false, precision = 0)
    private Double cantidad;
    @ManyToOne
    @JoinColumn(name = "CUENTAORIGEN", referencedColumnName = "CUENTAID")
    private CuentaEntity cuentaByCuentaorigen;
    @ManyToOne
    @JoinColumn(name = "CUENTADESTINATARIO", referencedColumnName = "CUENTAID")
    private CuentaEntity cuentaByCuentadestinatario;
    @ManyToOne
    @JoinColumn(name = "TIPOOPERACION", referencedColumnName = "TIPOID")
    private TipooperacionEntity tipooperacionByTipooperacion;

    public Integer getOperacionid() {
        return operacionid;
    }

    public void setOperacionid(Integer operacionid) {
        this.operacionid = operacionid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovimientoEntity that = (MovimientoEntity) o;
        return Objects.equals(operacionid, that.operacionid) && Objects.equals(fecha, that.fecha) && Objects.equals(descripcion, that.descripcion) && Objects.equals(cantidad, that.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operacionid, fecha, descripcion, cantidad);
    }

    public CuentaEntity getCuentaByCuentaorigen() {
        return cuentaByCuentaorigen;
    }

    public void setCuentaByCuentaorigen(CuentaEntity cuentaByCuentaorigen) {
        this.cuentaByCuentaorigen = cuentaByCuentaorigen;
    }

    public CuentaEntity getCuentaByCuentadestinatario() {
        return cuentaByCuentadestinatario;
    }

    public void setCuentaByCuentadestinatario(CuentaEntity cuentaByCuentadestinatario) {
        this.cuentaByCuentadestinatario = cuentaByCuentadestinatario;
    }

    public TipooperacionEntity getTipooperacionByTipooperacion() {
        return tipooperacionByTipooperacion;
    }

    public void setTipooperacionByTipooperacion(TipooperacionEntity tipooperacionByTipooperacion) {
        this.tipooperacionByTipooperacion = tipooperacionByTipooperacion;
    }
}
