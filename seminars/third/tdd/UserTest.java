package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    /**
     * Разработайте класс User с методом аутентификации по логину и паролю. Метод должен возвращать true, если
     * введенные логин и пароль корректны, иначе false. Протестируйте все методы
     */

    User user;
    @BeforeEach
    void setUp() {
        user = new User("User", "Password", false);
    }

    @ParameterizedTest
    @CsvSource({"Uzer, Pazzword, false", "User, Password, true"})
    public void authenticateTest(String name, String password, boolean b) {
        assertThat(user.authenticate(name, password)).isEqualTo(b);
    }

}