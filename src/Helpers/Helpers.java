package Helpers;

import Singletons.ConfigSingleton;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * Created by 1 on 24.10.2016.
 */
public class Helpers {
    public void render(HttpServletRequest request, HttpServletResponse response, String template, Map root) throws IOException {
        Configuration cfg = ConfigSingleton.getConfig(request.getServletContext());
        Template tmpl = cfg.getTemplate(template);
        try {
            tmpl.process(root, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    public static String md5Custom(String st) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(st.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        BigInteger bigInt = new BigInteger(1, digest);
        String md5Hex = bigInt.toString(16);

        while( md5Hex.length() < 32 ){
            md5Hex = "0" + md5Hex;
        }

        return md5Hex;
    }
}
