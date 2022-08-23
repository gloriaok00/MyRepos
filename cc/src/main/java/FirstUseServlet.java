import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

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
}
