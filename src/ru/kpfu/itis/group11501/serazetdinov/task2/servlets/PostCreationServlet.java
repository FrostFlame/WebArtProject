package ru.kpfu.itis.group11501.serazetdinov.task2.servlets;

import ru.kpfu.itis.group11501.serazetdinov.task2.helpers.Helpers;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ru.kpfu.itis.group11501.serazetdinov.task2.entities.User;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.ImageServiceImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.NewsServiceImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.implementations.UserServiceImpl;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.ImageService;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.NewsService;
import ru.kpfu.itis.group11501.serazetdinov.task2.services.interfaces.UserService;

/**
 * Created by 1 on 06.11.2016.
 */
@MultipartConfig
public class PostCreationServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private ImageService imageService = new ImageServiceImpl();
    private NewsService newsService = new NewsServiceImpl();
    private Random random = new Random();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String folder = (String) request.getSession().getAttribute("current_user");
        File theDir = new File("F:\\Projects\\images\\" + folder);
        boolean flag = theDir.mkdir();
//
//
//        //проверяем является ли полученный запрос multipart/form-data
//        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//        if (!isMultipart) {
//            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
//            return;
//        }
//
//        // Создаём класс фабрику
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//
//        // Максимальный буфера данных в байтах,
//        // при его привышении данные начнут записываться на диск во временную директорию
//        // устанавливаем один мегабайт
//        factory.setSizeThreshold(1024*1024);
//
//        // устанавливаем временную директорию
//        File tempDir = (File)getServletContext().getAttribute("javax.servlet.context.tempdir");
//        factory.setRepository(tempDir);
//
//        //Создаём сам загрузчик
//        ServletFileUpload upload = new ServletFileUpload(factory);
//
//        //максимальный размер данных который разрешено загружать в байтах
//        //по умолчанию -1, без ограничений. Устанавливаем 10 мегабайт.
//        upload.setSizeMax(1024 * 1024 * 10);
//        String link = "";
//        try {
//            List items = upload.parseRequest(request);
//            Iterator iter = items.iterator();
//
//            while (iter.hasNext()) {
//                FileItem item = (FileItem) iter.next();
//
//                if (item.isFormField()) {
//                    //если принимаемая часть данных является полем формы
//                } else {
//                    //в противном случае рассматриваем как файл
//                    link = processUploadedFile(item, folder);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            return;
//        }
        Part filePart = request.getPart("file");
        String link = request.getSession().getAttribute("current_user") + "/" +  request.getSession().getAttribute("current_user") + random.nextInt();
        if (filePart != null) {
            link = Helpers.downloadPhoto(filePart, link);
        }
        String tags = request.getParameter("tags");
        String title = request.getParameter("title");
        String text = request.getParameter("text");
        imageService.createImage(link);
        newsService.createPost(request.getParameter("title"), request.getParameter("text"),
                userService.getUserByLogin((String) request.getSession().getAttribute("current_user")).getId(),
                imageService.getImageByLink(link).getId(), tags);

        response.sendRedirect("/private");
    }

    /**
     * Сохраняет файл на сервере, в папке upload.
     * Сама папка должна быть уже создана.
     *
//     * @param item
     * @throws Exception
     */
//    private String processUploadedFile(FileItem item, String folder) throws Exception {
//        File uploadetFile = null;
//        //выбираем файлу имя пока не найдём свободное
//        String link;
//        do{
//            link = "/images/" + folder + "/" + random.nextInt() + item.getName();
//            String path = getServletContext().getRealPath(link);
//            uploadetFile = new File(path);
//        }while(uploadetFile.exists());
//
//        //создаём файл
//        uploadetFile.createNewFile();
//        //записываем в него данные
//        item.write(uploadetFile);
//        return link;
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userService.getUserByLogin((String) request.getSession().getAttribute("current_user"));
        String title = "";
        if (request.getParameter("title") != null)
            title = request.getParameter("title");
        String text = "";
        if (request.getParameter("text") != null)
            text = request.getParameter("text");
        String tags = "";
        if (request.getParameter("tags") != null)
            tags = request.getParameter("tags");
        Map<String, Object> root = new HashMap<>();
        root.put("user", user);
        root.put("title", title);
        root.put("text", text);
        root.put("tags", tags);
        Helpers.render(request, response, "post_creation.ftl", root);
    }


}
