package sk.tuke.gamestudio.minesweeper;

import sk.tuke.gamestudio.entity.Rating;
import sk.tuke.gamestudio.entity.Score;
import sk.tuke.gamestudio.entity.Student;
import sk.tuke.gamestudio.entity.StudyGroup;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
public class PlaygroundJPA {

    @PersistenceContext
    private EntityManager entityManager;

    public void play(){
        System.out.println("Opening JPA playground.");

//        entityManager.persist(new StudyGroup("zakladna"));
//        entityManager.persist(new StudyGroup("mierne pokrocila"));
//        entityManager.persist(new StudyGroup("pokrocila"));

        String firstName = "Raweel";
        String lastName = "Powick";
        int group = 1;

        List<StudyGroup> studyGroups= entityManager.createQuery("select g from StudyGroup g")
                .getResultList();

        int noOfGroups = studyGroups.size();

        for(int i=0;i<noOfGroups;i++){
            System.out.println(i+" "+studyGroups.get(i));
        }

        entityManager.persist(new Student(firstName,lastName,studyGroups.get(group)));

        List<Student> students= entityManager.createQuery("select s from Student s")
                .getResultList();

        System.out.println(students);







        /*
        String game = "minesweeper";
        String user = "JAjo";
        int ratingValue = 5;

        //entityManager.persist(new Rating(game,user,ratingValue,new Date()));

        Rating rating2Write = null;

        try{
            rating2Write = (Rating) entityManager.createQuery("select r from Rating r where r.username=:user and r.game = :game")
                    .setParameter("user",user)
                    .setParameter("game",game)
                    .getSingleResult();
            rating2Write.setRating(ratingValue);
            rating2Write.setRatedOn(new Date());
        }catch(NoResultException e){
            rating2Write = new Rating(game,user,ratingValue,new Date());
            entityManager.persist(rating2Write);
            rating2Write.setRating(1);

        }


        System.out.println(rating2Write);

         */


        /*
        entityManager.persist(new Score("minesweeper", "Stevo", 10, new Date()));
        entityManager.persist(new Score("minesweeper", "Stevoo", 100, new Date()));

        String game = "minesweeper";

        List<Score> bestScores =
                entityManager
                 .createQuery("select sc from Score sc where sc.game = :myGame order by sc.points desc")
                        .setParameter("myGame",game)
                        .getResultList();

        System.out.println(bestScores);
        */


        System.out.println("Closing JPA playground.");
    }

}
