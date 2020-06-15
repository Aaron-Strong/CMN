package servlet;

import models.Patient;
import models.Rendezvous;

import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/index")
public class mainservlet extends HttpServlet {

boolean intToBoolean(ResultSet column,String columnName)
{
    try {
        System.out.println("[MainServlet] : column.getInt("+columnName+") = "+column.getInt(columnName) );
        if(column.getInt(columnName)== 1)
        {
            System.out.println("[MainServlet] : column.getInt("+columnName+") = "+column.getInt(columnName) );

            return true;
        }


    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
if(req.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI) != null)
{
    System.out.println("[MainServlet] : Forwarded request leaving doGet ...");
    return;
}

        System.out.println("[MainServlet] : Redirected to index.jsp");
     //   req.getRequestDispatcher("/WEB-INF/form.jsp").forward(req,resp);
        Connection myConnection = null;
        try {
            myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pfa_medico?"+
                    "user=mehdi"+"&"+
                    "password=mehdi"+
                    "&serverTimezone=UTC");
            System.out.println("[Main Servlet] : session role attribute = "+req.getSession().getAttribute("role"));
if(req.getSession().getAttribute("role").equals("patient")){

     PreparedStatement myStatement = myConnection.prepareStatement("select * from patient where patient.username=? ");
     myStatement.setString(1,req.getSession().getAttribute("username").toString());
     ResultSet myResultSet = myStatement.executeQuery();
    System.out.println("[MainServlet] : select * from patient");
     if(myResultSet.next())
     {         System.out.println("[MainServlet] : Found user  : "+myResultSet.getString("username"));
         req.getSession().setAttribute("id",myResultSet.getInt("id"));
         req.getSession().setAttribute("adresse",myResultSet.getString("adresse"));
         /*String gender = (myResultSet.getBoolean("civilite")?"Homme":"femme");*/
         req.getSession().setAttribute("civilite",myResultSet.getBoolean("civilite"));
         req.getSession().setAttribute("datenaissance",myResultSet.getDate("datenaissance"));
         req.getSession().setAttribute("email",myResultSet.getString("email"));
         req.getSession().setAttribute("nom",myResultSet.getString("nom"));
         req.getSession().setAttribute("password",myResultSet.getString("password"));
        req.getSession().setAttribute("numtelephone",myResultSet.getString("numtelephone"));
         req.getSession().setAttribute("username",myResultSet.getString("username"));
         req.getSession().setAttribute("medecin",myResultSet.getInt("medecin"));
         req.getSession().setAttribute("assurance",myResultSet.getString("assurance"));
         req.getSession().setAttribute("profession",myResultSet.getString("profession"));
         req.getSession().setAttribute("remarque",myResultSet.getString("remarque"));
         req.getSession().setAttribute("maladie",myResultSet.getInt("maladie"));
         req.getSession().setAttribute("vaccins",myResultSet.getInt("vaccins"));
         req.getSession().setAttribute("images",myResultSet.getInt("images"));
         req.getSession().setAttribute("allergies",myResultSet.getInt("allergies"));

         PreparedStatement mesRendezvous = myConnection.prepareStatement("select * from rendezvous where patientid = ?");
        mesRendezvous.setString(1, req.getSession().getAttribute("id").toString());
        ResultSet rendezvousList = mesRendezvous.executeQuery();
         List<Rendezvous> lesrendezvous= new ArrayList<Rendezvous>();
         int i=0;
        while(rendezvousList.next())
        {

            lesrendezvous.add(new Rendezvous(rendezvousList.getInt("id"),
                                                rendezvousList.getString("nom"),
                                                rendezvousList.getString("description"),
                                                rendezvousList.getDate("date"),
                                          intToBoolean(rendezvousList,"critique"),
                                                rendezvousList.getInt("patientid")));
            System.out.println("[MainServlet] : added rdv :"+lesrendezvous.get(i).getNom() +" is critique ? "+lesrendezvous.get(i).isCritique());
            i++;
        }
        req.getSession().setAttribute("rendezvous",lesrendezvous);
rendezvousList.close();
mesRendezvous.close();
myStatement.close();
myConnection.close();
     }





}
if(req.getSession().getAttribute("role").equals("medecin")){
                System.out.println("[MainServlet] : select * from medecin");
                PreparedStatement myStatement = myConnection.prepareStatement("select * from medecin  ");
}


        } catch (SQLException e) {
            System.out.printf("[MainServlet] : Error SQL ! : ");
            e.printStackTrace();
        }


        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req,resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

}
}
