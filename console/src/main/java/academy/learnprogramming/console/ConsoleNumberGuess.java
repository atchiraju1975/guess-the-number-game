package academy.learnprogramming.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ConsoleNumberGuess implements ApplicationListener {

    public static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

        log.debug("Application Event Container is ready for use");

    }
}
