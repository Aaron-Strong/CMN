package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet("/login")
public class Loginservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("[Login Servlet] : Received POST request, proceeding ....");

            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pfa_medico?" +
                    "user=mehdi" + "&" +
                    "password=mehdi" +
                    "&serverTimezone=UTC");

            PreparedStatement myPreparedStatement = myConnection.prepareStatement(
                    "select * from patient where ? = username and ? = password"
            );
            myPreparedStatement.setString(1,req.getParameter("login"));
            myPreparedStatement.setString(2,req.getParameter("password"));
            ResultSet myResult = myPreparedStatement.executeQuery();
            System.out.println("[LoginServlet] : Retrieving ResultSet ...");

            if (myResult.next()) {
                final String Username = myResult.getString("username");
                final String Role = "patient";
                        System.out.println("[LoginServlet] : logged as -> "+myResult.getString( "email"));
                HttpSession session=req.getSession();

                session.setAttribute("username",Username);
                session.setAttribute("role",Role);

            }


            myResult.close();
            myPreparedStatement.close();
            myConnection.close();
        } catch (Exception e) {
            System.out.printf("[LoginServlet] Error : ");
            e.printStackTrace();
            req.getRequestDispatcher("/WEB-INF/deverror.jsp").forward(req,resp);

        }

//System.out.println(" request login  attribute : "+req.getParameter("login"));


    }
}