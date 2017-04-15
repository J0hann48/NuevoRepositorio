/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Johann48
 */
@Entity
@Table(name = "notas")
@NamedQueries({
    @NamedQuery(name = "Nota.findAll", query = "SELECT n FROM Nota n"),
    @NamedQuery(name = "Nota.findByIdnota", query = "SELECT n FROM Nota n WHERE n.idnota = :idnota"),
    @NamedQuery(name = "Nota.findByValornota", query = "SELECT n FROM Nota n WHERE n.valornota = :valornota"),
    @NamedQuery(name = "Nota.findByDescripcion", query = "SELECT n FROM Nota n WHERE n.descripcion = :descripcion")})
public class Nota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idnota")
    private Integer idnota;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valornota")
    private double valornota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 55)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "asignaturasidasignatura", referencedColumnName = "idasignatura")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Asignaturas asignaturasidasignatura;

    public Nota() {
    }

    public Nota(Integer idnota) {
        this.idnota = idnota;
    }

    public Nota(Integer idnota, double valornota, String descripcion) {
        this.idnota = idnota;
        this.valornota = valornota;
        this.descripcion = descripcion;
    }

    public Integer getIdnota() {
        return idnota;
    }

    public void setIdnota(Integer idnota) {
        this.idnota = idnota;
    }

    public double getValornota() {
        return valornota;
    }

    public void setValornota(double valornota) {
        this.valornota = valornota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Asignaturas getAsignaturasidasignatura() {
        return asignaturasidasignatura;
    }

    public void setAsignaturasidasignatura(Asignaturas asignaturasidasignatura) {
        this.asignaturasidasignatura = asignaturasidasignatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnota != null ? idnota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nota)) {
            return false;
        }
        Nota other = (Nota) object;
        if ((this.idnota == null && other.idnota != null) || (this.idnota != null && !this.idnota.equals(other.idnota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Nota[ idnota=" + idnota + " ]";
    }
    
}
