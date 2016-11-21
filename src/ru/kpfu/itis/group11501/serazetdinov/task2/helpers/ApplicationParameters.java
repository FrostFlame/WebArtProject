package ru.kpfu.itis.group11501.serazetdinov.task2.helpers;


import javax.servlet.ServletContext;

public final class ApplicationParameters {

    public final static String pathToImageParameter= "path_to_image";

    private static String pathToImage;

    public String getPathToImage() {
        return pathToImage;
    }

    public static void create(ServletContext servletContext) {

        pathToImage = servletContext.getInitParameter(ApplicationParameters.pathToImageParameter);

    }
}