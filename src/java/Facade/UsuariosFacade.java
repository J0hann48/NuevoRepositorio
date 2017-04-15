/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entitys.Usuarios;
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
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "ProyectoJardinWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    public Usuarios loginUsuario(Usuarios usuario) {
        Usuarios user = null;
        try {
//            String sqlString = "SELECT u FROM usuarios u where u.personaidentificacion = :identificacion AND u.contrasena = :contrasena";
            Query query = em.createQuery("SELECT u FROM Usuarios u where u.personaidentificacion = :identificacion AND u.contrasena = :contrasena");
            query.setParameter("identificacion", usuario.getPersonaidentificacion());
            query.setParameter("contrasena", usuario.getContrasena());
            List<Usuarios> listausuarios = query.getResultList();
            if (!listausuarios.isEmpty()) { 
                user = listausuarios.get(0);
            }
        } catch (Exception e) {
            System.out.println("El registro no existe en la lista" + e.getMessage());
        }
        return user;
    }
}
