package ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations.*;
import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.*;
import ru.kpfu.itis.group11501.serazetdinov.task2.helpers.Helpers;
import ru.kpfu.itis.group11501.serazetdinov.task2.entities.*;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 1 on 02.11.2016.
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();
    private GenreDAO genreDAO = new GenreDAOImpl();
    private Favourite_GenreDAO favourite_genreDAO = new Favourite_GenreDAOImpl();
    private Users_RolesDAO users_rolesDAO = new Users_RolesDAOImpl();
    private RoleDAO roleDAO = new RoleDAOImpl();
    private FriendDAO friendDao = new FriendDAOImpl();
    private CookieDAO cookieDAO = new CookieDAOImpl();


    @Override
    public List<User> getAllUsers() {
        return userDAO.getUsers();
    }

    @Override
    public boolean createNewUser(String login, String password, String mail, String skype, String country, String city,
                                 String education, String firstname, String lastname, Date birthdate, String genres) {
        boolean f = userDAO.createUser(login, password, mail, skype, country, city, education, firstname, lastname,
                birthdate);
        String[] genresl = genres.split(", ");
        for (String genre : genresl) {
            if (!genre.equals("")) {
                if (genreDAO.getGenreByName(genre) == null) {
                    genreDAO.createGenre(genre);
                }
                favourite_genreDAO.createFavouriteGenre(userDAO.getUserByLogin(login).getId(),
                        genreDAO.getGenreByName(genre).getId());
            }
        }
        long user_id = userDAO.getUserByLogin(login).getId();
        long role_id = roleDAO.getRoleByName("common_user").getId();
        users_rolesDAO.createRelation(user_id, role_id);
        return f;
    }

    @Override
    public User getUserByLogin(String login) {
        return userDAO.getUserByLogin(login);
    }

    @Override
    public User getUserById(long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void changeSettings(HttpServletRequest request, HttpServletResponse response) {
        User user = getUserByLogin((String) request.getSession().getAttribute("current_user"));
        long id = user.getId();
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String mail = request.getParameter("mail");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String education = request.getParameter("education");
        String skype = request.getParameter("skype");
        String password_current = request.getParameter("password_current");

        if (!password_current.equals("")) {
            password_current = Helpers.md5Custom(password_current);
            if (!password_current.equals(user.getPassword())) {
                try {
                    response.sendRedirect("/settings?err=Wrong password&firstname=" + firstname + "&lastname=" +
                            lastname + "&mail=" + mail + "&skype=" + skype + "&education=" + education + "&city=" +
                            city + "&country=" + country);
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String password_new1 = request.getParameter("password_new1");
            String password_new2 = request.getParameter("password_new2");

            if (password_new1.length() < 6) {
                try {
                    response.sendRedirect("/settings?err=Password should have 6 chars length min&firstname=" + firstname
                            + "&lastname=" + lastname + "&mail=" + mail + "&skype=" + skype + "&education=" + education
                            + "&city=" + city + "&country=" + country);
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (!password_new1.equals(password_new2)) {
                try {
                    response.sendRedirect("/settings?err=Wrong repeated new password password&firstname=" + firstname +
                            "&lastname=" + lastname + "&mail=" + mail + "&skype=" + skype + "&education=" + education +
                            "&city=" + city + "&country=" + country);
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            userDAO.changePasswordByUserId(id, Helpers.md5Custom(password_new1));
        }
        if (!firstname.equals("")) {
            userDAO.chageFirstnameById(id, firstname);
        }
        if (!lastname.equals(""))
            userDAO.changeLastnameById(id, lastname);
        if (!mail.equals(""))
            userDAO.changeMailById(id, mail);
        if (!skype.equals(""))
            userDAO.changeSkypeById(id, skype);
        if (!education.equals(""))
            userDAO.changeEducationById(id, education);
        if (!city.equals(""))
            userDAO.changeCityById(id, city);
        if (!country.equals(""))
            userDAO.changeCountryById(id, country);
        String disable_notifications = request.getParameter("disable_notifications");
        userDAO.changeStatusNotificationsById(id, disable_notifications);
        String add_friends = request.getParameter("add_friends");
        userDAO.changeStatusFriendsById(id, add_friends);
        String watch_pics = request.getParameter("watch_pics");
        userDAO.changeStatusViewById(id, watch_pics);
        String send_messages = request.getParameter("send_messages");
        userDAO.changeStatusMessagesById(id, send_messages);
        try {
            response.sendRedirect("/settings");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String registrateUser(String login, String password, String repeatedpassword, String mail, String skype,
                                 String country, String city, String education, String firstname, String lastname,
                                 Date birthdate, String genres) {
        User user = this.getUserByLogin(login);
        if (!mail.equals("")) {
            Pattern pattern = Pattern.compile(".*@.*");
            Matcher m = pattern.matcher(mail);
            if (!m.matches()) {
                return "email";
            }
        }
        if (user != null) {
            return "exists";
        } else if (password.length() < 6) {
            return "no password";
        } else if (!password.equals(repeatedpassword)) {
            return "password";
        } else {
            String s = Helpers.md5Custom(password);
            createNewUser(login, s, mail, skype, country, city, education, firstname, lastname, birthdate, genres);

            return "created";
        }
    }

    @Override
    public void loginUser(String login, String password, String remember, HttpServletRequest request, HttpServletResponse response) {
        try {
            if (login.equals("")) {
                response.sendRedirect("/login?err=Enter the login");
                return;
            }
            String s = userDAO.loginUser(login, password);
            if (s.equals("user")) {
                response.sendRedirect("/login?err=User does not exist.&log=" + login);
            } else {
                if (s.equals("password")) {
                    response.sendRedirect("/login?err=Incorrect password&log=" + login);
                } else {
                    request.getSession().setAttribute("current_user", login);
                    if (remember != null) {
                        Cookie cookie = new Cookie("username", login);
                        cookie.setMaxAge(365 * 24 * 60 * 60);
                        response.addCookie(cookie);
                        cookieDAO.createRelation(userDAO.getUserByLogin(login).getId(), Helpers.md5Custom(cookie.toString()));
                    }
                    response.sendRedirect("/private");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getFavouriteGenresByUserId(long id) {
        List<String> genres = new ArrayList<>();
        List<Long> ids = favourite_genreDAO.getGenresByUserId(id);
        for (long l : ids) {
            genres.add(genreDAO.getGenreById(l).getGenre());
        }
        for (int i = 0; i < genres.size(); i++) {
            genres.set(i, genres.get(i));
        }
        return genres;
    }

    @Override
    public void changeAvatar(long image_id, long user_id) {
        userDAO.changeAvatar(image_id, user_id);
    }

    @Override
    public List<User> getUsersSearch(String search) {
        return userDAO.getUsersSearch(search);
    }

    @Override
    public List<User> getFriendsById(long id) {
        return friendDao.getFriendsById(id);
    }


}
