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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "madrescomunitarias")
@NamedQueries({
    @NamedQuery(name = "Madrecomunitaria.findAll", query = "SELECT m FROM Madrecomunitaria m"),
    @NamedQuery(name = "Madrecomunitaria.findByIdmadrecomunitaria", query = "SELECT m FROM Madrecomunitaria m WHERE m.idmadrecomunitaria = :idmadrecomunitaria"),
    @NamedQuery(name = "Madrecomunitaria.findByCargo", query = "SELECT m FROM Madrecomunitaria m WHERE m.cargo = :cargo")})
public class Madrecomunitaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmadrecomunitaria")
    private Integer idmadrecomunitaria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "cargo")
    private String cargo;
    @JoinColumn(name = "jardinidjardin", referencedColumnName = "idjardin")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Jardines jardinidjardin;
    @JoinColumn(name = "usuariosidentificacion", referencedColumnName = "identificacion")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Persona usuariosidentificacion;

    public Madrecomunitaria() {
    }

    public Madrecomunitaria(Integer idmadrecomunitaria) {
        this.idmadrecomunitaria = idmadrecomunitaria;
    }

    public Madrecomunitaria(Integer idmadrecomunitaria, String cargo) {
        this.idmadrecomunitaria = idmadrecomunitaria;
        this.cargo = cargo;
    }

    public Integer getIdmadrecomunitaria() {
        return idmadrecomunitaria;
    }

    public void setIdmadrecomunitaria(Integer idmadrecomunitaria) {
        this.idmadrecomunitaria = idmadrecomunitaria;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Jardines getJardinidjardin() {
        return jardinidjardin;
    }

    public void setJardinidjardin(Jardines jardinidjardin) {
        this.jardinidjardin = jardinidjardin;
    }

    public Persona getUsuariosidentificacion() {
        return usuariosidentificacion;
    }

    public void setUsuariosidentificacion(Persona usuariosidentificacion) {
        this.usuariosidentificacion = usuariosidentificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmadrecomunitaria != null ? idmadrecomunitaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Madrecomunitaria)) {
            return false;
        }
        Madrecomunitaria other = (Madrecomunitaria) object;
        if ((this.idmadrecomunitaria == null && other.idmadrecomunitaria != null) || (this.idmadrecomunitaria != null && !this.idmadrecomunitaria.equals(other.idmadrecomunitaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Madrecomunitaria[ idmadrecomunitaria=" + idmadrecomunitaria + " ]";
    }
    
}
