package entities;

import entities.Quiz;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-05T10:08:29")
@StaticMetamodel(Theme.class)
public class Theme_ { 

    public static volatile SingularAttribute<Theme, String> image;
    public static volatile ListAttribute<Theme, Quiz> quizList;
    public static volatile SingularAttribute<Theme, String> libelle;
    public static volatile SingularAttribute<Theme, Integer> id;

}