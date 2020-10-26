package mypack;

import sun.jdbc.odbc.ee.DataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class TestDataSourceServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        DataSource dataSource = null;
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/TestDB");
            Connection connection = dataSource.getConnection();
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
            connection.close();
            resultSet.close();
            preparedStatement.close();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
