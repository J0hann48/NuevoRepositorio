package Entitys;

import Entitys.Persona;
import Entitys.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-05-04T00:20:31")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, Persona> personaidentificacion;
    public static volatile SingularAttribute<Usuarios, String> estado;
    public static volatile SingularAttribute<Usuarios, String> mail;
    public static volatile SingularAttribute<Usuarios, String> contrasena;
    public static volatile ListAttribute<Usuarios, Rol> rolList;
    public static volatile SingularAttribute<Usuarios, String> telefono;
    public static volatile SingularAttribute<Usuarios, Integer> idusuario;

}