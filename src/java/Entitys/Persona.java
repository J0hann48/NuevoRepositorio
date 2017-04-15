/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Johann48
 */
@Entity
@Table(name = "personas")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdentificacion", query = "SELECT p FROM Persona p WHERE p.identificacion = :identificacion"),
    @NamedQuery(name = "Persona.findByNombre1", query = "SELECT p FROM Persona p WHERE p.nombre1 = :nombre1"),
    @NamedQuery(name = "Persona.findByNombre2", query = "SELECT p FROM Persona p WHERE p.nombre2 = :nombre2"),
    @NamedQuery(name = "Persona.findByApellido1", query = "SELECT p FROM Persona p WHERE p.apellido1 = :apellido1"),
    @NamedQuery(name = "Persona.findByApellido2", query = "SELECT p FROM Persona p WHERE p.apellido2 = :apellido2"),
    @NamedQuery(name = "Persona.findByTipodocumento", query = "SELECT p FROM Persona p WHERE p.tipodocumento = :tipodocumento"),
    @NamedQuery(name = "Persona.findBySexo", query = "SELECT p FROM Persona p WHERE p.sexo = :sexo")})
public class Persona implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaidentificacion", fetch = FetchType.EAGER)
    private List<Alumnos> alumnosList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuariosidentificacion", fetch = FetchType.EAGER)
    private List<Padresfamilia> padresfamiliaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personaidentificacion", fetch = FetchType.EAGER)
    private List<Usuarios> usuariosList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "identificacion")
    private Integer identificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre1")
    private String nombre1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre2")
    private String nombre2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "apellido1")
    private String apellido1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "apellido2")
    private String apellido2;
    @Size(max = 30)
    @Column(name = "tipodocumento")
    private String tipodocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "sexo")
    private String sexo;

    public Persona() {
    }

    public Persona(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public Persona(Integer identificacion, String nombre1, String nombre2, String apellido1, String apellido2, String sexo) {
        this.identificacion = identificacion;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.sexo = sexo;
    }

    public Integer getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Integer identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacion != null ? identificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Persona[ identificacion=" + identificacion + " ]";
    }    

    public List<Padresfamilia> getPadresfamiliaList() {
        return padresfamiliaList;
    }

    public void setPadresfamiliaList(List<Padresfamilia> padresfamiliaList) {
        this.padresfamiliaList = padresfamiliaList;
    }

    public List<Alumnos> getAlumnosList() {
        return alumnosList;
    }

    public void setAlumnosList(List<Alumnos> alumnosList) {
        this.alumnosList = alumnosList;
    }
}
