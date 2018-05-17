package entities;

import entities.Question;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-05T10:08:29")
@StaticMetamodel(Choix.class)
public class Choix_ { 

    public static volatile SingularAttribute<Choix, String> reponse;
    public static volatile SingularAttribute<Choix, Question> idQuestion;
    public static volatile SingularAttribute<Choix, Integer> id;
    public static volatile SingularAttribute<Choix, String> type;

}