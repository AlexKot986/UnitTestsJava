package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepositoryTest {

    /**
     * Добавьте класс UserRepository для управления пользователями. В этот класс должен быть включен метод
     * addUser, который добавляет пользователя в систему, если он прошел аутентификацию. Покройте тестами новую
     * функциональность
     */

    User user;
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        user = new User("User", "Password", false);
        userRepository = new UserRepository();
    }

    @Test
    public void addUserFalseTest() {
        userRepository.addUser((user));

        assertFalse(userRepository.data.contains(user));
    }

    @Test
    public void addUserTrueTest() {
        user.authenticate("User", "Password");
        userRepository.addUser(user);

        assertTrue(userRepository.data.contains(user));
    }

    @ParameterizedTest
    @CsvSource({"User, true", "User1, false"})
    public void findByNameTest(String username, boolean b) {
        user.authenticate("User", "Password");
        userRepository.addUser(user);

        assertThat(userRepository.findByName(username)).isEqualTo(b);
    }

    /**
     * Задача 3
     * Добавьте функцию в класс UserRepository, которая разлогинивает всех пользователей,
     * кроме администраторов. Для этого, вам потребуется расширить класс User новым свойством,
     * указывающим, обладает ли пользователь админскими правами. Протестируйте данную функцию
     */
    @Test
    public void usersUnLogTest() {
        User user1 = new User("User1", "Password1", false);
        User admin = new User("Admin", "1234", true);
        user.authenticate("User", "Password");
        user1.authenticate("User1", "Password1");
        admin.authenticate("Admin", "1234");
        userRepository.addUser(user);
        userRepository.addUser(user1);
        userRepository.addUser(admin);

        userRepository.usersUnLog();

        assertTrue((userRepository.data.size() == 1) && (userRepository.findByName(admin.name)));
    }

}
