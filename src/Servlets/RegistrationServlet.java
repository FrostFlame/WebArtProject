package Servlets;

import Singletons.ConfigSingleton;
import Singletons.ConnectionSingleton;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 19.10.2016.
 */
@WebServlet(name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Statement st = ConnectionSingleton.getConnection().createStatement();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String repeatpassword = request.getParameter("repeat-password");

            ResultSet rs = st.executeQuery("select * from users where username = '" + username + "'");

            if (rs.next()) {
                response.sendRedirect("/registration?err=username already taken&log=" + username);
            } else {
                if(password.equals(repeatpassword)) {
                    st.executeUpdate("insert into users(username, password)values ('" + username + "', '" + password + "');");
                    request.getSession().setAttribute("current_user", username);
                    Cookie cookie = new Cookie("username", username);
                    cookie.setMaxAge(365 * 24 * 60 * 60);
                    response.addCookie(cookie);
                    response.sendRedirect("/private");
                }
                else{
                    response.sendRedirect("/registration?err=wrong password&log=" + username);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
