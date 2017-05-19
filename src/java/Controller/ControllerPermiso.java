/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;



import Entitys.Permisos;
import Facade.PermisosFacade;
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
    PermisosFacade facadepermiso;
    
    Permisos permiso;
    List<Permisos> listapermiso;
    /**
     * Creates a new instance of ControllerPermiso
     */
    public ControllerPermiso() {
    }
    @PostConstruct
    public void init(){
        permiso = new Permisos();
    }

    public Permisos getPermiso() {
        return permiso;
    }

    public void setPermiso(Permisos permiso) {
        this.permiso = permiso;
    }

    public List<Permisos> getListapermiso() {
        return listapermiso;
    }

    public void setListapermiso(List<Permisos> listapermiso) {
        this.listapermiso = listapermiso;
    }
    public String crearPermiso(){
        permiso.setPermisoHijo(facadepermiso.find(permiso.getIdpermiso()));
        facadepermiso.create(permiso);
        permiso = new Permisos();
        return "listarPermisos";
    }
    public List<Permisos> consultarPermiso(){
        this.listapermiso = facadepermiso.findAll();
        return listapermiso;
    }
    public String actualizarPermiso(){
        permiso.setPermisoHijo(facadepermiso.find(permiso.getIdpermiso()));
        facadepermiso.edit(permiso);
        return "listarPermisos";
    }
    public String actualizarPermiso(Permisos permiso){
        this.permiso = permiso;
        return "editarPermiso";
    }
    public void eliminarPermiso(Permisos permiso){
        facadepermiso.remove(permiso);
    }
}
