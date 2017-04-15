/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entitys.Alumnos;
import Entitys.Padresfamilia;
import Entitys.Persona;
import Facade.AlumnosFacade;
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
@Named(value = "controllerAlumno")
@SessionScoped
public class ControllerAlumno implements Serializable {

    @EJB
    AlumnosFacade facadealumno;
    @EJB
    PadresfamiliaFacade facadepadrefamilia;
    @EJB
    PersonaFacade facadepersona;
    
    private Alumnos alumno;
    private Padresfamilia padrefamilia;
    private Persona persona;
    private List<Alumnos> listaalumnos;
    /**
     * Creates a new instance of ControllerAlumno
     */
    public ControllerAlumno() {
    }
    @PostConstruct
    public void init(){
        alumno = new Alumnos();
        padrefamilia = new Padresfamilia();
        persona = new Persona();
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public Padresfamilia getPadrefamilia() {
        return padrefamilia;
    }

    public void setPadrefamilia(Padresfamilia padrefamilia) {
        this.padrefamilia = padrefamilia;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Alumnos> getListaalumnos() {
        return listaalumnos;
    }

    public void setListaalumnos(List<Alumnos> listaalumnos) {
        this.listaalumnos = listaalumnos;
    }
    public String crearAlumnos(){
        alumno.setPersonaidentificacion(facadepersona.find(persona.getIdentificacion()));
        alumno.setPadrefamiliaidentificacion(facadepadrefamilia.find(padrefamilia.getIdpadrefamilia()));
        facadealumno.create(alumno);
        alumno = new Alumnos();       
        return "listarAlumnos";
    }
    public List<Alumnos> consultarAlumnos(){
        this.listaalumnos = facadealumno.findAll();
        return listaalumnos;
    }
    public String actualizarAlumnos(Alumnos alumno){
        this.alumno = alumno;
        return "listarAlumnos";
    }
    public String actualizarAlumnos(){
        alumno.setPersonaidentificacion(facadepersona.find(persona.getIdentificacion()));
        alumno.setPadrefamiliaidentificacion(facadepadrefamilia.find(padrefamilia.getIdpadrefamilia()));
        facadealumno.edit(alumno);
        return "listarAlumnos";
    }
    public void eliminarAlumnos(Alumnos alumno){
        facadealumno.remove(alumno);
    }
}
