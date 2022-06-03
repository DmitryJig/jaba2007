package course3.lesson6.efremov.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalcParamsTest {
    private Calculator calculator;

    @BeforeEach
    public void before(){
        calculator = new Calculator();
    }

    private static Stream<Arguments> provideArgs(){
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(-1, 1, 0),
                Arguments.of(1000, 1, 1001),
                Arguments.of(-1, 1, 0),
                Arguments.of(-1, -1, -2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgs")
    public void test (int a, int b, int expected){
        Assertions.assertEquals(expected, calculator.add(a, b));
    }



    @ParameterizedTest
    // указываем файл источник, и количество пропускаемых строк (заголовок)
    // файл расположен в папке тест, путь повторяет путь к тестируемому файлу
    @CsvFileSource(resources = "data.csv", numLinesToSkip = 1)
    public void testСым (int a, int b, int expected){
        Assertions.assertEquals(expected, calculator.add(a, b));
    }
}
