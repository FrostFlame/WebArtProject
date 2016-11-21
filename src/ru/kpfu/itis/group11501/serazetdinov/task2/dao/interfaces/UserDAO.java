package ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces;

import ru.kpfu.itis.group11501.serazetdinov.task2.entities.User;

import java.util.Date;
import java.util.List;

/**
 * Created by 1 on 02.11.2016.
 */
public interface UserDAO {
    List<User> getUsers();

    boolean createUser(String login, String password, String mail, String skype, String country, String city,
                       String education, String firstname, String lastname, Date birthdate);

    User getUserByLogin(String login);

    User getUserById(long id);

    String loginUser(String login, String password);


    void chageFirstnameById(long id, String firstname);

    void changeLastnameById(long id, String lastname);

    void changeStatusNotificationsById(long id, String disable_notifications);

    void changeStatusFriendsById(long id, String add_friends);

    void changeStatusViewById(long id, String watch_pics);

    void changeStatusMessagesById(long id, String send_messages);

    void changePasswordByUserId(long id, String password_new1);

    void changeMailById(long id, String mail);

    void changeSkypeById(long id, String skype);

    void changeEducationById(long id, String education);

    void changeCityById(long id, String city);

    void changeCountryById(long id, String country);

    void changeAvatar(long image_id, long user_id);

    List<User> getUsersSearch(String search);
}
