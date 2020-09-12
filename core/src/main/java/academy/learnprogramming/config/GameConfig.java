package academy.learnprogramming.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    //==fields==//

    private int maxNumber = 25;
    private int guessCount = 10;

    //==beanMethods==//

    public int maxNumber(){
        return maxNumber;
    }

    public int guessCount(){
        return guessCount;
    }


}
