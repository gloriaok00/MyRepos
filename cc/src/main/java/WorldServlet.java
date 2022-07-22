import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

/**
 *  @description
 *  @date  2022/7/20 23:07
 */
public class WorldServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.getWriter().print("<h1>中文我爱你</h1>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
