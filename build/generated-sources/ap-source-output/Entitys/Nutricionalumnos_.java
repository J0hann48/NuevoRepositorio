package Entitys;

import Entitys.Alumnos;
import Entitys.Crecimientodesarrollo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-05-17T23:59:44")
@StaticMetamodel(Nutricionalumnos.class)
public class Nutricionalumnos_ { 

    public static volatile SingularAttribute<Nutricionalumnos, Crecimientodesarrollo> idcrecimientodesarrollo;
    public static volatile SingularAttribute<Nutricionalumnos, Double> talla;
    public static volatile SingularAttribute<Nutricionalumnos, Alumnos> alumnosidentificacion;
    public static volatile SingularAttribute<Nutricionalumnos, Double> peso;
    public static volatile SingularAttribute<Nutricionalumnos, Integer> idnutricionalumno;
    public static volatile SingularAttribute<Nutricionalumnos, Double> estatura;
    public static volatile SingularAttribute<Nutricionalumnos, Date> fechaingresonutricion;

}