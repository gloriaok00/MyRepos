import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @description 第一次被访问时才创建这个Servlet
 * @date 2022/8/24 01:08
 */

public class FirstUseServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("第一次被访问时才创建这个Servlet");
        System.out.println(getServletContext().getAttribute("s1"));
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this is first use");
        resp.getWriter().print("<h1>中文我爱你</h1>");
    }
}
