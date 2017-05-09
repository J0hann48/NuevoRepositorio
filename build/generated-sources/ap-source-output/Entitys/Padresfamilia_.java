package Entitys;

import Entitys.Alumnos;
import Entitys.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-05-08T23:24:22")
@StaticMetamodel(Padresfamilia.class)
public class Padresfamilia_ { 

    public static volatile SingularAttribute<Padresfamilia, Persona> usuariosidentificacion;
    public static volatile ListAttribute<Padresfamilia, Alumnos> alumnosList;
    public static volatile SingularAttribute<Padresfamilia, String> direccion;
    public static volatile SingularAttribute<Padresfamilia, Integer> estrato;
    public static volatile SingularAttribute<Padresfamilia, Integer> idpadrefamilia;

}