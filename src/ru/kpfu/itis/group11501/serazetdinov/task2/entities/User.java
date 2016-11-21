package ru.kpfu.itis.group11501.serazetdinov.task2.entities;

import java.util.Date;

/**
 * Created by 1 on 02.11.2016.
 */
public class User {
    private long id;
    private String login;
    private String password;
    private long image_id;
    private String mail;
    private String country;
    private String city;
    private String skype;
    private String education;
    private String firstname;
    private String lastname;
    private int status_view;
    private int status_messages;
    private int status_notifications;
    private int status_friends;
    private Date birthdate;
    private Image image;

    public User(long id, String login, String password, long image_id, String mail, String skype, String country,
                String city, String education, String firstname, String lastname, Date birthdate) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.image_id = image_id;
        if (mail == null)
            this.mail = "";
        else
            this.mail = mail;
        if (skype == null)
            this.skype = "";
        else
            this.skype = skype;
        if (country == null)
            this.country = "";
        else
            this.country = country;
        if (city == null)
            this.city = "";
        else
            this.city = city;
        if (education == null)
            this.education = "";
        else
            this.education = education;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
    }

    public User(long id, String login, String password, long image_id, String mail, String country, String city, String skype, String education, String firstname, String lastname, int status_view, int status_messages, int status_notifications, int status_friends, Date birthdate) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.image_id = image_id;
        this.mail = mail;
        this.country = country;
        this.city = city;
        this.skype = skype;
        this.education = education;
        this.firstname = firstname;
        this.lastname = lastname;
        this.status_view = status_view;
        this.status_messages = status_messages;
        this.status_notifications = status_notifications;
        this.status_friends = status_friends;
        this.birthdate = birthdate;
    }

    public User(long id, String login, String password, long image_id, String mail, String skype, String country,
                String city, String education, String firstname, String lastname, Date birthdate, Image image) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.image_id = image_id;
        if (mail == null)
            this.mail = "";
        else
            this.mail = mail;
        if (skype == null)
            this.skype = "";
        else
            this.skype = skype;
        if (country == null)
            this.country = "";
        else
            this.country = country;
        if (city == null)
            this.city = "";
        else
            this.city = city;
        if (education == null)
            this.education = "";
        else
            this.education = education;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getImage_id() {
        return image_id;
    }

    public void setImage_id(long image_id) {
        this.image_id = image_id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getStatus_view() {
        return status_view;
    }

    public void setStatus_view(int status_view) {
        this.status_view = status_view;
    }

    public int getStatus_messages() {
        return status_messages;
    }

    public void setStatus_messages(int status_messages) {
        this.status_messages = status_messages;
    }

    public int getStatus_notifications() {
        return status_notifications;
    }

    public void setStatus_notifications(int status_notifications) {
        this.status_notifications = status_notifications;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public int getStatus_friends() {
        return status_friends;
    }

    public void setStatus_friends(int status_friends) {
        this.status_friends = status_friends;
    }
}
