package Entitys;

import Entitys.Alumnos;
import Entitys.Jardines;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-05-08T23:24:22")
@StaticMetamodel(Matricula.class)
public class Matricula_ { 

    public static volatile SingularAttribute<Matricula, Integer> totalMatricula;
    public static volatile SingularAttribute<Matricula, Alumnos> alumnosidentificacion;
    public static volatile SingularAttribute<Matricula, Integer> descuento;
    public static volatile SingularAttribute<Matricula, Integer> idmatricula;
    public static volatile SingularAttribute<Matricula, Date> fechamatricula;
    public static volatile SingularAttribute<Matricula, Jardines> jardinidjardin;
    public static volatile SingularAttribute<Matricula, Integer> valormatricula;
    public static volatile SingularAttribute<Matricula, Date> fechafinmatricula;

}