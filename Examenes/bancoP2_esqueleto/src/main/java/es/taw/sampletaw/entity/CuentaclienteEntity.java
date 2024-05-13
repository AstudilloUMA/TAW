package es.taw.sampletaw.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CUENTACLIENTE", schema = "BANCO", catalog = "")
public class CuentaclienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CUENTACLIENTEID", nullable = false)
    private Integer cuentaclienteid;
    @ManyToOne
    @JoinColumn(name = "CUENTAID", referencedColumnName = "CUENTAID")
    private CuentaEntity cuentaByCuentaid;
    @ManyToOne
    @JoinColumn(name = "CLIENTEID", referencedColumnName = "CLIENTEID")
    private ClienteEntity clienteByClienteid;
    @ManyToOne
    @JoinColumn(name = "ROLID", referencedColumnName = "ROLID")
    private RolclienteEntity rolclienteByRolid;

    public Integer getCuentaclienteid() {
        return cuentaclienteid;
    }

    public void setCuentaclienteid(Integer cuentaclienteid) {
        this.cuentaclienteid = cuentaclienteid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CuentaclienteEntity that = (CuentaclienteEntity) o;
        return Objects.equals(cuentaclienteid, that.cuentaclienteid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cuentaclienteid);
    }

    public CuentaEntity getCuentaByCuentaid() {
        return cuentaByCuentaid;
    }

    public void setCuentaByCuentaid(CuentaEntity cuentaByCuentaid) {
        this.cuentaByCuentaid = cuentaByCuentaid;
    }

    public ClienteEntity getClienteByClienteid() {
        return clienteByClienteid;
    }

    public void setClienteByClienteid(ClienteEntity clienteByClienteid) {
        this.clienteByClienteid = clienteByClienteid;
    }

    public RolclienteEntity getRolclienteByRolid() {
        return rolclienteByRolid;
    }

    public void setRolclienteByRolid(RolclienteEntity rolclienteByRolid) {
        this.rolclienteByRolid = rolclienteByRolid;
    }
}
