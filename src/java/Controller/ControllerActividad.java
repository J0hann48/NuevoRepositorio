/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entitys.Actividades;
import Entitys.Jardines;
import Facade.ActividadesFacade;
import Facade.JardinesFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Johann48
 */
@Named(value = "controllerActividad")
@SessionScoped
public class ControllerActividad implements Serializable {

    @EJB
    ActividadesFacade facadeActividad;
    @EJB
    JardinesFacade facadejardin;

    private Actividades actividad;
    private Jardines jardines;
    private List<Actividades> listaActividades;

    /**
     * Creates a new instance of ControllerActividad
     */
    public ControllerActividad() {
    }

    @PostConstruct
    public void init() {
        actividad = new Actividades();
        jardines = new Jardines();
    }

    public Actividades getActividad() {
        return actividad;
    }

    public void setActividad(Actividades actividad) {
        this.actividad = actividad;
    }

    public Jardines getJardines() {
        return jardines;
    }

    public void setJardines(Jardines jardines) {
        this.jardines = jardines;
    }

    public List<Actividades> getListaActividades() {
        return listaActividades;
    }

    public void setListaActividades(List<Actividades> listaActividades) {
        this.listaActividades = listaActividades;
    }

    public String crearActividad() throws UnsupportedEncodingException {
        actividad.setJardinidjardin(facadejardin.find(jardines.getIdjardin()));
        facadeActividad.create(actividad);
        String correoAct = facadeActividad.correoActividades();
        String mensaje = "Papitos el jardin " + actividad.getJardinidjardin().getNombre() +" les informa que se realizará una actividad pedagogica y para nosotros  es importante contar con ustedes,"
                + " la salida será la fecha " + actividad.getFechaact() + " a " + actividad.getLugaract() + " y tiene un costo de " + actividad.getCostoact()
                + " contamos con la asitencia de su hijo, Gracias por su atención";
        Mailer.send(correoAct, "Actividad jardin", mensaje);
        actividad = new Actividades();        
        return "listarActividades";
    }

    public List<Actividades> consultarActividades() {
        this.listaActividades = facadeActividad.findAll();
        return listaActividades;
    }

    public String actualizarActividad(Actividades actividad) {
        this.actividad = actividad;
        return "listarActividades";
    }

    public String actualizarActividad() {
        actividad.setJardinidjardin(facadejardin.find(jardines.getIdjardin()));
        facadeActividad.edit(actividad);
        actividad = new Actividades();
        return "listarActividades";
    }

    public void eliminarActividad(Actividades actividad) {
        facadeActividad.remove(actividad);
    }
}
