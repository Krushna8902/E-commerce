
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Krushna Siraskar
 */
public class Buy extends HttpServlet{
    
    protected void processRequest(HttpServletRequest req,HttpServletResponse res) throws ServletException ,IOException
    {
        res.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = res.getWriter())
        {
            out.println("<!DOCTYPE html>\n" +
                        "<html lang=\"en\" ng-app=\"signupApp\">\n" +
                        "<head>\n" +
                        "  <meta charset=\"UTF-8\">\n" +
                        "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "  <title>Signup Form</title>\n" +
                        "  <!-- Bootstrap CSS -->\n" +
                        "  <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n" +
                        "  <style>\n" +
                        "    body {\n" +
                        "      background-color: #f8f9fa; \n" +
                        "    }\n" +
                        "  </style>\n" +
                        "</head>\n" +
                        "<body ng-controller=\"SignupController as vm\">\n" +
                        "\n" +
                        "  <div class=\"container mt-5\">\n" +
                        "    <div class=\"row justify-content-center\">\n" +
                        "      <div class=\"col-md-4\">\n" +
                        "        <div class=\"card\">\n" +
                        "          <div class=\"card-header\">\n" +
                        "            Order\n" +
                        "          </div>\n" +
                        "          <div class=\"card-body\">\n" +
                        "            <form  action=\"BuyInsert\" method=\"post\">\n" +
                        "              <div class=\"form-group\">\n" +
                        "                <label for=\"pname\">Product Name</label>\n" +
                        "                <input type=\"text\" name=\"pname\" class=\"form-control\" ng-model=\"vm.firstName\" placeholder=\"Enter your Product name\">\n" +
                                      
                        "              </div>\n" +
                        "              <div class=\"form-group\">\n" +
                        "                <label for=\"email\">Username</label>\n" +
                        "                <input type=\"text\" class=\"form-control\" name=\"email\" ng-model=\"vm.lastName\" placeholder=\"Enter your email\">\n" +
                                       
                        "              </div>\n" +
                        "              <div class=\"form-group\">\n" +
                        "                <label for=\"price\">Price</label>\n" +
                        "                <input type=\"text\" class=\"form-control\" name=\"price\" ng-model=\"vm.email\" placeholder=\"Enter product price\">\n" +
                                        
                        "              </div>\n" +
                                    
                        "              <button type=\"submit\" class=\"btn btn-primary\">Place Order</button>\n" +
                        "            </form>\n" +
                                    
                        "          </div>\n" +
                        "        </div>\n" +
                        "      </div>\n" +
                        "    </div>\n" +
                        "  </div>\n" +
                        "\n" +
                        "  \n" +
                        "  <script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js\"></script>\n" +
                       
                        "</body>\n" +
                        "</html>");
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