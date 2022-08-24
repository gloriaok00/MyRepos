import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @description 应用启动时就会被加载
 * @date 2022/8/24 01:07
 */

public class ServerUpServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("应用启动时就会被加载");
        getServletContext().setAttribute("s1","也可以往ServletContext里放入Attribute啊");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this is server up");
    }
}
