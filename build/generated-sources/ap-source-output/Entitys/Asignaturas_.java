package Entitys;

import Entitys.Nota;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-05-02T23:45:28")
@StaticMetamodel(Asignaturas.class)
public class Asignaturas_ { 

    public static volatile SingularAttribute<Asignaturas, Integer> idasignatura;
    public static volatile SingularAttribute<Asignaturas, String> nombre;
    public static volatile ListAttribute<Asignaturas, Nota> notaList;

}