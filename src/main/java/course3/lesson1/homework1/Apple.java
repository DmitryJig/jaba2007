package course3.lesson1.homework1;

import java.util.Objects;

public class Apple extends Fruit{
    private final float WEIGHT = 1.0f;

    public float getWEIGHT() {
        return WEIGHT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return Float.compare(apple.WEIGHT, WEIGHT) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(WEIGHT);
    }
}
