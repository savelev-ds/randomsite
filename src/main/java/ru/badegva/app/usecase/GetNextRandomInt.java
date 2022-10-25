package ru.badegva.app.usecase;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GetNextRandomInt {

    private static final Random random = new Random();

    public int execute(int maxExclusive) {
        return random.nextInt(maxExclusive);
    }

}
