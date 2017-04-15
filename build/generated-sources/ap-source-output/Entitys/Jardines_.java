package Entitys;

import Entitys.Actividades;
import Entitys.Madrecomunitaria;
import Entitys.Matricula;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-04-03T00:27:20")
@StaticMetamodel(Jardines.class)
public class Jardines_ { 

    public static volatile SingularAttribute<Jardines, Integer> idjardin;
    public static volatile SingularAttribute<Jardines, Integer> presupuesto;
    public static volatile ListAttribute<Jardines, Madrecomunitaria> madrecomunitariaList;
    public static volatile ListAttribute<Jardines, Actividades> actividadesList;
    public static volatile ListAttribute<Jardines, Matricula> matriculaList;
    public static volatile SingularAttribute<Jardines, String> direccion;
    public static volatile SingularAttribute<Jardines, String> nombre;
    public static volatile SingularAttribute<Jardines, Integer> telefonofijo;

}