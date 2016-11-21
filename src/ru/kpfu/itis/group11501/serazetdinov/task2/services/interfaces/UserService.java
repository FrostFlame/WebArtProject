package ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces;

import ru.kpfu.itis.group11501.serazetdinov.task2.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by 1 on 02.11.2016.
 */
public interface UserService {
    public List<User> getAllUsers();

    public boolean createNewUser(String login, String password, String mail, String skype, String country, String city,
                                 String education, String firstname, String lastname, Date birthdate, String genres);

    public User getUserByLogin(String login);

    public User getUserById(long id);

    public void changeSettings(HttpServletRequest request, HttpServletResponse response);

    public String registrateUser(String login, String password, String repeatedpassword, String mail, String skype,
                                 String country, String city, String education, String firstname, String lastname,
                                 Date birthdate, String genres);

    public void loginUser(String login, String password, String remember, HttpServletRequest request, HttpServletResponse response);

    List<String> getFavouriteGenresByUserId(long id);

    void changeAvatar(long image_id, long user_id);

    List<User> getUsersSearch(String search);

    List<User> getFriendsById(long id);
}
