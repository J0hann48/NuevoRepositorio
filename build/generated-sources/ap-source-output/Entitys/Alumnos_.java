package Entitys;

import Entitys.Matricula;
import Entitys.Nutricionalumnos;
import Entitys.Padresfamilia;
import Entitys.Persona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-05-04T00:20:31")
@StaticMetamodel(Alumnos.class)
public class Alumnos_ { 

    public static volatile SingularAttribute<Alumnos, Persona> personaidentificacion;
    public static volatile SingularAttribute<Alumnos, Padresfamilia> padrefamiliaidentificacion;
    public static volatile SingularAttribute<Alumnos, Date> fechaNacimiento;
    public static volatile SingularAttribute<Alumnos, Integer> idalumno;
    public static volatile ListAttribute<Alumnos, Matricula> matriculaList;
    public static volatile SingularAttribute<Alumnos, Date> fechaingreso;
    public static volatile SingularAttribute<Alumnos, Date> fechasalida;
    public static volatile SingularAttribute<Alumnos, String> observaciones;
    public static volatile ListAttribute<Alumnos, Nutricionalumnos> nutricionalumnosList;

}