package sk.tuke.gamestudio.minesweeper;

import sk.tuke.gamestudio.entity.Score;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
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

        entityManager.persist(new Score("minesweeper", "Stevo", 10, new Date()));
        entityManager.persist(new Score("minesweeper", "Stevoo", 100, new Date()));

        String game = "minesweeper";

        List<Score> bestScores =
                entityManager
                 .createQuery("select sc from Score sc where sc.game = :myGame order by sc.points desc")
                        .setParameter("myGame",game)
                        .getResultList();

        System.out.println(bestScores);

        System.out.println("Closing JPA playground.");
    }

}
