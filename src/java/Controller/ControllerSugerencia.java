/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entitys.Sugerencias;
import Facade.SugerenciasFacade;
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
@Named(value = "controllerSugerencia")
@SessionScoped
public class ControllerSugerencia implements Serializable {

    @EJB
    SugerenciasFacade facadesugerencia;
    
    private Sugerencias sugerencia;
    private List<Sugerencias> listasugerencias;
    /**
     * Creates a new instance of ControllerSugerencia
     */
    public ControllerSugerencia() {
    }
    @PostConstruct
    public void init(){
        sugerencia = new Sugerencias();
    }

    public Sugerencias getSugerencia() {
        return sugerencia;
    }

    public void setSugerencia(Sugerencias sugerencia) {
        this.sugerencia = sugerencia;
    }

    public List<Sugerencias> getListasugerencias() {
        return listasugerencias;
    }

    public void setListasugerencias(List<Sugerencias> listasugerencias) {
        this.listasugerencias = listasugerencias;
    }
    public String crearSugerencia(){
        facadesugerencia.create(sugerencia);
        sugerencia = new Sugerencias();
        return "listarSugerencias";
    }
    public List<Sugerencias> consultarSugerencias(){
        this.listasugerencias = facadesugerencia.findAll();
        return listasugerencias;
    }
    public String actualizarSugerencia(Sugerencias sugerencia){
        this.sugerencia = sugerencia;
        return "listarSugerencias";
    }
    public String actualizarSugerencia(){
        facadesugerencia.edit(sugerencia);
        return "listarSugerencias";
    }
    public void eliminarSugerencia(Sugerencias sugerencia){
        facadesugerencia.remove(sugerencia);
    }
}
