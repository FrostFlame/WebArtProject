package ru.kpfu.itis.group11501.serazetdinov.task2.dao.implementations;

import ru.kpfu.itis.group11501.serazetdinov.task2.dao.interfaces.UserDAO;
import ru.kpfu.itis.group11501.serazetdinov.task2.entities.Image;
import ru.kpfu.itis.group11501.serazetdinov.task2.entities.User;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.ImageServiceImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.ImageService;
import ru.kpfu.itis.group11501.serazetdinov.task2.singletons.ConnectionSingleton;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by 1 on 02.11.2016.
 */
public class UserDAOImpl implements UserDAO {
    private Connection conn = ConnectionSingleton.getConnection();

    @Override
    public List<User> getUsers() {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from users");
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getInt("image_id"),
                        rs.getString("mail"),
                        rs.getString("skype"),
                        rs.getString("country"),
                        rs.getString("city"),
                        rs.getString("education"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getDate("birthdate")
                );
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean createUser(String login, String password, String mail, String skype, String country, String city, String education, String firstname, String lastname, Date birthdate) {

        try {
            PreparedStatement st = conn.prepareStatement("insert into users (login, password, mail, skype, country, city," +
                    " education, firstname, lastname, birthdate, status_view, status_messages, status_notifications, status_friends, image_id)" +
                    "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, login);
            st.setString(2, password);
            st.setString(3, mail);
            st.setString(4, skype);
            st.setString(5, country);
            st.setString(6, city);
            st.setString(7, education);
            st.setString(8, firstname);
            st.setString(9, lastname);
            st.setDate(10, (java.sql.Date) birthdate);
            st.setInt(11, 0);
            st.setInt(12, 0);
            st.setInt(13, 0);
            st.setInt(14, 0);
            st.setLong(15, 39);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }


    @Override
    public User getUserByLogin(String login) {
        if (login == null)
            return null;
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * from users where \"login\" like ?");
            st.setString(1, "%" + login + "%");
            ResultSet rs = st.executeQuery();
            User user = null;
            ImageService imageService = new ImageServiceImpl();
            while (rs.next()) {
                Image image = imageService.getImageById(rs.getLong("image_id"));
                user = new User(rs.getLong("Id"), rs.getString("login"), rs.getString("password"), rs.getLong("image_id"),
                        rs.getString("mail"), rs.getString("skype"), rs.getString("country"), rs.getString("city"),
                        rs.getString("education"), rs.getString("firstname"), rs.getString("lastname"),
                        rs.getDate("birthdate"), image);
            }
            return user;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public User getUserById(long id) {
        try {
            PreparedStatement st = conn.prepareStatement("select * from Users where id = ?");
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                ImageService imageService = new ImageServiceImpl();
                Image image = imageService.getImageById(rs.getLong("image_id"));
                return new User(rs.getLong("Id"), rs.getString("login"), rs.getString("password"), rs.getLong("image_id"),
                        rs.getString("mail"), rs.getString("skype"), rs.getString("country"), rs.getString("city"),
                        rs.getString("education"), rs.getString("firstname"), rs.getString("lastname"),
                        rs.getDate("birthdate"), image);
            }
            else return null;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public String loginUser(String login, String password) {
        try {
            PreparedStatement st = conn.prepareStatement("select * from users where login like ?");
            st.setString(1, "%" + login + "%");
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                if (password.equals((rs.getString("password")))) {
                    return "log in";
                } else {
                    return "password";
                }
            } else {
                return "user";
            }
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public void chageFirstnameById(long id, String firstname) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE users set firstname = ? where id = ?");
            st.setString(1, firstname);
            st.setLong(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeLastnameById(long id, String lastname) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE users set lastname = ? where id = ?");
            st.setLong(2, id);
            st.setString(1, lastname);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeStatusNotificationsById(long id, String disable_notifications) {
        try {
            PreparedStatement st = conn.prepareStatement("update users set status_notifications = ? where id = ?");
            st.setLong(2, id);
            if(disable_notifications == null){
                st.setInt(1, 0);
                st.execute();
            }
            else {
                st.setInt(1, 1);
                st.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeStatusFriendsById(long id, String add_friends) {
        try {
            PreparedStatement st = conn.prepareStatement("update users set status_friends = ? where id = ?");
            st.setLong(2, id);
            switch (add_friends) {
                case "Anyone":
                    st.setInt(1, 0);
                    st.execute();
                    break;
                case "Friends of your friends":
                    st.setInt(1, 1);
                    st.execute();
                    break;
                default:
                    st.setInt(1, 2);
                    st.execute();
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeStatusViewById(long id, String watch_pics) {
        try {
            PreparedStatement st = conn.prepareStatement("update users set status_view = ? where id = ?");
            st.setLong(2, id);
            switch (watch_pics) {
                case "Anyone":
                    st.setInt(1, 0);
                    st.execute();
                    break;
                case "Friends and their friends":
                    st.setInt(1, 1);
                    st.execute();
                    break;
                case "Friends":
                    st.setInt(1, 2);
                    st.execute();
                    break;
                default:
                    st.setInt(1, 3);
                    st.execute();
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeStatusMessagesById(long id, String send_messages) {
        try {
            PreparedStatement st = conn.prepareStatement("update users set status_messages = ? where id = ?");
            st.setLong(2, id);
            switch (send_messages) {
                case "Anyone":
                    st.setInt(1, 0);
                    st.execute();
                    break;
                case "Friends and their friends":
                    st.setInt(1, 1);
                    st.execute();
                    break;
                case "Friends":
                    st.setInt(1, 2);
                    st.execute();
                    break;
                default:
                    st.setInt(1, 3);
                    st.execute();
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changePasswordByUserId(long id, String password_new1) {
        try {
            PreparedStatement st = conn.prepareStatement("update users set password = ? where id = ?");
            st.setLong(2, id);
            st.setString(1, password_new1);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeMailById(long id, String mail) {
        try {
            PreparedStatement st = conn.prepareStatement("update users set mail = ? where id = ?");
            st.setLong(2, id);
            st.setString(1, mail);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeSkypeById(long id, String skype) {
        try {
            PreparedStatement st = conn.prepareStatement("update users set skype = ? where id = ?");
            st.setLong(2, id);
            st.setString(1, skype);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeEducationById(long id, String education) {
        try {
            PreparedStatement st = conn.prepareStatement("update users set education = ? where id = ?");
            st.setLong(2, id);
            st.setString(1, education);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeCityById(long id, String city) {
        try {
            PreparedStatement st = conn.prepareStatement("update users set city = ? where id = ?");
            st.setLong(2, id);
            st.setString(1, city);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeCountryById(long id, String country) {
        try {
            PreparedStatement st = conn.prepareStatement("update users set country = ? where id = ?");
            st.setLong(2, id);
            st.setString(1, country);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeAvatar(long image_id, long user_id) {
        try {
            PreparedStatement st = conn.prepareStatement("UPDATE users set image_id = ? where id = ?");
            st.setLong(1, image_id);
            st.setLong(2, user_id);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getUsersSearch(String search) {
        try {
            PreparedStatement st = conn.prepareStatement("select * from users where firstname like ? or lastname like ?");
            st.setString(1, "%" + search + "%");
            st.setString(2, "%" + search + "%");
            ResultSet rs = st.executeQuery();
            List<User> users = new ArrayList<>();
            while(rs.next()){
                ImageService imageService = new ImageServiceImpl();
                long image_id = rs.getLong("image_id");
                Image image = imageService.getImageById(image_id);
                User user = new User(rs.getLong("Id"), rs.getString("login"), rs.getString("password"), image_id,
                        rs.getString("mail"), rs.getString("skype"), rs.getString("country"), rs.getString("city"),
                        rs.getString("education"), rs.getString("firstname"), rs.getString("lastname"),
                        rs.getDate("birthdate"), image);
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
           return null;
        }
    }

}
