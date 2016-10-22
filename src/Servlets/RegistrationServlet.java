package Servlets;

import Singletons.ConfigSingleton;
import Singletons.ConnectionSingleton;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 22.10.2016.
 */
@javax.servlet.annotation.WebServlet(name = "Servlets.RegistrationServlet")
public class RegistrationServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            Statement st = ConnectionSingleton.getConnection().createStatement();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String repeatpassword = request.getParameter("repeat-password");

            ResultSet rs = st.executeQuery("select * from users where username = '" + username + "'");

            if (rs.next()) {
                response.sendRedirect("/registration?err=Username already taken&log=" + username);
            } else if (!password.equals(repeatpassword)) {
                response.sendRedirect("/registration?err=Wrong password&log=" + username);
            } else {
                st.executeUpdate("insert into users(username, password)values('" + username + "', '" + password + "');");
                request.getSession().setAttribute("current_user", username);
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(365 * 24 * 60 * 60);
                response.addCookie(cookie);
                response.sendRedirect("/private");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Configuration cfg = ConfigSingleton.getConfig(request.getServletContext());
        Template tmpl = cfg.getTemplate("registration.ftl");
        String log = "";
        if (request.getParameter("log") != null)
            log = request.getParameter("log");
        String err = "";
        if (request.getParameter("err") != null)
            err = request.getParameter("err");
        Map<String, Object> root = new HashMap<>();
        root.put("log", log);
        root.put("err", err);
        try {
            tmpl.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
