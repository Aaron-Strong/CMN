package servlet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/")
public class mainservlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   //   req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);


        req.getRequestDispatcher("/WEB-INF/form.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection myConnection = null;
        try {
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pfa_medico?"+
                    "user=mehdi"+"&"+
                    "password=mehdi"+
                    "&serverTimezone=UTC");

PreparedStatement myStatement = myConnection.prepareStatement("insert into vaccin  (dataVaccin,nomvaccin) values (?,?) ");
            myStatement.setDate(1, Date.valueOf(req.getParameter("dateVaccin")));
            myStatement.setString(2,req.getParameter("nomVaccin"));
int resultSet = myStatement.executeUpdate();
            myConnection.close();
            myStatement.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
