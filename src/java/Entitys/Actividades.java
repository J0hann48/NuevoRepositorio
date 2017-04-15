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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "actividades")
@NamedQueries({
    @NamedQuery(name = "Actividades.findAll", query = "SELECT a FROM Actividades a"),
    @NamedQuery(name = "Actividades.findByIdactividad", query = "SELECT a FROM Actividades a WHERE a.idactividad = :idactividad"),
    @NamedQuery(name = "Actividades.findByNombre", query = "SELECT a FROM Actividades a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Actividades.findByLugaract", query = "SELECT a FROM Actividades a WHERE a.lugaract = :lugaract"),
    @NamedQuery(name = "Actividades.findByFechaact", query = "SELECT a FROM Actividades a WHERE a.fechaact = :fechaact"),
    @NamedQuery(name = "Actividades.findByCostoact", query = "SELECT a FROM Actividades a WHERE a.costoact = :costoact")})
public class Actividades implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idactividad")
    private Integer idactividad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lugaract")
    private String lugaract;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaact")
    @Temporal(TemporalType.DATE)
    private Date fechaact;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costoact")
    private int costoact;
    @JoinColumn(name = "jardinidjardin", referencedColumnName = "idjardin")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Jardines jardinidjardin;

    public Actividades() {
    }

    public Actividades(Integer idactividad) {
        this.idactividad = idactividad;
    }

    public Actividades(Integer idactividad, String nombre, String lugaract, Date fechaact, int costoact) {
        this.idactividad = idactividad;
        this.nombre = nombre;
        this.lugaract = lugaract;
        this.fechaact = fechaact;
        this.costoact = costoact;
    }

    public Integer getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(Integer idactividad) {
        this.idactividad = idactividad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugaract() {
        return lugaract;
    }

    public void setLugaract(String lugaract) {
        this.lugaract = lugaract;
    }

    public Date getFechaact() {
        return fechaact;
    }

    public void setFechaact(Date fechaact) {
        this.fechaact = fechaact;
    }

    public int getCostoact() {
        return costoact;
    }

    public void setCostoact(int costoact) {
        this.costoact = costoact;
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
        hash += (idactividad != null ? idactividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividades)) {
            return false;
        }
        Actividades other = (Actividades) object;
        if ((this.idactividad == null && other.idactividad != null) || (this.idactividad != null && !this.idactividad.equals(other.idactividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Actividades[ idactividad=" + idactividad + " ]";
    }
    
}
