package ru.kpfu.itis.group11501.serazetdinov.task2.servlets;

import ru.kpfu.itis.group11501.serazetdinov.task2.helpers.Helpers;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.UserServiceImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.UserService;

import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 22.10.2016.
 */
public class RegistrationServlet extends javax.servlet.http.HttpServlet {
    private UserService userService = new UserServiceImpl();

//    @Override
//    public void init() throws ServletException {
//
//        super.init();
//    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repeatpassword = request.getParameter("repeat-password");
        String firstname = request.getParameter("first_name");
        String lastname = request.getParameter("last_name");
        String email = request.getParameter("email");
        String skype = request.getParameter("skype");
        String education = request.getParameter("education");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String genres = request.getParameter("genres");
        String birthdate = request.getParameter("birthdate");
        if (username.equals("")){
            response.sendRedirect("/registration?err=Enter login&log=" + username + "&first_name=" +
                    firstname + "&last_name=" + lastname + "&email=" + email + "&skype=" + skype + "&education=" +
                    education + "&city=" + city + "&country=" + country + "&genres=" + genres + "&birthdate=" + birthdate);
            return;
        }
        if (birthdate.equals("")){
            response.sendRedirect("/registration?err=Enter birth date&log=" + username + "&first_name=" +
                    firstname + "&last_name=" + lastname + "&email=" + email + "&skype=" + skype + "&education=" +
                    education + "&city=" + city + "&country=" + country + "&genres=" + genres + "&birthdate=" + birthdate);
            return;
        }
        Date date = Date.valueOf(birthdate);
        String s = userService.registrateUser(username, password, repeatpassword, email, skype, country, city, education,
                firstname, lastname, date, genres);

        if (s.equals("date")){
            response.sendRedirect("/registration?err=Enter birth date&log=" + username + "&first_name=" +
                    firstname + "&last_name=" + lastname + "&email=" + email + "&skype=" + skype + "&education=" +
                    education + "&city=" + city + "&country=" + country + "&genres=" + genres + "&birthdate=" + birthdate);
            return;
        }else if (s.equals("exists")) {
            response.sendRedirect("/registration?err=Username already taken&log=" + username + "&first_name=" +
                    firstname + "&last_name=" + lastname + "&email=" + email + "&skype=" + skype + "&education=" +
                    education + "&city=" + city + "&country=" + country + "&genres=" + genres + "&birthdate=" + birthdate);
            return;
        }else if (s.equals("no password")){
            response.sendRedirect("/registration?err=Password should be 6 chars length min&log=" + username + "&first_name=" +
                    firstname + "&last_name=" + lastname + "&email=" + email + "&skype=" + skype + "&education=" +
                    education + "&city=" + city + "&country=" + country + "&genres=" + genres + "&birthdate=" + birthdate);
        } else if (s.equals("password")) {
            response.sendRedirect("/registration?err=Wrong repeated password&log=" + username + "&first_name=" +
                    firstname + "&last_name=" + lastname + "&email=" + email + "&skype=" + skype + "&education=" +
                    education + "&city=" + city + "&country=" + country + "&genres=" + genres + "&birthdate=" + birthdate);
            return;
        } else if (s.equals("email")) {
            response.sendRedirect("/registration?err=Enter write email or nothing&log=" + username + "&first_name=" +
                    firstname + "&last_name=" + lastname + "&email=" + email + "&skype=" + skype + "&education=" +
                    education + "&city=" + city + "&country=" + country + "&genres=" + genres + "&birthdate=" + birthdate);
            return;
        }else {
            response.sendRedirect("/login");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String log = "";
        if (request.getParameter("log") != null)
            log = request.getParameter("log");
        String err = null;
        if (request.getParameter("err") != null)
            err = request.getParameter("err");
        String firstname = "";
        if (request.getParameter("first_name") != null)
            firstname = request.getParameter("first_name");
        String lastname = "";
        if (request.getParameter("last_name") != null)
            lastname = request.getParameter("last_name");
        String email = "";
        if (request.getParameter("email") != null)
            email = request.getParameter("email");
        String skype = "";
        if (request.getParameter("skype") != null)
            skype = request.getParameter("skype");
        String education = "";
        if (request.getParameter("education") != null)
            education = request.getParameter("education");
        String city = "";
        if (request.getParameter("city") != null)
            city = request.getParameter("city");
        String country = "";
        if (request.getParameter("country") != null)
            country = request.getParameter("country");
        String genres = "";
        if (request.getParameter("genres") != null)
            genres = request.getParameter("genres");
        String birthdate = "";
        if (request.getParameter("birthdate") != null)
            birthdate = request.getParameter("birthdate");
        Map<String, Object> root = new HashMap<>();
        root.put("log", "\"" + log + "\"");
        root.put("err", err);
        root.put("first_name", "\"" + firstname + "\"");
        root.put("last_name", "\"" + lastname + "\"");
        root.put("birthdate", birthdate);
        root.put("email", "\"" + email + "\"");
        root.put("country", "\"" + country + "\"");
        root.put("city", "\"" + city + "\"");
        root.put("skype", "\"" + skype + "\"");
        root.put("education", "\"" + education + "\"");
        root.put("genres", "\"" + genres + "\"");
        Helpers.render(request, response, "registration.ftl", root);
    }
}
