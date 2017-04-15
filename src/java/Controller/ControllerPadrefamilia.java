/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entitys.Padresfamilia;
import Entitys.Persona;
import Facade.PadresfamiliaFacade;
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
@Named(value = "controllerPadrefamilia")
@SessionScoped
public class ControllerPadrefamilia implements Serializable {
    
    @EJB
    PersonaFacade facadepersona;
    @EJB
    PadresfamiliaFacade facadepadrefamilia;
    
    private Persona persona;
    private Padresfamilia padrefamilia;
    private List<Padresfamilia> listapadresfamilia;
    /**
     * Creates a new instance of ControllerPadrefamilia
     */
    public ControllerPadrefamilia() {
    }
    @PostConstruct
    public void init(){
        persona = new Persona();
        padrefamilia = new Padresfamilia();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Padresfamilia getPadrefamilia() {
        return padrefamilia;
    }

    public void setPadrefamilia(Padresfamilia padrefamilia) {
        this.padrefamilia = padrefamilia;
    }

    public List<Padresfamilia> getListapadresfamilia() {
        return listapadresfamilia;
    }

    public void setListapadresfamilia(List<Padresfamilia> listapadresfamilia) {
        this.listapadresfamilia = listapadresfamilia;
    }
    public String crearPadrefamilia(){
        padrefamilia.setUsuariosidentificacion(facadepersona.find(persona.getIdentificacion()));
        facadepadrefamilia.create(padrefamilia);
        padrefamilia = new Padresfamilia();   
        return "listarPadresfamilia";
    }
    public List<Padresfamilia> consultarPadresfamilia(){
        this.listapadresfamilia = facadepadrefamilia.findAll();
        return listapadresfamilia;
    }
    public String actualizarPadresfamilia(Padresfamilia padresfamilia){
        this.padrefamilia = padresfamilia;
        return "listarPadresfamilia";
    }
    public String actualizarPadresfamilia(){
        padrefamilia.setUsuariosidentificacion(facadepersona.find(persona.getIdentificacion()));
        facadepadrefamilia.edit(padrefamilia);
        return "listarPadresfamilia";
    }
    public void eliminarPadresfamilia(Padresfamilia padresfamilia){
        facadepadrefamilia.remove(padresfamilia);
    }    
}
