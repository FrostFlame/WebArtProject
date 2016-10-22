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
 * Created by 1 on 19.10.2016.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            Statement st = ConnectionSingleton.getConnection().createStatement();
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            ResultSet rs = st.executeQuery("select * from users where username like '" + username + "'");

            if (rs.next()) {
                if (rs.getString("username").equals(username)) {
                    if (password.equals(rs.getString("password"))) {
                        request.getSession().setAttribute("current_user", username);
                        Cookie cookie = new Cookie("username", username);
                        cookie.setMaxAge(365 * 24 * 60 * 60);
                        response.addCookie(cookie);
                        response.sendRedirect("/private");
                    } else {
                        response.sendRedirect("/login?err=Incorrect password&log=" + username);
                    }
                }
            } else {
                response.sendRedirect("/login?err=Incorrect login&log=" + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Configuration cfg = ConfigSingleton.getConfig(request.getServletContext());
        Template tmpl = cfg.getTemplate("login.ftl");
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
