/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entitys.Jardines;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Johann48
 */
@Stateless
public class JardinesFacade extends AbstractFacade<Jardines> {

    @PersistenceContext(unitName = "ProyectoJardinWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JardinesFacade() {
        super(Jardines.class);
    }
    
}
