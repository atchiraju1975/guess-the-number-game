package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator{

    private static final Logger log = LoggerFactory.getLogger(MessageGenerator.class);

    @Autowired
    private Game game;

    private int guessCount = 10;

    //--Init--//
    @PostConstruct
    public void init(){
        log.info("game = {}", game);
    }

    @Override
    public String getMainMessage(String methodName) {

        log.debug("Printing Get Main Message from " + methodName);
        return ("Returning Main Message from " + methodName);
    }

    @Override
    public String getResultMessage(String methodName) {

        log.debug("Printing Get Result Message from " + methodName);
        return ("Returning Result Message from " + methodName);
    }
}
