/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entitys.Persona;
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
@Named(value = "controllerPersona")
@SessionScoped
public class ControllerPersona implements Serializable {

    @EJB
    PersonaFacade facadepersona;
    
    private Persona persona;
    private List<Persona> listapersonas;
    
    
    /**
     * Creates a new instance of ControllerPersona
     */
    public ControllerPersona() {
    }
    @PostConstruct
    public void init(){
        persona = new Persona();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getListapersonas() {
        return listapersonas;
    }

    public void setListapersonas(List<Persona> listapersonas) {
        this.listapersonas = listapersonas;
    }
    public String crearPersona(){
        facadepersona.create(persona);
        persona = new Persona();
        return "listarPersonas";
    }
    public List<Persona> consultarPersona(){
        this.listapersonas = facadepersona.findAll();
        return listapersonas;
    }
    public String actualizarPersona(){
        facadepersona.edit(persona);
        persona = new Persona();
        return "listarPersonas";
    }
    public String actualizarPersona(Persona persona){
        this.persona = persona;
        return "listarPersonas";
    }
    public void eliminarPersona(Persona persona){
        facadepersona.remove(persona);
    }
}
