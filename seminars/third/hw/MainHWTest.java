package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Java6Assertions.assertThat;

class MainHWTest {

    MainHW mainHW;

    @BeforeEach
    void setUp() {
        mainHW = new MainHW();
    }

    /**
     *  HW 3.1. Нужно покрыть тестами метод на 100%
     *  Метод проверяет, является ли целое число записанное в переменную n, чётным (true) либо нечётным (false).
     * @param n test digit
     */
    @ParameterizedTest
    @ValueSource(ints = {-7, 113, 43, Integer.MAX_VALUE})
    public void evenOddNumberTestFalse(int n) {
        assertThat(mainHW.evenOddNumber(n)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {-46, Integer.MIN_VALUE, 0, 1032})
    public void evenOddNumberTestTrue(int n) {
        assertThat(mainHW.evenOddNumber(n)).isTrue();
    }

    /**
     * HW 3.2. Нужно написать метод который проверяет, попадает ли переданное число в интервал (25;100) и возвращает true, если попадает и false - если нет,
     * покрыть тестами метод на 100%
     * @param n тестовое число
     * @param b ожидаемое значение
     */
    @ParameterizedTest
    @CsvSource({"1, false", "57, true", "123, false", "25, true", "-101, false", "100, true"})
    public void numberInInterval(int n, boolean b) {
        assertThat(mainHW.numberInInterval(n)).isEqualTo(b);
    }

}