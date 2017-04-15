/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entitys.Asignaturas;
import Entitys.Nota;
import Facade.AsignaturasFacade;
import Facade.NotaFacade;
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
@Named(value = "controllerNota")
@SessionScoped
public class ControllerNota implements Serializable {

    @EJB
    NotaFacade facadenota;
    @EJB
    AsignaturasFacade facadeasignatura;
    
    private Nota nota;
    private Asignaturas asignatura;
    private List<Nota> listanotas;
    
    /**
     * Creates a new instance of ControllerNota
     */
    public ControllerNota() {
    }
    @PostConstruct
    public void init(){
        nota = new Nota();
        asignatura = new Asignaturas();
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Asignaturas getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignaturas asignatura) {
        this.asignatura = asignatura;
    }

    public List<Nota> getListanotas() {
        return listanotas;
    }

    public void setListanotas(List<Nota> listanotas) {
        this.listanotas = listanotas;
    }
    public String crearNotas(){
        nota.setAsignaturasidasignatura(facadeasignatura.find(asignatura.getIdasignatura()));
        facadenota.create(nota);
        nota = new Nota();  
        return "listarNotas";
    }
    public List<Nota> consultarNotas(){
        this.listanotas = facadenota.findAll();
        return listanotas;
    }
    public String actualizarNotas(Nota nota){
        this.nota = nota;
        return "listarNotas";
    }
    public String actualizarNotas(){
        nota.setAsignaturasidasignatura(facadeasignatura.find(asignatura.getIdasignatura()));
        facadenota.edit(nota);
        nota = new Nota();
        return "listarNotas";
    }
    public void eliminarNotas(Nota nota){
        facadenota.remove(nota);
    }
}
