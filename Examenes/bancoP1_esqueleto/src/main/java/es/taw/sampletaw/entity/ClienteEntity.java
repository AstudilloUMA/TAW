package es.taw.sampletaw.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
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
    @Column(name = "NOMBRE", nullable = false, length = 15)
    private String nombre;
    @Basic
    @Column(name = "APELLIDOS", nullable = false, length = 50)
    private String apellidos;
    @Basic
    @Column(name = "NIE", nullable = false, length = 9)
    private String nie;
    @Basic
    @Column(name = "TELEFONO", nullable = true, length = 15)
    private String telefono;
    @Basic
    @Column(name = "EMAIL", nullable = true, length = 30)
    private String email;
    @Basic
    @Column(name = "FECHANACIMIENTO", nullable = true)
    private Date fechanacimiento;
    @Basic
    @Column(name = "FECHAALTA", nullable = true)
    private Timestamp fechaalta;
    @Basic
    @Column(name = "SEXO", nullable = false, length = 1)
    private String sexo;
    @Basic
    @Column(name = "NACIONALIDAD", nullable = false, length = 15)
    private String nacionalidad;
    @OneToMany(mappedBy = "clienteByTitular")
    private List<CuentaEntity> cuentasByClienteid;

    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public Timestamp getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Timestamp fechaalta) {
        this.fechaalta = fechaalta;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity that = (ClienteEntity) o;
        return Objects.equals(clienteid, that.clienteid) && Objects.equals(nombre, that.nombre) && Objects.equals(apellidos, that.apellidos) && Objects.equals(nie, that.nie) && Objects.equals(telefono, that.telefono) && Objects.equals(email, that.email) && Objects.equals(fechanacimiento, that.fechanacimiento) && Objects.equals(fechaalta, that.fechaalta) && Objects.equals(sexo, that.sexo) && Objects.equals(nacionalidad, that.nacionalidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clienteid, nombre, apellidos, nie, telefono, email, fechanacimiento, fechaalta, sexo, nacionalidad);
    }

    public List<CuentaEntity> getCuentasByClienteid() {
        return cuentasByClienteid;
    }

    public void setCuentasByClienteid(List<CuentaEntity> cuentasByClienteid) {
        this.cuentasByClienteid = cuentasByClienteid;
    }
}
