package course2.lesson8;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalApp {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("str");

//        optional.get();
        String fromOpt = optional.orElse("EmptyString");
        optional.map(s -> s.toUpperCase());
    }
}
