package academy.learnprogramming;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Getter
@Component
public class NumberGeneratorImpl implements NumberGenerator{

    private final Random random = new Random();

    private final int maxNumber;
    private final int minNumber;

    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    @Override
    public int next()
    {

        int nextRandomGenerated = (random.nextInt(maxNumber - minNumber)) + minNumber;
        log.debug("Random Number Generated is = " + nextRandomGenerated);
        return (nextRandomGenerated);

    }

//    @Override
//    public int getMaxNumber()
//    {
//        return maxNumber;
//    }
//
//    @Override
//    public int getMinNumber()
//    {
//        return minNumber;
//    }
}
