import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @description
 * @date 2022/7/20 23:07
 */
public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("db.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = prop.getProperty("mysql.db.url");
        System.out.println("test:" + url);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO
        /*  OutputStream out = res.getOutputStream();
        out.write("Hello Servlet!!".getBytes());*/
        resp.getWriter().print("<h1>Hello JavaWeb!中文我爱你</h1>");
    }
}
