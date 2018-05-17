package entities;

import entities.Choix;
import entities.Quiz;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-05T10:08:29")
@StaticMetamodel(Question.class)
public class Question_ { 

    public static volatile SingularAttribute<Question, String> enonce;
    public static volatile SingularAttribute<Question, Quiz> idQuiz;
    public static volatile ListAttribute<Question, Choix> choixList;
    public static volatile SingularAttribute<Question, Integer> id;

}