/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entitys.Usuarios;
import java.util.List;
import java.util.Random;
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

    public Usuarios validarUsuario(Usuarios user) {        
        Query queryUser = em.createQuery("SELECT u FROM Usuarios u where u.mail = :mail");
        queryUser.setParameter("mail", user.getMail());        
        List<Usuarios> listaUser = queryUser.getResultList();
        if (!listaUser.isEmpty()) {
            user = listaUser.get(0);
            user.setContrasena(ramdom());            
        } else{
            System.out.println("El usuario no existe");
        }
        return user;
    }

    private String ramdom() {
        String cadenaRam = "";
        int[] numRamdon = new int[10];
        for (int i = 0; i < numRamdon.length; i++) {
            numRamdon[i] = (int) (Math.random() * 10 + 1);
            cadenaRam+= String.valueOf(numRamdon[i]);
        }
        return cadenaRam;
    }
}
