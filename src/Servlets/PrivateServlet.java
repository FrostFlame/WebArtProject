package Servlets;

import Classes.Post;
import Helpers.Helpers;
import Singletons.ConnectionSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.*;

/**
 * Created by 1 on 25.10.2016.
 */
@WebServlet(name = "PrivateServlet")
public class PrivateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection conn = ConnectionSingleton.getConnection();
            String username = (String) request.getSession().getAttribute("current_user");
            PreparedStatement st = conn.prepareStatement("select * from Users where login = ?" );
            st.setString(1, username);
            ResultSet rs1 = st.executeQuery();
            st = conn.prepareStatement("select link from images where id = ?");
            st.setInt(1, rs1.getInt("images_id"));
            ResultSet rs2 = st.executeQuery();
            st = conn.prepareStatement("select genre from Genres where id in (select genres_id from Favourites_genres where users_id = ?)");
            st.setInt(1, rs1.getInt("id"));
            ResultSet rs3 = st.executeQuery();
            st = conn.prepareStatement("select count(*)as amount from News where user_id = ?");
            st.setInt(1, rs1.getInt("id"));
            ResultSet rs4 = st.executeQuery();
            int count_posts = rs4.getInt("amount");
            st = conn.prepareStatement("select count(*) as amount from Friends where user_id = ?)");
            st.setInt(1, rs1.getInt("id"));
            ResultSet rs5 = st.executeQuery();
            int count_friends = rs5.getInt("amount");
            st = conn.prepareStatement("select * from News where user_id = ?");
            st.setInt(1, rs1.getInt("id"));
            ResultSet rs6 = st.executeQuery();
            List<Post>posts = new ArrayList<>();
            while(rs6.next()){
                st = conn.prepareStatement("select count(*) as likes from Likes where images_id = ?");
                st.setInt(1, rs6.getInt("image_id"));
                ResultSet likes = st.executeQuery();
                st = conn.prepareStatement("select link from images where id = ?");
                st.setInt(1, rs6.getInt("image_id"));
                ResultSet src = st.executeQuery();
                Post post = new Post(rs6.getString("title"), likes.getInt("likes"), src.getString("link"), rs6.getDate("data"));
                posts.add(post);
            }
            Map<String, Object> root = new HashMap<>();
            List<String> genres = new LinkedList<>();
            while (rs3.next()){
                genres.add(rs3.getString("genre"));
            }
            root.put("posts", posts);
            root.put("genres", genres);
            root.put("img", rs2.getString("link"));
            root.put("firstname", rs1.getString("firstname"));
            root.put("lastname", rs1.getString("lastname"));
            root.put("login", rs1.getString("login"));
            root.put("city", rs1.getString("city"));
            root.put("country", rs1.getString("country"));
            root.put("mail", rs1.getString("mail"));
            root.put("education", rs1.getString("education"));
            root.put("count_posts", count_posts);
            root.put("count_friends", count_friends);
            Helpers h = new Helpers();
            h.render(request, response, "private.ftl", root);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
