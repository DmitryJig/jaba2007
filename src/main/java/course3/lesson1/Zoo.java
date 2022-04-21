package course3.lesson1;

import java.util.ArrayList;
import java.util.List;

/**
 * параметризованный класс
 */
public class Zoo<T> {
    private List<T> animals;

    public Zoo() {
        this.animals = new ArrayList<>();
    }


}
