package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageGeneratorImpl implements MessageGenerator{

    private static final Logger log = LoggerFactory.getLogger(MessageGenerator.class);

    private Game game;

    @Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    //--Init--//
    @PostConstruct
    public void init(){
        log.info("game = {}", game);
    }

    @Override
    public String getMainMessage() {

        log.debug("Printing Get Main Message from gerMainMessage");
        return "Number is between " + game.getSmallest() + " and " +
                game.getBiggest() + " can you guess it?";
    }

    @Override
    public String getResultMessage() {

        log.debug("Printing Get Result Message from getResultMessage");
        if(game.isGameWon()){
            return "You Guessed it right!, The number was " + game.getNumber();
        }else if (game.isGameLost()){
            return "You Guessed it wrong!, The number was " + game.getNumber();
        }else if(!game.isValidNumberRange()){
            return "Invalid Number Range";
        }else if(game.getRemainingGuesses() == game.getGuessCount()){
            return "What is your first guess?";
        }else{
            String direction = "Lower";
            if(game.getGuess() < game.getNumber()){
            direction = "Higher";
            }
            return direction + " You have " + game.getRemainingGuesses() + " guesses left";
        }
    }
}
