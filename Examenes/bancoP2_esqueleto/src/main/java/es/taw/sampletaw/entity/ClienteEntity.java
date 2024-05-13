package es.taw.sampletaw.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CLIENTE", schema = "BANCO", catalog = "")
public class ClienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CLIENTEID", nullable = false)
    private Integer clienteid;
    @Basic
    @Column(name = "NOMBRECOMPLETO", nullable = false, length = 75)
    private String nombrecompleto;
    @Basic
    @Column(name = "NIE", nullable = false, length = 9)
    private String nie;
    @Basic
    @Column(name = "TELEFONO", nullable = false, length = 12)
    private String telefono;
    @Basic
    @Column(name = "EMAIL", nullable = false, length = 25)
    private String email;
    @Basic
    @Column(name = "FECHANACIMIENTO", nullable = true)
    private Date fechanacimiento;
    @OneToMany(mappedBy = "clienteByClienteid")
    private List<CuentaclienteEntity> cuentaclientesByClienteid;

    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getNie() {
        return nie;
    }

    public void setNie(String nie) {
        this.nie = nie;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity that = (ClienteEntity) o;
        return Objects.equals(clienteid, that.clienteid) && Objects.equals(nombrecompleto, that.nombrecompleto) && Objects.equals(nie, that.nie) && Objects.equals(telefono, that.telefono) && Objects.equals(email, that.email) && Objects.equals(fechanacimiento, that.fechanacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clienteid, nombrecompleto, nie, telefono, email, fechanacimiento);
    }

    public List<CuentaclienteEntity> getCuentaclientesByClienteid() {
        return cuentaclientesByClienteid;
    }

    public void setCuentaclientesByClienteid(List<CuentaclienteEntity> cuentaclientesByClienteid) {
        this.cuentaclientesByClienteid = cuentaclientesByClienteid;
    }
}
