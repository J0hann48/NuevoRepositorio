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
import javax.persistence.Id;
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
@Table(name = "sugerencias")
@NamedQueries({
    @NamedQuery(name = "Sugerencias.findAll", query = "SELECT s FROM Sugerencias s"),
    @NamedQuery(name = "Sugerencias.findByIdsugerencia", query = "SELECT s FROM Sugerencias s WHERE s.idsugerencia = :idsugerencia"),
    @NamedQuery(name = "Sugerencias.findByDescripcion", query = "SELECT s FROM Sugerencias s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "Sugerencias.findByAsunto", query = "SELECT s FROM Sugerencias s WHERE s.asunto = :asunto")})
public class Sugerencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idsugerencia")
    private Integer idsugerencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "asunto")
    private String asunto;

    public Sugerencias() {
    }

    public Sugerencias(Integer idsugerencia) {
        this.idsugerencia = idsugerencia;
    }

    public Sugerencias(Integer idsugerencia, String descripcion, String asunto) {
        this.idsugerencia = idsugerencia;
        this.descripcion = descripcion;
        this.asunto = asunto;
    }

    public Integer getIdsugerencia() {
        return idsugerencia;
    }

    public void setIdsugerencia(Integer idsugerencia) {
        this.idsugerencia = idsugerencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsugerencia != null ? idsugerencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sugerencias)) {
            return false;
        }
        Sugerencias other = (Sugerencias) object;
        if ((this.idsugerencia == null && other.idsugerencia != null) || (this.idsugerencia != null && !this.idsugerencia.equals(other.idsugerencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Sugerencias[ idsugerencia=" + idsugerencia + " ]";
    }
    
}
