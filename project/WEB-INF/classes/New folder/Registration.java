import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Registration extends HttpServlet {
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
                    
		  
	PrintWriter out= response.getWriter();
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String firstname = request.getParameter("firstname");
	String lastname = request.getParameter("lastname");
	String usertype = request.getParameter("usertype");
	String occupation = request.getParameter("occupation");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
		// HttpSession session=request.getSession(false);  
	MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities(); 
	 boolean value = mydata.getConnection();
	if(!value)
	{
		
		Utilities utility = new Utilities(request,out);
		utility.printHtml("Header.html");
		out.println("<section id=\"content\">");
		out.println("<h1>Your MYSQL Server is closed. Please Start your Mysql Server</h1>");

		out.println("</section>");
		utility.printHtml("Sidebar.html");
		utility.printHtml("Footer.html");
	}
	else
	{
		Utilities utility = new Utilities(request,out);
		utility.printHtml("Header.html");
		utility.printHtml("Register.html");
		utility.printHtml("Sidebar.html");
		utility.printHtml("Footer.html");
	}
//request.getRequestDispatcher("/RegistrationParser").forward(request, response);
}   
}