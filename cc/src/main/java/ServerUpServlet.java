import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;

/**
 * @description 应用启动时就会被加载
 * @date 2022/8/24 01:07
 */

public class ServerUpServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("应用启动时就会被加载");
    }
}
