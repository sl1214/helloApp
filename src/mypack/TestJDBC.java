package mypack;

import javax.servlet.*;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestJDBC implements Filter {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMdd");
        try {
            int days = (int) ((sdf.parse("20201025").getTime() - sdf.parse("20200428").getTime()) / (24 * 3600 * 1000));
            System.out.println(days);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /*Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mysql?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
        String user = "root";
        String password = "sc56132131";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,password);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.execute("insert into test_user values (20201022,'123')");


            PreparedStatement preparedStatement = connection.prepareStatement("select * from test_user where user_id = ?");
            preparedStatement.setInt(1,20201021);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
            }
            connection.commit();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            if (connection != null) {
                connection.rollback();
            }
            //can't register driver
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }*/

    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    public void destroy() {

    }
}
