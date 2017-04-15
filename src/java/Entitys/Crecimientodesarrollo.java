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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Johann48
 */
@Entity
@Table(name = "crecimientodesarrollo")
@NamedQueries({
    @NamedQuery(name = "Crecimientodesarrollo.findAll", query = "SELECT c FROM Crecimientodesarrollo c"),
    @NamedQuery(name = "Crecimientodesarrollo.findByIdCrecimientoDesarrollo", query = "SELECT c FROM Crecimientodesarrollo c WHERE c.idCrecimientoDesarrollo = :idCrecimientoDesarrollo"),
    @NamedQuery(name = "Crecimientodesarrollo.findByEdad", query = "SELECT c FROM Crecimientodesarrollo c WHERE c.edad = :edad"),
    @NamedQuery(name = "Crecimientodesarrollo.findByPesoMedio", query = "SELECT c FROM Crecimientodesarrollo c WHERE c.pesoMedio = :pesoMedio"),
    @NamedQuery(name = "Crecimientodesarrollo.findByTalla", query = "SELECT c FROM Crecimientodesarrollo c WHERE c.talla = :talla"),
    @NamedQuery(name = "Crecimientodesarrollo.findByPesoEstatura", query = "SELECT c FROM Crecimientodesarrollo c WHERE c.pesoEstatura = :pesoEstatura")})
public class Crecimientodesarrollo implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcrecimientodesarrollo", fetch = FetchType.EAGER)
    private List<Nutricionalumnos> nutricionalumnosList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCrecimientoDesarrollo")
    private Integer idCrecimientoDesarrollo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pesoMedio")
    private double pesoMedio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "talla")
    private double talla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pesoEstatura")
    private double pesoEstatura;

    public Crecimientodesarrollo() {
    }

    public Crecimientodesarrollo(Integer idCrecimientoDesarrollo) {
        this.idCrecimientoDesarrollo = idCrecimientoDesarrollo;
    }

    public Crecimientodesarrollo(Integer idCrecimientoDesarrollo, int edad, double pesoMedio, double talla, double pesoEstatura) {
        this.idCrecimientoDesarrollo = idCrecimientoDesarrollo;
        this.edad = edad;
        this.pesoMedio = pesoMedio;
        this.talla = talla;
        this.pesoEstatura = pesoEstatura;
    }

    public Integer getIdCrecimientoDesarrollo() {
        return idCrecimientoDesarrollo;
    }

    public void setIdCrecimientoDesarrollo(Integer idCrecimientoDesarrollo) {
        this.idCrecimientoDesarrollo = idCrecimientoDesarrollo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPesoMedio() {
        return pesoMedio;
    }

    public void setPesoMedio(double pesoMedio) {
        this.pesoMedio = pesoMedio;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    public double getPesoEstatura() {
        return pesoEstatura;
    }

    public void setPesoEstatura(double pesoEstatura) {
        this.pesoEstatura = pesoEstatura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCrecimientoDesarrollo != null ? idCrecimientoDesarrollo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Crecimientodesarrollo)) {
            return false;
        }
        Crecimientodesarrollo other = (Crecimientodesarrollo) object;
        if ((this.idCrecimientoDesarrollo == null && other.idCrecimientoDesarrollo != null) || (this.idCrecimientoDesarrollo != null && !this.idCrecimientoDesarrollo.equals(other.idCrecimientoDesarrollo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entitys.Crecimientodesarrollo[ idCrecimientoDesarrollo=" + idCrecimientoDesarrollo + " ]";
    }

    public List<Nutricionalumnos> getNutricionalumnosList() {
        return nutricionalumnosList;
    }

    public void setNutricionalumnosList(List<Nutricionalumnos> nutricionalumnosList) {
        this.nutricionalumnosList = nutricionalumnosList;
    }
    
}
