/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Johann48
 */
@Entity
@Table(name = "nutricionalumnos")
@NamedQueries({
    @NamedQuery(name = "Nutricionalumnos.findAll", query = "SELECT n FROM Nutricionalumnos n"),
    @NamedQuery(name = "Nutricionalumnos.findByIdnutricionalumno", query = "SELECT n FROM Nutricionalumnos n WHERE n.idnutricionalumno = :idnutricionalumno"),
    @NamedQuery(name = "Nutricionalumnos.findByPeso", query = "SELECT n FROM Nutricionalumnos n WHERE n.peso = :peso"),
    @NamedQuery(name = "Nutricionalumnos.findByTalla", query = "SELECT n FROM Nutricionalumnos n WHERE n.talla = :talla"),
    @NamedQuery(name = "Nutricionalumnos.findByEstatura", query = "SELECT n FROM Nutricionalumnos n WHERE n.estatura = :estatura"),
    @NamedQuery(name = "Nutricionalumnos.findByFechaingresonutricion", query = "SELECT n FROM Nutricionalumnos n WHERE n.fechaingresonutricion = :fechaingresonutricion")})
public class Nutricionalumnos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnutricionalumno")
    private Integer idnutricionalumno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "peso")
    private double peso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "talla")
    private double talla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estatura")
    private double estatura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaingresonutricion")
    @Temporal(TemporalType.DATE)
    private Date fechaingresonutricion;
    @JoinColumn(name = "idcrecimientodesarrollo", referencedColumnName = "idCrecimientoDesarrollo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Crecimientodesarrollo idcrecimientodesarrollo;
    @JoinColumn(name = "alumnosidentificacion", referencedColumnName = "idalumno")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Alumnos alumnosidentificacion;

    public Nutricionalumnos() {
    }

    public Nutricionalumnos(Integer idnutricionalumno) {
        this.idnutricionalumno = idnutricionalumno;
    }

    public Nutricionalumnos(Integer idnutricionalumno, double peso, double talla, double estatura, Date fechaingresonutricion) {
        this.idnutricionalumno = idnutricionalumno;
        this.peso = peso;
        this.talla = talla;
        this.estatura = estatura;
        this.fechaingresonutricion = fechaingresonutricion;
    }

    public Integer getIdnutricionalumno() {
        return idnutricionalumno;
    }

    public void setIdnutricionalumno(Integer idnutricionalumno) {
        this.idnutricionalumno = idnutricionalumno;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public Date getFechaingresonutricion() {
        return fechaingresonutricion;
    }

    public void setFechaingresonutricion(Date fechaingresonutricion) {
        this.fechaingresonutricion = fechaingresonutricion;
    }

    public Crecimientodesarrollo getIdcrecimientodesarrollo() {
        return idcrecimientodesarrollo;
    }

    public void setIdcrecimientodesarrollo(Crecimientodesarrollo idcrecimientodesarrollo) {
        this.idcrecimientodesarrollo = idcrecimientodesarrollo;
    }

    public Alumnos getAlumnosidentificacion() {
        return alumnosidentificacion;
    }

    public void setAlumnosidentificacion(Alumnos alumnosidentificacion) {
        this.alumnosidentificacion = alumnosidentificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnutricionalumno != null ? idnutricionalumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nutricionalumnos)) {
            return false;
        }
        Nutricionalumnos other = (Nutricionalumnos) object;
        if ((this.idnutricionalumno == null && other.idnutricionalumno != null) || (this.idnutricionalumno != null && !this.idnutricionalumno.equals(other.idnutricionalumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Nutricionalumnos[ idnutricionalumno=" + idnutricionalumno + " ]";
    }
    
}
