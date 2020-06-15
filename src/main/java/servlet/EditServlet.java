package servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/edit-profil")
public class EditServlet extends HttpServlet {
  /*  boolean isInfoChanged(HttpServletRequest req,String columnName,String)
    {
    req.getSession().getAttribute(columnName).equals(req.getAttribute());
    }
*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/edit-profil.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("[EditServlet] : patient id :"+req.getSession().getAttribute("id"));
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pfa_medico?"+
                    "user=mehdi"+"&"+
                    "password=mehdi"+
                    "&serverTimezone=UTC");

            PreparedStatement myStatement = myConnection.prepareStatement("select * from patient where id = ?");
            myStatement.setString(1,req.getSession().getAttribute("id").toString());
            ResultSet patientInfo = myStatement.executeQuery();
            System.out.println("[EditServlet] Executing Query : "+myStatement.toString());
            if(patientInfo.next()) {
                System.out.println("[EditServlet] : Found Patient info : " + patientInfo.getString("email"));
//        //-------------MOCK---------------
//                System.out.println("[EditServlet] : Mocking update ...");/*
//                       System.out.println("adresse : "+(req.getParameter("adresse")==null?req.getSession().getAttribute("adresse").toString():req.getParameter("adresse")));
//                System.out.println("civilite :"+(req.getParameter("civilite")==null?req.getSession().getAttribute("civilite").toString():req.getParameter("civilite")));
//                System.out.println("Date naissance : "+(req.getParameter("datenaissance")==""?req.getSession().getAttribute("datenaissance").toString():req.getParameter("datenaissance")));
//
//                System.out.println("Assurance : "+req.getParameter("assurance")*//*==null?req.getSession().getAttribute("assurance").toString():req.getParameter("assurance")*//*);*/
//                //----------END MOCK-------------*/

                PreparedStatement updateQuery = myConnection.prepareStatement("update patient" +
                        " set adresse = ?," +
                         "civilite = ?," +
                         "datenaissance = ?," +
                          "email=?,"+
                         "nom=?,"+
                        "password=?,"+
                        "numtelephone=?,"+
                        "assurance=?,"+
                        "profession=?"+
                        "where patient.id ="+req.getSession().getAttribute("id").toString());
                updateQuery.setString(1, (req.getParameter("adresse")==null||req.getParameter("adresse")==""?req.getSession().getAttribute("adresse").toString():req.getParameter("adresse")));
                updateQuery.setString(2, (req.getParameter("civilite")==null||req.getParameter("civilite")==""?req.getSession().getAttribute("civilite").toString():req.getParameter("civilite")));
                updateQuery.setString(3, (req.getParameter("datenaissance")==null||req.getParameter("datenaissance")==""?req.getSession().getAttribute("datenaissance").toString():req.getParameter("datenaissance")));
                updateQuery.setString(4, (req.getParameter("email")==null||req.getParameter("email")==""?req.getSession().getAttribute("email").toString():req.getParameter("email")));
                updateQuery.setString(5, (req.getParameter("nom")==null||req.getParameter("nom")==""?req.getSession().getAttribute("nom").toString():req.getParameter("nom")));
                updateQuery.setString(6, (req.getParameter("password")==null||req.getParameter("password")==""?req.getSession().getAttribute("password").toString():req.getParameter("password")));
                updateQuery.setString(7, (req.getParameter("numtelephone")==null||req.getParameter("numtelephone")==""?req.getSession().getAttribute("numtelephone").toString():req.getParameter("numtelephone")));
                updateQuery.setString(8, (req.getParameter("assurance")==null||req.getParameter("assurance")==""?(req.getSession().getAttribute("assurance")==null?"":req.getSession().getAttribute("assurance").toString()):req.getParameter("assurance")));
                updateQuery.setString(9, (req.getParameter("profession")==null||req.getParameter("profession")==""?(req.getSession().getAttribute("profession")==null?"":req.getSession().getAttribute("profession").toString()):req.getParameter("profession")));

                System.out.println("[EditServlet] Executing Update Query : "+updateQuery.toString());
                updateQuery.execute();
            updateQuery.close();
        }
            patientInfo.close();
            myStatement.close();
            myConnection.close();
            resp.sendRedirect(req.getContextPath()+"/index");


        } catch (SQLException e) {
            System.out.printf("[EditServet] : SQL ERROR ! : ");
            e.printStackTrace();
        }
    }
}
