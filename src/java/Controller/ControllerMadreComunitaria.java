/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entitys.Jardines;
import Entitys.Madrecomunitaria;
import Entitys.Persona;
import Facade.JardinesFacade;
import Facade.MadrecomunitariaFacade;
import Facade.PersonaFacade;
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
@Named(value = "controllerMadreComunitaria")
@SessionScoped
public class ControllerMadreComunitaria implements Serializable {

    @EJB
    MadrecomunitariaFacade facademadre;
    @EJB
    JardinesFacade facadejardin;
    @EJB
    PersonaFacade facadepersona;
    
    private Madrecomunitaria madrecomunitaria;
    private Jardines jardin;
    private Persona persona;
    
    private List<Madrecomunitaria> listamadrecomunitaria;
    /**
     * Creates a new instance of ControllerMadreComunitaria
     */
    public ControllerMadreComunitaria() {
    }
    @PostConstruct
    public void init(){
        persona = new Persona();
        jardin = new Jardines();
        madrecomunitaria = new Madrecomunitaria();
    }

    public Madrecomunitaria getMadrecomunitaria() {
        return madrecomunitaria;
    }

    public void setMadrecomunitaria(Madrecomunitaria madrecomunitaria) {
        this.madrecomunitaria = madrecomunitaria;
    }

    public Jardines getJardin() {
        return jardin;
    }

    public void setJardin(Jardines jardin) {
        this.jardin = jardin;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Madrecomunitaria> getListamadrecomunitaria() {
        return listamadrecomunitaria;
    }

    public void setListamadrecomunitaria(List<Madrecomunitaria> listamadrecomunitaria) {
        this.listamadrecomunitaria = listamadrecomunitaria;
    }
    public String crearMadrecomunitaria(){
        madrecomunitaria.setUsuariosidentificacion(facadepersona.find(persona.getIdentificacion()));
        madrecomunitaria.setJardinidjardin(facadejardin.find(jardin.getIdjardin()));
        facademadre.create(madrecomunitaria);
        madrecomunitaria = new Madrecomunitaria();
        return "listarMadrescomunitarias";
    }
    public List<Madrecomunitaria> consultaMadrecomunitaria(){
        this.listamadrecomunitaria = facademadre.findAll();
        return listamadrecomunitaria;
    }
    public String actualizarMadrecomunitaria(Madrecomunitaria madre){
        this.madrecomunitaria = madre;
        return "listarMadrescomunitarias";
    }
    public String actualizarMadrecomunitaria(){
        madrecomunitaria.setUsuariosidentificacion(facadepersona.find(persona.getIdentificacion()));
        madrecomunitaria.setJardinidjardin(facadejardin.find(jardin.getIdjardin()));
        facademadre.edit(madrecomunitaria);
        return "listarMadrescomunitarias";
    }
    public void eliminarMadrescomunitarias(Madrecomunitaria madre){
        facademadre.remove(madre);
    }
}
