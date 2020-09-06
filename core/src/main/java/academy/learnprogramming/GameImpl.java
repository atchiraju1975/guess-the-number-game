package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class GameImpl implements Game{

    //== constants at the top ==//

    private static final Logger log = LoggerFactory.getLogger(Game.class);

    //== variables ==//
    @Autowired
    private NumberGenerator numberGenerator;
    private int guessCount = 10;
    private int number;
    private int guess;
    private int remainingGuesses;
    private int smallest;
    private int biggest;
    private boolean validNumberRange = true;

    //==public methods to the top==//


    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    @Override
    public void reset() {

        smallest = 0;
        guess = 0;
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("the number is {}" , number);

    }

    @Override
    public void check() {

        if (guess > number) {
            biggest = guess - 1;
        }

        if (guess < number) {
            smallest = guess + 1;
        }

        remainingGuesses--;

    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return (number == guess);
    }

    @Override
    public boolean isGameLost() {
        return (!isGameWon() && remainingGuesses <= 0);
    }

    //==private methods==//

    private void checkValidNumberRange(){
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }

}
