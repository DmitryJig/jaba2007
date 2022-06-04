package course3.lesson6.homework6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Homework6Test {

    Homework6 homework6;

    @BeforeEach
    void init() {
        homework6 = new Homework6();
    }

    @Test // тест без 4
    void testGetNumbersAfterLastNumberWithException() {
        int[] testArray = {1, 2, 5,7, 9};
        Assertions.assertThrows(RuntimeException.class, ()-> homework6.getNumbersAfterLastNumber(testArray, 4));
    }

    @ParameterizedTest
    @MethodSource("provideArrayForLastNumbers")
    public void testGetNumbersAfterLastNumberParametrized(int[] inputArray, int[] expectedArray){
        int[] arrayResult = homework6.getNumbersAfterLastNumber(inputArray, 4);
        Assertions.assertArrayEquals(expectedArray, arrayResult);
    }

    private static Stream<Arguments> provideArrayForLastNumbers(){
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{5}),
                Arguments.of(new int[]{5, 4, 3, 2, 1}, new int[]{3, 2, 1}),
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{}),
                Arguments.of(new int[]{4}, new int[]{}),
                Arguments.of(new int[]{4, 3, 2, -1}, new int[]{3, 2, -1})
        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "input")
    void testCheckAvailable1And4Parametrized() {
    }



}