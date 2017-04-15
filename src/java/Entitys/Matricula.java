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
@Table(name = "matriculas")
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.findByIdmatricula", query = "SELECT m FROM Matricula m WHERE m.idmatricula = :idmatricula"),
    @NamedQuery(name = "Matricula.findByFechamatricula", query = "SELECT m FROM Matricula m WHERE m.fechamatricula = :fechamatricula"),
    @NamedQuery(name = "Matricula.findByFechafinmatricula", query = "SELECT m FROM Matricula m WHERE m.fechafinmatricula = :fechafinmatricula"),
    @NamedQuery(name = "Matricula.findByValormatricula", query = "SELECT m FROM Matricula m WHERE m.valormatricula = :valormatricula"),
    @NamedQuery(name = "Matricula.findByDescuento", query = "SELECT m FROM Matricula m WHERE m.descuento = :descuento"),
    @NamedQuery(name = "Matricula.findByTotalMatricula", query = "SELECT m FROM Matricula m WHERE m.totalMatricula = :totalMatricula")})
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmatricula")
    private Integer idmatricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechamatricula")
    @Temporal(TemporalType.DATE)
    private Date fechamatricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechafinmatricula")
    @Temporal(TemporalType.DATE)
    private Date fechafinmatricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valormatricula")
    private int valormatricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento")
    private int descuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalMatricula")
    private int totalMatricula;
    @JoinColumn(name = "alumnosidentificacion", referencedColumnName = "idalumno")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Alumnos alumnosidentificacion;
    @JoinColumn(name = "jardinidjardin", referencedColumnName = "idjardin")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Jardines jardinidjardin;

    public Matricula() {
    }

    public Matricula(Integer idmatricula) {
        this.idmatricula = idmatricula;
    }

    public Matricula(Integer idmatricula, Date fechamatricula, Date fechafinmatricula, int valormatricula, int descuento, int totalMatricula) {
        this.idmatricula = idmatricula;
        this.fechamatricula = fechamatricula;
        this.fechafinmatricula = fechafinmatricula;
        this.valormatricula = valormatricula;
        this.descuento = descuento;
        this.totalMatricula = totalMatricula;
    }

    public Integer getIdmatricula() {
        return idmatricula;
    }

    public void setIdmatricula(Integer idmatricula) {
        this.idmatricula = idmatricula;
    }

    public Date getFechamatricula() {
        return fechamatricula;
    }

    public void setFechamatricula(Date fechamatricula) {
        this.fechamatricula = fechamatricula;
    }

    public Date getFechafinmatricula() {
        return fechafinmatricula;
    }

    public void setFechafinmatricula(Date fechafinmatricula) {
        this.fechafinmatricula = fechafinmatricula;
    }

    public int getValormatricula() {
        return valormatricula;
    }

    public void setValormatricula(int valormatricula) {
        this.valormatricula = valormatricula;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getTotalMatricula() {
        return totalMatricula;
    }

    public void setTotalMatricula(int totalMatricula) {
        this.totalMatricula = totalMatricula;
    }

    public Alumnos getAlumnosidentificacion() {
        return alumnosidentificacion;
    }

    public void setAlumnosidentificacion(Alumnos alumnosidentificacion) {
        this.alumnosidentificacion = alumnosidentificacion;
    }

    public Jardines getJardinidjardin() {
        return jardinidjardin;
    }

    public void setJardinidjardin(Jardines jardinidjardin) {
        this.jardinidjardin = jardinidjardin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmatricula != null ? idmatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.idmatricula == null && other.idmatricula != null) || (this.idmatricula != null && !this.idmatricula.equals(other.idmatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Matricula[ idmatricula=" + idmatricula + " ]";
    }
    
}
