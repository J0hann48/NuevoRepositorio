package Entitys;

import Entitys.Alumnos;
import Entitys.Padresfamilia;
import Entitys.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-04-03T00:27:20")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile ListAttribute<Persona, Usuarios> usuariosList;
    public static volatile SingularAttribute<Persona, String> apellido2;
    public static volatile ListAttribute<Persona, Padresfamilia> padresfamiliaList;
    public static volatile SingularAttribute<Persona, String> apellido1;
    public static volatile ListAttribute<Persona, Alumnos> alumnosList;
    public static volatile SingularAttribute<Persona, Integer> identificacion;
    public static volatile SingularAttribute<Persona, String> nombre2;
    public static volatile SingularAttribute<Persona, String> sexo;
    public static volatile SingularAttribute<Persona, String> nombre1;
    public static volatile SingularAttribute<Persona, String> tipodocumento;

}