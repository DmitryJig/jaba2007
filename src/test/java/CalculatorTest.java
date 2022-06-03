
import course3.lesson6.gusev.Battery;
import course3.lesson6.gusev.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Использовали зависимость junit-jupiter ver 5.6.2 и mockito-junit-jupiter, пакет вверху класса не указан
 */

public class CalculatorTest {

    Calculator calculator; // в каждом тесте нужен новый объект тестируемого класса
    Battery battery = Mockito.mock(Battery.class);

    // mock

    // т. к если мы меняем состояние объекта в одном тесте второй может не заработать
    @BeforeEach
    // аннотация для выполнения метода перед каждым тестом
    void init() {
        System.out.println("initialization");
        calculator = new Calculator(battery);
    }

    @AfterEach
        // аннотация вызывает метод после каждого теста
    void tearDown() {
        System.out.println("test finished");
    }

    @Test
    @DisplayName("Тестирование сложения")
        // не обязательная опция присвоения имени тесту
    void testAddition() {
//        Calculator calculator = new Calculator(); // вынесли на уровень класса
        // end message is optional
        Assertions.assertEquals(10, calculator.sum(3, 7), "sum should be equal 10");
    }

    @Test
//    @Disabled // эта аннотация выключает тест
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
        // тест считается успешным если все проверки успешны и уложились в 500 миллисекунд
    void TestMultiplication() {
//        Calculator calculator = new Calculator();
        Assertions.assertEquals(15, calculator.multiply(3, 5));
    }

    @Test
    void TestDivisionWithException() {
        // Проверить выбрасывает ли метод исключение
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.division(10, 0));
    }

//    @Test
//    void testAdditionMultiple(){    // несколько проверок
//         в таком случае если упадет первая проверка мы не узнаем что падают остальные
//        Assertions.assertEquals(3, calculator.sum(1, 2));
//        Assertions.assertEquals(5, calculator.sum(3, 2));
//        Assertions.assertEquals(15, calculator.sum(13, 2));
//    }

    @CsvSource({
            "1, 2, 3",
            "3, 2, 5",
            "13, 2, 15"
    })  // тест будет вызван 3 раза (по количеству наборов параметров висточнике)
    @ParameterizedTest
        // требует какой нибудь сорс(пишем сверху)
    void testAdditionMultiple(int a, int b, int result) {    // несколько проверок

        Assertions.assertEquals(result, calculator.sum(a, b));

    }

    @MethodSource("dataForAddition")
    // в этом классе нам нужен метод дающий данные для теста (часто нужен для передачи объектов)
    @ParameterizedTest
        // требует какой нибудь сорс(пишем сверху)
    void testAdditionMultipleWithMethod(int a, int b, int result) {    // несколько проверок

        Assertions.assertEquals(result, calculator.sum(a, b));
    }

    // создаем стрим аргументов для вышестоящего теста, он проведет в данном случае 1000 тестов
    public static Stream<Arguments> dataForAddition() {
        List<Arguments> arguments = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int a = random.nextInt(1000);
            int b = random.nextInt(1000);
            arguments.add(Arguments.arguments(a, b, a + b));
        }

        return arguments.stream();
    }

    // мокито используется когда нам нужен объект который на момент тестирования недоступен(доступ к сети либо сервис)
    void testWithBattery(){
        Mockito.doReturn(50).when(battery.getPercent());
    }


// Buisness development Sales and Marketing

    // jsonAssert проверяет наличие строк в json
    // SODD паттерн разработки после стековерфлоу
}
