import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;

public class MyProfile extends HttpServlet
{

  
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String education = request.getParameter("education");
		String summary = request.getParameter("summary");
		String excompany = request.getParameter("excompany");
		String experiod = request.getParameter("experiod");
		String skills = request.getParameter("skills");
		String certifications = request.getParameter("certifications");
		String projects = request.getParameter("projects");
		//Saxpaser handler = new Saxpaser();
		//HashMap<String, Candidates> hm3 = handler.getCandidates();		 
		HttpSession session=request.getSession();
		Candidates candidate =(Candidates)session.getAttribute("username");
		String uname = candidate.username;
    	MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();
		HashMap<String, Candidates> or = mydata.MyProfile(uname);
		Utilities utility = new Utilities(request,out);
		utility.printHtml("HeaderLogout.html");	
	for (Map.Entry<String,Candidates> entry : or.entrySet())
    {
     Candidates c =(Candidates)entry.getValue();
		out.println("<div id=\"body\">");
		out.println("<section id=\"content\">");
		out.println("<h1>My Profile</h1>");
		out.println("<form action =\"MyProfile\"  method=\"get\">");
		out.println("<ul>");
		out.println("<li class=\"desc\">Username : " + c.getusername() +"</li>");
		out.println("<li>First Name: $" + c.getfirstname() + "</li>");	
		out.println("<li>Last Name:" + c.getlastname() + "</li>");
		out.println("<li>Education:" + c.geteducation() + "</li>");
		out.println("<li>Summary:" + c.getsummary() + "</li>");
		out.println("<li>Experience Company:" + c.getexcompany() + "</li>");
		out.println("<li>Experience Period:" + c.getexperiod() + "</li>");
		out.println("<li>Skills:" + c.getskills() + "</li>");
		out.println("<li>Certifications:" + c.getcertifications() + "</li>");
		out.println("<li>Projects:" + c.getprojects() + "</li>");
		out.println("</ul>");
		out.println("</form>");
		out.println("</section>");
	}
	utility.printHtml("Sidebar.html");
    utility.printHtml("Footer.html");
	}
}