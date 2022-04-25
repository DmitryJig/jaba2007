package course3.lesson1.homework1;

import java.util.Objects;

public class Orange extends Fruit{
    private final float WEIGHT = 1.5f;

    public float getWEIGHT() {
        return WEIGHT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orange orange = (Orange) o;
        return Float.compare(orange.WEIGHT, WEIGHT) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(WEIGHT);
    }
}
