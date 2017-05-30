/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entitys.Persona;
import Entitys.Usuarios;
import Facade.PersonaFacade;
import Facade.UsuariosFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author Johann48
 */
@Named(value = "controllerUsuario")
@SessionScoped
public class ControllerUsuario implements Serializable {

    @EJB
    UsuariosFacade facadeusuario;
    @EJB
    PersonaFacade facadepersona;

    private Persona persona;
    private Usuarios usuario;
    private Usuarios usersesion;
    private List<Usuarios> listausuarios;

    /**
     * Creates a new instance of ControllerUsuario
     */
    public ControllerUsuario() {
    }

    @PostConstruct
    public void init() {
        usuario = new Usuarios();
        persona = new Persona();
        usersesion = new Usuarios();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public List<Usuarios> getListausuarios() {
        return listausuarios;
    }

    public void setListausuarios(List<Usuarios> listausuarios) {
        this.listausuarios = listausuarios;
    }

    public Usuarios getUsersesion() {
        return usersesion;
    }

    public void setUsersesion(Usuarios usersesion) {
        this.usersesion = usersesion;
    }

    public String crearUsuarios() throws UnsupportedEncodingException {
        usuario.setPersonaidentificacion(facadepersona.find(persona.getIdentificacion()));
        facadeusuario.create(usuario);
        String mensaje = "Su correo es: " + usuario.getMail() + "<br/>" + "Su contraseña es: " + usuario.getContrasena()
                + "<br/>" + "Bienvenido";
        Mailer.send(usuario.getMail(), "Usuario jardin", mensaje);
        usuario = new Usuarios();
        return "listarUsuarios";
    }

    public List<Usuarios> consultarUsuarios() {
        this.listausuarios = facadeusuario.findAll();
        return listausuarios;
    }

    public String actualizarUsuarios() {
        usuario.setPersonaidentificacion(facadepersona.find(persona.getIdentificacion()));
        facadeusuario.edit(usuario);
        usuario = new Usuarios();
        return "listarUsuarios";
    }

    public String actualizarUsuarios(Usuarios usuario) {
        this.usuario = usuario;
        usuario = new Usuarios();
        return "listarUsuarios";
    }

    public void eliminarUsuario(Usuarios usuario) {
        facadeusuario.remove(usuario);
    }

    public void login() throws IOException {
        Usuarios user = new Usuarios();
        usuario.setPersonaidentificacion(persona);
        user = facadeusuario.loginUsuario(usuario);
        String redireccion;
        if (user != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("autorizacion", user);
            usersesion = (Usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("autorizacion");
            if (usuario.getContrasena().equalsIgnoreCase("123456")) {
                redireccion = "Paginas/inicio.xhtml";
                FacesContext.getCurrentInstance().getExternalContext().redirect(redireccion);
            }
            if (usuario.getContrasena().equalsIgnoreCase("123456")) {
                redireccion = "Paginas/inicioMadrecomunitaria.xhtml";
                FacesContext.getCurrentInstance().getExternalContext().redirect(redireccion);
            }
            if (usuario.getContrasena().equalsIgnoreCase("1234567")) {
                redireccion = "Paginas/inicioPadrefamilia.xhtml";
                FacesContext.getCurrentInstance().getExternalContext().redirect(redireccion);
            }
        } else {
            redireccion = "index.xhtml";
            FacesContext.getCurrentInstance().getExternalContext().redirect(redireccion);
        }
//        return redireccion;
    }

    public void olvidoClave() throws UnsupportedEncodingException {
        Usuarios user = new Usuarios();
        user = facadeusuario.validarUsuario(this.usuario);
        String mensaje = "Su contraseña ha sido modificada con exito, su nueva contraseña  es: " + user.getContrasena();
        Mailer.send(usuario.getMail(), "Cambio de contraseña", mensaje);
        System.out.println("El usuario no existe o su contraseña no fue modificada");
    }

    public void logOut() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/ProyectoJardinWeb/faces/index.xhtml?faces-redirect=true");
    }
}
