/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entitys.Jardines;
import Facade.JardinesFacade;
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
@Named(value = "controllerJardin")
@SessionScoped
public class ControllerJardin implements Serializable {

    @EJB
    JardinesFacade facadejardin;
    
    private Jardines jardin;
    private List<Jardines> listaJardines;
    
    /**
     * Creates a new instance of ControllerJardin
     */
    public ControllerJardin() {
    }
    @PostConstruct
    public void init(){
        jardin = new Jardines();
    }

    public Jardines getJardin() {
        return jardin;
    }

    public void setJardin(Jardines jardin) {
        this.jardin = jardin;
    }

    public List<Jardines> getListaJardines() {
        return listaJardines;
    }

    public void setListaJardines(List<Jardines> listaJardines) {
        this.listaJardines = listaJardines;
    }
    public String crearJardin(){
        facadejardin.create(jardin);
        jardin = new Jardines();
        return "listarJardines";
    }
    public List<Jardines> consultarJardines(){
        this.listaJardines = facadejardin.findAll();
        return listaJardines;
    }
    public String actualizarJardin(Jardines jardin){
        this.jardin = jardin;
        return "listarJardines";
    }
    public String actualizarJardin(){
        facadejardin.edit(jardin);
        return "listarJardines";
    }
    public void eliminarJardin(Jardines jardin){
        facadejardin.remove(jardin);
    }
}
