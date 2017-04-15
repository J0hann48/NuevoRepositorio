/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entitys.Asignaturas;
import Facade.AsignaturasFacade;
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
@Named(value = "controllerAsignatura")
@SessionScoped
public class ControllerAsignatura implements Serializable {

    @EJB
    AsignaturasFacade facadeasignatura;
    
    private Asignaturas asignatura;   
    private List<Asignaturas> listaasignatura;
    /**
     * Creates a new instance of ControllerAsignatura
     */
    public ControllerAsignatura() {
    }
    @PostConstruct
    public void init(){
        asignatura = new Asignaturas();
    }

    public Asignaturas getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignaturas asignatura) {
        this.asignatura = asignatura;
    }

    public List<Asignaturas> getListaasignatura() {
        return listaasignatura;
    }

    public void setListaasignatura(List<Asignaturas> listaasignatura) {
        this.listaasignatura = listaasignatura;
    }
    public String crearAsignatura(){
        facadeasignatura.create(asignatura);
        asignatura = new Asignaturas();
        return "listarAsignaturas";
    }
    public List<Asignaturas> consultarAsignatura(){
        this.listaasignatura = facadeasignatura.findAll();
        return listaasignatura;
    }
    public String actualizarAsignatura(Asignaturas asignatura){
        this.asignatura = asignatura;
        return "listarAsignaturas";
    }
    public String actualizarAsignatura(){
        facadeasignatura.edit(asignatura);    
        return "listarAsignaturas";
    }
    public void eliminarAsignatura(Asignaturas asignatura){
        facadeasignatura.remove(asignatura);
    }
}
