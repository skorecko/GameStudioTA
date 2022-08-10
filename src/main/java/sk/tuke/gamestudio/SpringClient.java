package sk.tuke.gamestudio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.tuke.gamestudio.minesweeper.PlaygroundJPA;
import sk.tuke.gamestudio.minesweeper.consoleui.ConsoleUI;
import sk.tuke.gamestudio.service.ScoreService;
import sk.tuke.gamestudio.service.ScoreServiceJDBC;
import sk.tuke.gamestudio.service.ScoreServiceJPA;

@SpringBootApplication
public class SpringClient {
    public static void main (String[] args){
        SpringApplication.run(SpringClient.class);
    }


    @Bean
    public CommandLineRunner runner(ConsoleUI console){
        return s -> console.play();
    }
    //@Bean
    public CommandLineRunner runnerJPA(PlaygroundJPA console){
        return s -> console.play();
    }


    @Bean
    public PlaygroundJPA consoleJPA(){
        return new PlaygroundJPA();
    }
    @Bean
    public ConsoleUI console(){
        return new ConsoleUI();
    }

    @Bean
    public ScoreService scoreService(){
        return new ScoreServiceJPA();
        //return new ScoreServiceJDBC();
    }

}


/*
import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringClient {

    public static void main(String[] args) {
        SpringApplication.run(SpringClient.class);
    }
}
*/


/*
import org.springframework.boot.SpringApplication;


public class SpringClient {

    public static void main(String[] args) {
        SpringApplication.run(SpringClient.class);
    }
}
*/
