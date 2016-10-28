package Servlets;

import Helpers.Helpers;
import Singletons.ConnectionSingleton;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 22.10.2016.
 */
@javax.servlet.annotation.WebServlet(name = "Servlets.RegistrationServlet")
public class RegistrationServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            Connection conn = ConnectionSingleton.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from users where username = ?");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String repeatpassword = request.getParameter("repeat-password");
            st.setString(1, "%" + username + "%");
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                response.sendRedirect("/registration?err=Username already taken&log=" + username);
            } else if (!password.equals(repeatpassword)) {
                response.sendRedirect("/registration?err=Wrong repeated password&log=" + username);
            } else {
                String s = Helpers.md5Custom(password);
                st.executeUpdate("insert into users(username, password)values('" + username + "', '" + s + "');");
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
        String log = "";
        if (request.getParameter("log") != null)
            log = request.getParameter("log");
        String err = null;
        if (request.getParameter("err") != null)
            err = request.getParameter("err");
        Map<String, Object> root = new HashMap<>();
        root.put("log", log);
        root.put("err", err);
        Helpers h = new Helpers();
        h.render(request, response, "registration.ftl", root);
    }
}
