package es.taw.sampletaw.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ROLCLIENTE", schema = "BANCO", catalog = "")
public class RolclienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ROLID", nullable = false)
    private Integer rolid;
    @Basic
    @Column(name = "DESCRIPCION", nullable = true, length = 30)
    private String descripcion;
    @OneToMany(mappedBy = "rolclienteByRolid")
    private List<CuentaclienteEntity> cuentaclientesByRolid;

    public Integer getRolid() {
        return rolid;
    }

    public void setRolid(Integer rolid) {
        this.rolid = rolid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolclienteEntity that = (RolclienteEntity) o;
        return Objects.equals(rolid, that.rolid) && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolid, descripcion);
    }

    public List<CuentaclienteEntity> getCuentaclientesByRolid() {
        return cuentaclientesByRolid;
    }

    public void setCuentaclientesByRolid(List<CuentaclienteEntity> cuentaclientesByRolid) {
        this.cuentaclientesByRolid = cuentaclientesByRolid;
    }
}
