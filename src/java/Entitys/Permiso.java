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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "permisos", catalog = "proyectojardin", schema = "")
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p"),
    @NamedQuery(name = "Permiso.findByIdpermiso", query = "SELECT p FROM Permiso p WHERE p.idpermiso = :idpermiso"),
    @NamedQuery(name = "Permiso.findByNombrepermiso", query = "SELECT p FROM Permiso p WHERE p.nombrepermiso = :nombrepermiso"),
    @NamedQuery(name = "Permiso.findByUrlpaginapermiso", query = "SELECT p FROM Permiso p WHERE p.urlpaginapermiso = :urlpaginapermiso"),
    @NamedQuery(name = "Permiso.findByDescripcionpermiso", query = "SELECT p FROM Permiso p WHERE p.descripcionpermiso = :descripcionpermiso")})
public class Permiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpermiso")
    private Integer idpermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombrepermiso")
    private String nombrepermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "urlpaginapermiso")
    private String urlpaginapermiso;
    @Size(max = 200)
    @Column(name = "descripcionpermiso")
    private String descripcionpermiso;

    public Permiso() {
    }

    public Permiso(Integer idpermiso) {
        this.idpermiso = idpermiso;
    }

    public Permiso(Integer idpermiso, String nombrepermiso, String urlpaginapermiso) {
        this.idpermiso = idpermiso;
        this.nombrepermiso = nombrepermiso;
        this.urlpaginapermiso = urlpaginapermiso;
    }

    public Integer getIdpermiso() {
        return idpermiso;
    }

    public void setIdpermiso(Integer idpermiso) {
        this.idpermiso = idpermiso;
    }

    public String getNombrepermiso() {
        return nombrepermiso;
    }

    public void setNombrepermiso(String nombrepermiso) {
        this.nombrepermiso = nombrepermiso;
    }

    public String getUrlpaginapermiso() {
        return urlpaginapermiso;
    }

    public void setUrlpaginapermiso(String urlpaginapermiso) {
        this.urlpaginapermiso = urlpaginapermiso;
    }

    public String getDescripcionpermiso() {
        return descripcionpermiso;
    }

    public void setDescripcionpermiso(String descripcionpermiso) {
        this.descripcionpermiso = descripcionpermiso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpermiso != null ? idpermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.idpermiso == null && other.idpermiso != null) || (this.idpermiso != null && !this.idpermiso.equals(other.idpermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Permiso[ idpermiso=" + idpermiso + " ]";
    }
    
}
