/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entitys.Crecimientodesarrollo;
import Facade.CrecimientodesarrolloFacade;
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
@Named(value = "controllerCrecimiento")
@SessionScoped
public class ControllerCrecimiento implements Serializable {

    @EJB
    CrecimientodesarrolloFacade facadecrecimiento;
    
    private Crecimientodesarrollo crecimiento;
    private List<Crecimientodesarrollo> listacrecimiento;
    
    /**
     * Creates a new instance of ControllerCrecimiento
     */
    public ControllerCrecimiento() {
    }
    @PostConstruct
    public void init(){
        crecimiento = new Crecimientodesarrollo();
    }

    public Crecimientodesarrollo getCrecimiento() {
        return crecimiento;
    }

    public void setCrecimiento(Crecimientodesarrollo crecimiento) {
        this.crecimiento = crecimiento;
    }

    public List<Crecimientodesarrollo> getListacrecimiento() {
        return listacrecimiento;
    }

    public void setListacrecimiento(List<Crecimientodesarrollo> listacrecimiento) {
        this.listacrecimiento = listacrecimiento;
    }
    public String crearCrecimiento(){
        facadecrecimiento.create(crecimiento);
        crecimiento = new Crecimientodesarrollo();
        return "listarCrecimiento";
    }
    public List<Crecimientodesarrollo> consultarCrecimiento(){
        this.listacrecimiento = facadecrecimiento.findAll();
        return listacrecimiento;
    }
    public String actualizarCrecimiento(){
        facadecrecimiento.edit(crecimiento);        
        return "listarCrecimiento";
    }
    public String actualizarCrecimiento(Crecimientodesarrollo crecimiento){
        this.crecimiento = crecimiento;
        return "editarCrecimiento";
    }
    public void eliminarCrecimiento(Crecimientodesarrollo crecimiento){
        facadecrecimiento.remove(crecimiento);
    }
}
