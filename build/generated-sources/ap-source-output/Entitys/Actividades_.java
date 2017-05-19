package Entitys;

import Entitys.Jardines;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-05-17T23:59:44")
@StaticMetamodel(Actividades.class)
public class Actividades_ { 

    public static volatile SingularAttribute<Actividades, Date> fechaact;
    public static volatile SingularAttribute<Actividades, String> lugaract;
    public static volatile SingularAttribute<Actividades, Integer> costoact;
    public static volatile SingularAttribute<Actividades, Jardines> jardinidjardin;
    public static volatile SingularAttribute<Actividades, Integer> idactividad;
    public static volatile SingularAttribute<Actividades, String> nombre;

}