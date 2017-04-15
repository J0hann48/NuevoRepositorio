/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entitys.Alumnos;
import Entitys.Crecimientodesarrollo;
import Entitys.Nutricionalumnos;
import Facade.AlumnosFacade;
import Facade.CrecimientodesarrolloFacade;
import Facade.NutricionalumnosFacade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Johann48
 */
@Named(value = "controllerNutricion")
@SessionScoped
public class ControllerNutricion implements Serializable {

    @EJB
    NutricionalumnosFacade facadenutricion;
    @EJB
    AlumnosFacade facadealumnos;
    @EJB
    CrecimientodesarrolloFacade facadecrecimiento;

    private Nutricionalumnos nutricion;
    private Alumnos alumno;
    private Crecimientodesarrollo crecimiento;
    private List<Nutricionalumnos> listaNutricion;
    private String htmlBuffer;

    /**
     * Creates a new instance of ControllerNutricion
     */
    public ControllerNutricion() {
    }

    @PostConstruct
    public void init() {
        nutricion = new Nutricionalumnos();
        alumno = new Alumnos();
        crecimiento = new Crecimientodesarrollo();
    }

    public Nutricionalumnos getNutricion() {
        return nutricion;
    }

    public void setNutricion(Nutricionalumnos nutricion) {
        this.nutricion = nutricion;
    }

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public Crecimientodesarrollo getCrecimiento() {
        return crecimiento;
    }

    public void setCrecimiento(Crecimientodesarrollo crecimiento) {
        this.crecimiento = crecimiento;
    }

    public List<Nutricionalumnos> getListaNutricion() {
        return listaNutricion;
    }

    public void setListaNutricion(List<Nutricionalumnos> listaNutricion) {
        this.listaNutricion = listaNutricion;
    }

    public String ingresarNutricionalumno() {
        nutricion.setAlumnosidentificacion(facadealumnos.find(alumno.getIdalumno()));
        nutricion.setIdcrecimientodesarrollo(facadecrecimiento.find(crecimiento.getIdCrecimientoDesarrollo()));
        facadenutricion.create(nutricion);
        nutricion = new Nutricionalumnos();
        return "listarNutricionalumnos";
    }

    public List<Nutricionalumnos> consultarNutricionalumnos() {
        this.listaNutricion = facadenutricion.findAll();
        return listaNutricion;
    }

    public String actualizarNutricionalumno(Nutricionalumnos nutricion) {
        this.nutricion = nutricion;
        return "listarNutricionalumnos";
    }

    public String actualizarNutricionalumno() {
        nutricion.setAlumnosidentificacion(facadealumnos.find(alumno.getIdalumno()));
        nutricion.setIdcrecimientodesarrollo(facadecrecimiento.find(crecimiento.getIdCrecimientoDesarrollo()));
        facadenutricion.edit(nutricion);
        nutricion = new Nutricionalumnos();
        return "listarNutricionalumnos";
    }

    public void eliminarNutricionalumno(Nutricionalumnos nutricion) {
        facadenutricion.remove(nutricion);
    }

    public void exportExcel() throws IOException {

//        //Set the filename
//        DateTime dt = new DateTime();
//        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = "" + System.currentTimeMillis() + ".xls";

        //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();

        HttpServletResponse response = (HttpServletResponse) fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);

        //Write the table back out
        PrintWriter out = response.getWriter();
        out.print(htmlBuffer);
        out.close();
        fc.responseComplete();
    }

    public String getHtmlBuffer() {
        return htmlBuffer;
    }

    public void setHtmlBuffer(String htmlBuffer) {
        this.htmlBuffer = htmlBuffer;
    }
}
