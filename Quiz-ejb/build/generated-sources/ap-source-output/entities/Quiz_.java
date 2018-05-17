package entities;

import entities.Question;
import entities.Theme;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-05T10:08:29")
@StaticMetamodel(Quiz.class)
public class Quiz_ { 

    public static volatile SingularAttribute<Quiz, Date> date;
    public static volatile SingularAttribute<Quiz, Float> meilleurScore;
    public static volatile SingularAttribute<Quiz, String> durée;
    public static volatile SingularAttribute<Quiz, Integer> active;
    public static volatile SingularAttribute<Quiz, Integer> id;
    public static volatile SingularAttribute<Quiz, String> enseignant;
    public static volatile SingularAttribute<Quiz, String> sujet;
    public static volatile SingularAttribute<Quiz, Theme> idTheme;
    public static volatile ListAttribute<Quiz, Question> questionList;

}