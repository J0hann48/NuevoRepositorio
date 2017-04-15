/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entitys.Rol;
import Facade.RolFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Johann48
 */
@Named(value = "controllerRol")
@SessionScoped
public class ControllerRol implements Serializable {

    @EJB
    RolFacade facaderol;
    
    private Rol rol;
    private List<Rol> listaRoles;
    
    /**
     * Creates a new instance of ControllerRol
     */
    public ControllerRol() {
    }
    @PostConstruct
    public void init(){
        rol = new Rol();
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<Rol> listaRoles) {
        this.listaRoles = listaRoles;
    }
    public String crearRol(){
        facaderol.create(rol);
        rol = new Rol();
        return "listarRoles";
    }
    public List<Rol> consultarRol(){
        this.listaRoles = facaderol.findAll();
        return listaRoles;
    }
    public String actualizarRol(Rol rol){
        this.rol = rol;
        return "listarRoles";
    }
    public String actualizarRol(){
        facaderol.edit(rol);
        rol = new Rol();
        return "listarRoles";
    }
    public void eliminarRol(Rol rol){
        facaderol.remove(rol);
    }
}
