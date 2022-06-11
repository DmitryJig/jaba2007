package course3.lesson6.homework6;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Homework6Test {

    Homework6 homework6;

    @BeforeEach
    void init() {
        homework6 = new Homework6();
    }


    // Тесты первого метода
    @Test
    void testGetNumbersAfterLastNumber() {
        int[] testArray = {Integer.MAX_VALUE, 0, Integer.MIN_VALUE, 4, 0};
        int number = 4;
        Assertions.assertArrayEquals(new int[]{0}, homework6.getNumbersAfterLastNumber(testArray, number));
    }

    @Test
    public void testGetNumbersAfterLastNumberWithMatchers() {
        int[] array = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] res = homework6.getNumbersAfterLastNumber(array, 4);
        int[] expected = {1, 7};

        MatcherAssert.assertThat(res, Matchers.is(expected));
    }

    @Test // тест без 4, проверяем что метод бросает исключение
    public void testGetNumbersAfterLastNumberWithException() {
        int[] testArray = {1, 2, 5,7, 9};
        int number = 4;
        Assertions.assertThrows(RuntimeException.class, ()-> homework6.getNumbersAfterLastNumber(testArray, number));
    }

    @ParameterizedTest
    @MethodSource("provideArrayForLastNumbers")
    public void testGetNumbersAfterLastNumberParametrized(int[] inputArray, int[] expectedArray){
        int number = 4;
        int[] arrayResult = homework6.getNumbersAfterLastNumber(inputArray, number);
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


    // Тесты второго метода
    @Test
    public void testCheckAvailable1And4(){
        int[] array = {1, 1, 1, 4, 4, 1, 4, 4};
        Assertions.assertTrue(homework6.checkAvailable1And4(array, 1, 4));
    }

    @Test
    public void testCheckAvailable1And4WithMatchers(){
        int[] array = {1, 1, Integer.MAX_VALUE, 4, 4, 1, 4, Integer.MIN_VALUE};
        boolean res = homework6.checkAvailable1And4(array, 1, 4);
        MatcherAssert.assertThat(true, Matchers.not(res));
    }


    /**
     * Метод проверяет неверные комбинации цифр в массиве (на выдачу false)
     * из файла-источника
     * Не смог найти как из файла принять в параметры метода массив,
     * по этому принимаем строку и парсим ее
     * к сожалению таким способом не парсится Integer.MAX_VALUE и MIN_VALUE
     * @param numbers строка с цифрами разделенными пробелами
     */
    @ParameterizedTest
    @CsvFileSource(resources = "inputData.csv", numLinesToSkip = 1)
    void testCheckAvailable1And4Parametrized(String numbers) {
        // Парсим строку в массив целых чисел
        int[] arr = Arrays.stream(numbers.split("\\p{Zs}")).mapToInt(n -> Integer.parseInt(n)).toArray();
        Assertions.assertFalse(homework6.checkAvailable1And4(arr, 1, 4));
    }
}
