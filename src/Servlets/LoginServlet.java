package Servlets;

import Singletons.ConnectionSingleton;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import Helpers.Helpers;

/**
 * Created by 1 on 28.09.2016.
 */
public class LoginServlet extends javax.servlet.http.HttpServlet {

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            Connection conn = ConnectionSingleton.getConnection();
            PreparedStatement st = conn.prepareStatement("select * from users where username = ?");
            String username = request.getParameter("username");
            String password = Helpers.md5Custom(request.getParameter("password"));
            st.setString(1, "%" + username + "%");
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                if (password.equals((rs.getString("password")))) {
                    request.getSession().setAttribute("current_user", username);
                    Cookie cookie = new Cookie("username", username);
                    cookie.setMaxAge(365 * 24 * 60 * 60);
                    response.addCookie(cookie);
                    response.sendRedirect("/private");
                } else {
                    response.sendRedirect("/login?err=Incorrect password&log=" + username);
                }
            } else {
                response.sendRedirect("/login?err=User does nit exist.&log=" + username);
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
        h.render(request, response, "login.ftl", root);
    }
}
