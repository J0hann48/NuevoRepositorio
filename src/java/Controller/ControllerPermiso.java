/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entitys.Permiso;
import Facade.PermisoFacade;
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
@Named(value = "controllerPermiso")
@SessionScoped
public class ControllerPermiso implements Serializable {

    @EJB
    PermisoFacade facadepermiso;
    
    Permiso permiso;
    List<Permiso> listapermiso;
    /**
     * Creates a new instance of ControllerPermiso
     */
    public ControllerPermiso() {
    }
    @PostConstruct
    public void init(){
        permiso = new Permiso();
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public List<Permiso> getListapermiso() {
        return listapermiso;
    }

    public void setListapermiso(List<Permiso> listapermiso) {
        this.listapermiso = listapermiso;
    }
    public String crearPermiso(){
        facadepermiso.create(permiso);
        permiso = new Permiso();
        return "listarPermisos";
    }
    public List<Permiso> consultarPermiso(){
        this.listapermiso = facadepermiso.findAll();
        return listapermiso;
    }
    public String actualizarPermiso(){
        facadepermiso.edit(permiso);
        return "listarPermisos";
    }
    public String actualizarPermiso(Permiso permiso){
        this.permiso = permiso;
        return "editarPermiso";
    }
    public void eliminarPermiso(Permiso permiso){
        facadepermiso.remove(permiso);
    }
}
