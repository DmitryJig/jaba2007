package course3.lesson6.efremov.testing;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * используем зависимость junit-jupiter-api,
 * вверху тестового класса указан пакет совпадающий с пакетом тестируемого класса
 */

class CalculatorTest {
    private Calculator calculator;

    @BeforeAll // выполнится один раз перед тем как все тесты запустятся
    public static void before(){
        //
    }

    @BeforeEach // выполняется перед каждым тестом
    public void init(){
        calculator = new Calculator();
    }

    @Test
    public void testCommutative(){
        final int res1 = calculator.add(1, 2);
        final int res2 = calculator.add(2, 1);
        assertThat(res1, Matchers.equalTo(3)); // проверка на равенство
        assertThat(res1, Matchers.greaterThan(2)); // больше чем
        assertThat(res1, lessThan(4)); // меньше чем
        assertThat(res1, Matchers.allOf(lessThan(4), greaterThan(2), equalTo(3))); // проверка на несколько условий
        assertThat(res1, anyOf(lessThan(4), greaterThan(2), equalTo(3))); // хотябы одно условие

        assertTrue(res1 == res2);
    }

    @Test
    public void testAddForPositiveNumbers(){
        long result = calculator.add(1, 1);
        assertEquals(2, result);
    }

    @Test
    public void testAddPositiveAndNegativeNumbers(){
        long result = calculator.add(-1, 1);
        assertEquals(0, result);
    }

    @Test
    public void testAddBigNumbers(){
        assertThrows(RuntimeException.class, ()-> calculator.add(Integer.MAX_VALUE - 2, 3));
    }
}