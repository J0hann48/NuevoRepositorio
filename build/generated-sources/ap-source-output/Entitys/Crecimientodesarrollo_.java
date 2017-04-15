package Entitys;

import Entitys.Nutricionalumnos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2017-04-03T00:27:20")
@StaticMetamodel(Crecimientodesarrollo.class)
public class Crecimientodesarrollo_ { 

    public static volatile SingularAttribute<Crecimientodesarrollo, Double> talla;
    public static volatile SingularAttribute<Crecimientodesarrollo, Integer> idCrecimientoDesarrollo;
    public static volatile SingularAttribute<Crecimientodesarrollo, Double> pesoEstatura;
    public static volatile ListAttribute<Crecimientodesarrollo, Nutricionalumnos> nutricionalumnosList;
    public static volatile SingularAttribute<Crecimientodesarrollo, Double> pesoMedio;
    public static volatile SingularAttribute<Crecimientodesarrollo, Integer> edad;

}