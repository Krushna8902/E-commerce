
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
public class BuyInsert extends HttpServlet
{
    protected void processRequest(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out=res.getWriter())
        {
            out.println("<html><body>");
            String pname=req.getParameter("pname");
            
            String mail=req.getParameter("email");
            String price=req.getParameter("price");
            String qury="insert into product_list( Product_Name, Email,Price) values(?,?,?);"; 
            Connection conn=DatabaseConnection.IntilizeConnection();
            out.println(mail);
            out.println(pname);
            out.println(price);
            PreparedStatement s=conn.prepareStatement(qury);
            
            s.setString(1,pname);
            s.setString(2,mail);
            s.setString(3,price);
            
            s.executeUpdate();
            
            
            out.println("<script>alert(\"registered Sucessfully\")</script></body></html>");
            res.sendRedirect("Buy");
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