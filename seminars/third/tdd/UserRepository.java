package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if (user.isAdmin) {
            data.add(user);
        } else if (!findByName(user.name)) {
            if (user.isAuthenticate) {
                data.add(user);
            }
        }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Задача 3
     *  Добавьте функцию в класс UserRepository, которая разлогинивает всех пользователей,
     *  кроме администраторов. Для этого, вам потребуется расширить класс User новым свойством,
     *  указывающим, обладает ли пользователь админскими правами. Протестируйте данную функцию
     */

    public void usersLogOut() {
        List<User> users = new ArrayList<>(data);
        users.forEach(user -> {
            if (!user.isAdmin) {
                user.isAuthenticate = false;
                data.remove(user);
            }
        });
    }

}