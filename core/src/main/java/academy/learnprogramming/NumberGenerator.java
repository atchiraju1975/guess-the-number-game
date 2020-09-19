package academy.learnprogramming;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public interface NumberGenerator {

    Random random = new Random();
    int next();
    int getMaxNumber();
    int getMinNumber();
}
