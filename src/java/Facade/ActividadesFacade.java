/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entitys.Actividades;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Johann48
 */
@Stateless
public class ActividadesFacade extends AbstractFacade<Actividades> {

    @PersistenceContext(unitName = "ProyectoJardinWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadesFacade() {
        super(Actividades.class);
    }
    public String correoActividades(){
        String correos = "";
        try{
            Query consultacorreos = em.createQuery("SELECT u.mail FROM Usuarios u INNER JOIN FETCH U.rolList p where p.nombre = 'Padre de familia'");
            List<String> listaCorreos = consultacorreos.getResultList();
            if (!listaCorreos.isEmpty()) {
                for (int i = 0; i < listaCorreos.size(); i++) {
                    correos+= listaCorreos.get(i) + ";";
                }
            }else{
                System.out.println("La lista esta vacia");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return correos;
    }
}
