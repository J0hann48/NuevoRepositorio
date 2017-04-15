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
@Table(name = "asignaturas")
@NamedQueries({
    @NamedQuery(name = "Asignaturas.findAll", query = "SELECT a FROM Asignaturas a"),
    @NamedQuery(name = "Asignaturas.findByIdasignatura", query = "SELECT a FROM Asignaturas a WHERE a.idasignatura = :idasignatura"),
    @NamedQuery(name = "Asignaturas.findByNombre", query = "SELECT a FROM Asignaturas a WHERE a.nombre = :nombre")})
public class Asignaturas implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignaturasidasignatura", fetch = FetchType.EAGER)
    private List<Nota> notaList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idasignatura")
    private Integer idasignatura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;

    public Asignaturas() {
    }

    public Asignaturas(Integer idasignatura) {
        this.idasignatura = idasignatura;
    }

    public Asignaturas(Integer idasignatura, String nombre) {
        this.idasignatura = idasignatura;
        this.nombre = nombre;
    }

    public Integer getIdasignatura() {
        return idasignatura;
    }

    public void setIdasignatura(Integer idasignatura) {
        this.idasignatura = idasignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasignatura != null ? idasignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignaturas)) {
            return false;
        }
        Asignaturas other = (Asignaturas) object;
        if ((this.idasignatura == null && other.idasignatura != null) || (this.idasignatura != null && !this.idasignatura.equals(other.idasignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Asignaturas[ idasignatura=" + idasignatura + " ]";
    }
//
//    public List<Nota> getNotaList() {
//        return notaList;
//    }
//
//    public void setNotaList(List<Nota> notaList) {
//        this.notaList = notaList;
//    }
//    
}
