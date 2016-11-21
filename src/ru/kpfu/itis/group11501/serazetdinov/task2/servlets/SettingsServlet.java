package ru.kpfu.itis.group11501.serazetdinov.task2.servlets;

import ru.kpfu.itis.group11501.serazetdinov.task2.entities.User;
import ru.kpfu.itis.group11501.serazetdinov.task2.helpers.Helpers;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.ImageServiceImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.BlacklistService;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.BlacklistServiceImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.ImageService;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.UserService;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by 1 on 06.11.2016.
 */
@MultipartConfig
public class SettingsServlet extends HttpServlet {
    private Random random = new Random();
    private UserService userService;
    private BlacklistService blacklistService = new BlacklistServiceImpl();
    private ImageService imageService = new ImageServiceImpl();


    @Override
    public void init() throws ServletException {
        super.init();
        userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file");
        if (filePart.getSize() != 0) {
            String folder = (String) request.getSession().getAttribute("current_user");
            File theDir = new File("F:\\Projects\\images\\" + folder);
            boolean flag = theDir.mkdir();
            String link = request.getSession().getAttribute("current_user") + "/" + request.getSession().getAttribute("current_user") + random.nextInt();
            if (filePart != null) {
                link = Helpers.downloadPhoto(filePart, link);
            }
            imageService.createImage(link);
            userService.changeAvatar(imageService.getImageByLink(link).getId(), userService.getUserByLogin((String) request.getSession().getAttribute("current_user")).getId());
        }
        userService.changeSettings(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userService.getUserByLogin((String) request.getSession().getAttribute("current_user"));
        List<User>blacklist = blacklistService.getUsersByUser(user.getId());
        String err = null;
        if (request.getParameter("err") != null)
            err = request.getParameter("err");
        String firstname = "";
        if (request.getParameter("firstname") != null)
            firstname = request.getParameter("firstname");
        String lastname = "";
        if (request.getParameter("lastname") != null)
            lastname = request.getParameter("lastname");
        String mail = "";
        if (request.getParameter("mail") != null)
            mail = request.getParameter("mail");
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

        Map<String, Object> root = new HashMap<>();
        root.put("user", user);
        root.put("blacklist", blacklist);
        root.put("err", err);
        root.put("firstname", firstname);
        root.put("lastname", lastname);
        root.put("mail", mail);
        root.put("country", country);
        root.put("city", city);
        root.put("skype", skype);
        root.put("education", education);
        Helpers.render(request, response, "settings.ftl", root);
    }
}
