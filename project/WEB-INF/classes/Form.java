import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Form extends javax.servlet.http.HttpServlet
{
  Utilities utility;
  PrintWriter pw;
  List<Cart> arraylist;
  
  public Form() {}
  
  	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
  {
    pw = response.getWriter();
    String OrderID  = request.getParameter("oid");
   Utilities utility = new Utilities(request,pw);
   utility.printHtml("HeaderLogout.html");
    
    pw.println("<section id=\"content\">");
    pw.println("<h2 style=\"color:red\"> Your job application  is  successfully completed. </h2>");
    //pw.println("<h2 style=\"color:blue\"> Your order num # is " + OrderID  + "  </h2>");
    
    pw.println("</section>");
    utility.printHtml("Sidebar.html");
    utility.printHtml("Footer.html");
  }
}
