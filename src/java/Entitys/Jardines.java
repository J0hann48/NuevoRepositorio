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
@Table(name = "jardines")
@NamedQueries({
    @NamedQuery(name = "Jardines.findAll", query = "SELECT j FROM Jardines j"),
    @NamedQuery(name = "Jardines.findByIdjardin", query = "SELECT j FROM Jardines j WHERE j.idjardin = :idjardin"),
    @NamedQuery(name = "Jardines.findByNombre", query = "SELECT j FROM Jardines j WHERE j.nombre = :nombre"),
    @NamedQuery(name = "Jardines.findByDireccion", query = "SELECT j FROM Jardines j WHERE j.direccion = :direccion"),
    @NamedQuery(name = "Jardines.findByTelefonofijo", query = "SELECT j FROM Jardines j WHERE j.telefonofijo = :telefonofijo"),
    @NamedQuery(name = "Jardines.findByPresupuesto", query = "SELECT j FROM Jardines j WHERE j.presupuesto = :presupuesto")})
public class Jardines implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jardinidjardin", fetch = FetchType.EAGER)
    private List<Actividades> actividadesList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jardinidjardin", fetch = FetchType.EAGER)
    private List<Matricula> matriculaList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jardinidjardin", fetch = FetchType.EAGER)
    private List<Madrecomunitaria> madrecomunitariaList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idjardin")
    private Integer idjardin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefonofijo")
    private int telefonofijo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "presupuesto")
    private int presupuesto;

    public Jardines() {
    }

    public Jardines(Integer idjardin) {
        this.idjardin = idjardin;
    }

    public Jardines(Integer idjardin, String nombre, String direccion, int telefonofijo, int presupuesto) {
        this.idjardin = idjardin;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonofijo = telefonofijo;
        this.presupuesto = presupuesto;
    }

    public Integer getIdjardin() {
        return idjardin;
    }

    public void setIdjardin(Integer idjardin) {
        this.idjardin = idjardin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefonofijo() {
        return telefonofijo;
    }

    public void setTelefonofijo(int telefonofijo) {
        this.telefonofijo = telefonofijo;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idjardin != null ? idjardin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jardines)) {
            return false;
        }
        Jardines other = (Jardines) object;
        if ((this.idjardin == null && other.idjardin != null) || (this.idjardin != null && !this.idjardin.equals(other.idjardin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Jardines[ idjardin=" + idjardin + " ]";
    }

    public List<Madrecomunitaria> getMadrecomunitariaList() {
        return madrecomunitariaList;
    }

    public void setMadrecomunitariaList(List<Madrecomunitaria> madrecomunitariaList) {
        this.madrecomunitariaList = madrecomunitariaList;
    }

    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }

    public List<Actividades> getActividadesList() {
        return actividadesList;
    }

    public void setActividadesList(List<Actividades> actividadesList) {
        this.actividadesList = actividadesList;
    }
    
}
