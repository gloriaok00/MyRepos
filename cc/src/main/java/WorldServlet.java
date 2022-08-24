import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @description 随机练习
 * @date 2022/7/20 23:07
 */
public class WorldServlet extends HttpServlet {

    private Connection con;

    @Override
    public void init() throws ServletException {
        //TODO ERROR
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("WEB-INF/db.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //TODO
            Class.forName(prop.getProperty("mysql.db.driver-class-name"));
            con = DriverManager.getConnection(prop.getProperty("mysql.db.url"), prop.getProperty("mysql.db.username"), prop.getProperty("mysql.db.password"));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Statement st = con.createStatement();
            String sql = "select * from employees limit 10";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("emp_no") + "-" + rs.getString("first_name") + "-" + rs.getString("last_name"));
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.getWriter().print("<h1>中文我爱你</h1>");
    }

}
