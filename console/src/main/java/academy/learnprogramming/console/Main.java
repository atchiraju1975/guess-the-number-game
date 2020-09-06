package academy.learnprogramming.console;

import academy.learnprogramming.AppConfig;
import academy.learnprogramming.MessageGenerator;
import academy.learnprogramming.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        log.info("Hello Info Logging");
        log.info("Guess the number game");
        log.debug("Hello Debug Logging");

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        int number = numberGenerator.next();

        log.info("number = {}", number);

        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        String messageMainString = messageGenerator.getMainMessage("Main.class");
        String messageResultString = messageGenerator.getResultMessage("Main.class");

        log.debug(messageMainString);
        log.debug(messageResultString);
        context.close();
    }

}
