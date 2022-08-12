package sk.tuke.gamestudio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;
import sk.tuke.gamestudio.minesweeper.PlaygroundJPA;
import sk.tuke.gamestudio.minesweeper.consoleui.ConsoleUI;
import sk.tuke.gamestudio.service.ScoreService;
import sk.tuke.gamestudio.service.ScoreServiceJDBC;
import sk.tuke.gamestudio.service.ScoreServiceJPA;
import sk.tuke.gamestudio.service.ScoreServiceREST;

@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX,
        pattern = "sk.tuke.gamestudio.server.*"))
public class SpringClient {
    public static void main (String[] args){

        //SpringApplication.run(SpringClient.class);
        new SpringApplicationBuilder(SpringClient.class).web(WebApplicationType.NONE).run(args);
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
        return new ScoreServiceREST();
        //return new ScoreServiceJPA();
        //return new ScoreServiceJDBC();
    }

    @Bean
    public RestTemplate restTemplate(){ return new RestTemplate();}

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
