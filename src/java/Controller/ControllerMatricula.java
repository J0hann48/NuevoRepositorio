/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entitys.Alumnos;
import Entitys.Jardines;
import Entitys.Matricula;
import Facade.AlumnosFacade;
import Facade.JardinesFacade;
import Facade.MatriculaFacade;
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
@Named(value = "controllerMatricula")
@SessionScoped
public class ControllerMatricula implements Serializable {

    @EJB
    MatriculaFacade facadematricula;
    @EJB
    AlumnosFacade facadealumno;
    @EJB
    JardinesFacade facadejardin;
    
    private Matricula matricula;
    private Alumnos alumno;
    private Jardines jardin;
    private List<Matricula> listamatricula;    
    /**
     * Creates a new instance of ControllerMatricula
     */
    public ControllerMatricula() {
    }
    @PostConstruct
    public void init(){
        matricula = new Matricula();
        alumno = new Alumnos();
        jardin = new Jardines();
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public Jardines getJardin() {
        return jardin;
    }

    public void setJardin(Jardines jardin) {
        this.jardin = jardin;
    }

    public List<Matricula> getListamatricula() {
        return listamatricula;
    }

    public void setListamatricula(List<Matricula> listamatricula) {
        this.listamatricula = listamatricula;
    }
    public String crearMatricula(){
        matricula.setAlumnosidentificacion(facadealumno.find(alumno.getIdalumno()));
        matricula.setJardinidjardin(facadejardin.find(jardin.getIdjardin()));
        facadematricula.create(matricula);
        matricula = new Matricula();
        return "listarMatriculas";
    }
    public List<Matricula> consultarMatriculas(){
        this.listamatricula = facadematricula.findAll();
        return listamatricula;
    }
    public String actualizarMatricula(Matricula matricula){
        this.matricula = matricula;
        return "listarMatriculas";
    }
    public String actualizarMatricula(){
        matricula.setAlumnosidentificacion(facadealumno.find(alumno.getIdalumno()));
        matricula.setJardinidjardin(facadejardin.find(jardin.getIdjardin()));
        facadematricula.edit(matricula);
        matricula = new Matricula();
        return "listarMatriculas";
    }
    public void eliminarMatricula(Matricula matricula){
        facadematricula.remove(matricula);
    }
}
