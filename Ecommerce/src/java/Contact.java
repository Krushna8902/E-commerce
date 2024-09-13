
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Krushna Siraskar
 */
public class Contact extends HttpServlet
{
    protected void processRequest(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out=res.getWriter())
        {
            out.println("<html><body>");
            String name=req.getParameter("name");
            String mail=req.getParameter("email");
            String mobile=req.getParameter("mobile");
            String subject=req.getParameter("subject");
            String msg=req.getParameter("description");
            String qury="insert into Contact( Name,  Email, Mobile,Subject, Message ) values(?,?,?,?,?);"; 
            Connection conn=DatabaseConnection.IntilizeConnection();
            
            PreparedStatement s=conn.prepareStatement(qury);
            
            s.setString(1,name);
            s.setString(2,mail);
            s.setString(3,mobile);
            s.setString(4,subject);
            s.setString(5,msg);
            s.executeUpdate();
            
            
            out.println("<script>alert(\"registered Sucessfully\")</script></body></html>");
            res.sendRedirect("index");
        }
        catch(ClassNotFoundException | NumberFormatException | SQLException e)
        {
            out.println("error");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

      @Override
    public String getServletInfo() {
        return "Short description";
    }
}
