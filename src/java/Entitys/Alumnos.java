/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Johann48
 */
@Entity
@Table(name = "alumnos")
@NamedQueries({
    @NamedQuery(name = "Alumnos.findAll", query = "SELECT a FROM Alumnos a"),
    @NamedQuery(name = "Alumnos.findByIdalumno", query = "SELECT a FROM Alumnos a WHERE a.idalumno = :idalumno"),
    @NamedQuery(name = "Alumnos.findByFechaNacimiento", query = "SELECT a FROM Alumnos a WHERE a.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Alumnos.findByFechaingreso", query = "SELECT a FROM Alumnos a WHERE a.fechaingreso = :fechaingreso"),
    @NamedQuery(name = "Alumnos.findByFechasalida", query = "SELECT a FROM Alumnos a WHERE a.fechasalida = :fechasalida"),
    @NamedQuery(name = "Alumnos.findByObservaciones", query = "SELECT a FROM Alumnos a WHERE a.observaciones = :observaciones")})
public class Alumnos implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumnosidentificacion", fetch = FetchType.EAGER)
    private List<Matricula> matriculaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumnosidentificacion", fetch = FetchType.EAGER)
    private List<Nutricionalumnos> nutricionalumnosList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idalumno")
    private Integer idalumno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;
    @Column(name = "fechasalida")
    @Temporal(TemporalType.DATE)
    private Date fechasalida;
    @Size(max = 250)
    @Column(name = "observaciones")
    private String observaciones;
    @JoinColumn(name = "padrefamiliaidentificacion", referencedColumnName = "idpadrefamilia")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Padresfamilia padrefamiliaidentificacion;
    @JoinColumn(name = "personaidentificacion", referencedColumnName = "identificacion")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Persona personaidentificacion;

    public Alumnos() {
    }

    public Alumnos(Integer idalumno) {
        this.idalumno = idalumno;
    }

    public Alumnos(Integer idalumno, Date fechaNacimiento, Date fechaingreso) {
        this.idalumno = idalumno;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaingreso = fechaingreso;
    }

    public Integer getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Integer idalumno) {
        this.idalumno = idalumno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Padresfamilia getPadrefamiliaidentificacion() {
        return padrefamiliaidentificacion;
    }

    public void setPadrefamiliaidentificacion(Padresfamilia padrefamiliaidentificacion) {
        this.padrefamiliaidentificacion = padrefamiliaidentificacion;
    }

    public Persona getPersonaidentificacion() {
        return personaidentificacion;
    }

    public void setPersonaidentificacion(Persona personaidentificacion) {
        this.personaidentificacion = personaidentificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalumno != null ? idalumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumnos)) {
            return false;
        }
        Alumnos other = (Alumnos) object;
        if ((this.idalumno == null && other.idalumno != null) || (this.idalumno != null && !this.idalumno.equals(other.idalumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Alumnos[ idalumno=" + idalumno + " ]";
    }

    public List<Nutricionalumnos> getNutricionalumnosList() {
        return nutricionalumnosList;
    }

    public void setNutricionalumnosList(List<Nutricionalumnos> nutricionalumnosList) {
        this.nutricionalumnosList = nutricionalumnosList;
    }

    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }
    
}
