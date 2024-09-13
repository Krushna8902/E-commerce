
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Krushna Siraskar
 */
public class Home extends HttpServlet {
    protected void processRequest(HttpServletRequest req,HttpServletResponse res) throws IOException ,ServletException, SQLException
    {
        PrintWriter out=res.getWriter();
        try
        {
            res.setContentType("text/html;charset=UTF-8");
            
            String user=req.getParameter("username");
            String pass=req.getParameter("password");
            try (Connection conn = DatabaseConnection .IntilizeConnection()) {
                Statement s=conn.createStatement();
                ResultSet rs=s.executeQuery("select * from register where Email='"+user+"' and Password='"+pass+"';");
                
                HttpSession session=req.getSession();
                session.setAttribute("email",user);
                if(rs.next())
                {
                    Statement f=conn.createStatement(); 
                            out.println("<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "<head>\n" +
                            "    <meta charset=\"UTF-8\">\n" +
                            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                            "    <title>Simple Dashboard</title>\n" +
                            "    <!-- Bootstrap CSS -->\n" +
                            "    <link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                            "    <style>\n" +
                            "        body {\n" +
                            "            display: flex;\n" +
                            "            min-height: 100vh;\n" +
                            "            flex-direction: column;\n" +
                            "        }\n" +
                            "        .wrapper {\n" +
                            "            display: flex;\n" +
                            "            flex: 1;\n" +
                            "        }\n" +
                            "        .sidebar {\n" +
                            "            width: 250px;\n" +
                            "            background: #343a40;\n" +
                            "            color: white;\n" +
                            "            padding: 15px;\n" +
                            "        }\n" +
                            "        .sidebar a {\n" +
                            "            color: white;\n" +
                            "            display: block;\n" +
                            "            padding: 10px 0;\n" +
                            "            text-decoration: none;\n" +
                            "            cursor: pointer;\n" +
                            "        }\n" +
                            "        .sidebar a:hover {\n" +
                            "            background: #495057;\n" +
                            "        }\n" +
                            "        .content {\n" +
                            "            flex: 1;\n" +
                            "            padding: 20px;\n" +
                            "            display: none; /* Hide all content sections by default */\n" +
                            "        }\n" +
                            "        .content.active {\n" +
                            "            display: block; /* Show the active content section */\n" +
                            "        }\n" +
                            "    </style>\n" +
                            "</head>\n" +
                            "<body>\n" 
                            );
                            ResultSet r=f.executeQuery("select * from product_list where Email='"+user+"';");
                            out.println("<table class=\"table\">\n" +
                                "  <thead class=\"thead-light\">");
                            out.println("<tr><th>ID</th><th>Product Name</th><th>Price</th><tr></thread>");       
                            while(r.next())
                            {
                                String Id=r.getString("ID");
                                String pname=r.getString("Product_Name");
                                String price=r.getString("Price");
                                out.println("<tr><td>"+Id+"</td><td>"+pname+"</td><td>"+price+"</td></tr></table>");
                            }
                            out.println("</div></body></html>");
                }
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
         out.println(e);
        } 
    }
    
     
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            System.out.print("Error");
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

      
    public String getServletInfo() {
        return "Short description";
    }            
}

