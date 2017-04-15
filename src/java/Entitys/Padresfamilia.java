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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "padresfamilia")
@NamedQueries({
    @NamedQuery(name = "Padresfamilia.findAll", query = "SELECT p FROM Padresfamilia p"),
    @NamedQuery(name = "Padresfamilia.findByIdpadrefamilia", query = "SELECT p FROM Padresfamilia p WHERE p.idpadrefamilia = :idpadrefamilia"),
    @NamedQuery(name = "Padresfamilia.findByDireccion", query = "SELECT p FROM Padresfamilia p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Padresfamilia.findByEstrato", query = "SELECT p FROM Padresfamilia p WHERE p.estrato = :estrato")})
public class Padresfamilia implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "padrefamiliaidentificacion", fetch = FetchType.EAGER)
    private List<Alumnos> alumnosList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpadrefamilia")
    private Integer idpadrefamilia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estrato")
    private int estrato;
    @JoinColumn(name = "usuariosidentificacion", referencedColumnName = "identificacion")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Persona usuariosidentificacion;

    public Padresfamilia() {
    }

    public Padresfamilia(Integer idpadrefamilia) {
        this.idpadrefamilia = idpadrefamilia;
    }

    public Padresfamilia(Integer idpadrefamilia, String direccion, int estrato) {
        this.idpadrefamilia = idpadrefamilia;
        this.direccion = direccion;
        this.estrato = estrato;
    }

    public Integer getIdpadrefamilia() {
        return idpadrefamilia;
    }

    public void setIdpadrefamilia(Integer idpadrefamilia) {
        this.idpadrefamilia = idpadrefamilia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
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
        hash += (idpadrefamilia != null ? idpadrefamilia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Padresfamilia)) {
            return false;
        }
        Padresfamilia other = (Padresfamilia) object;
        if ((this.idpadrefamilia == null && other.idpadrefamilia != null) || (this.idpadrefamilia != null && !this.idpadrefamilia.equals(other.idpadrefamilia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Padresfamilia[ idpadrefamilia=" + idpadrefamilia + " ]";
    }

    public List<Alumnos> getAlumnosList() {
        return alumnosList;
    }

    public void setAlumnosList(List<Alumnos> alumnosList) {
        this.alumnosList = alumnosList;
    }
    
}
