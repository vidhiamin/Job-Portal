import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Profile extends HttpServlet
{
	public void doGet(HttpServletRequest request,  HttpServletResponse response)  throws ServletException, IOException
	{
		PrintWriter pw= response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session=request.getSession(); 
		Users user = (Users)session.getAttribute("user");
		Utilities utility = new Utilities(request,pw);
		if(session.getAttribute("user")!= null )  
		{
			Users users  = new Users();
			System.out.println("======Inside users========");
			users= (Users)session.getAttribute("user");
			if(user.getusertype().equals("Candidate"))
			{
				System.out.println("======Inside candidate========");
				utility.printHtml("HeaderLogout.html");
				utility.printHtml("Profile.html");
				utility.printHtml("Sidebar.html");
				utility.printHtml("Footer.html");
			}
		}
		else
		{
				utility.printHtml("Header.html");
				//utility.printHtml("Job.html");
				pw.println("<section id=\"content\">");                  
				pw.println("<h2 style=\"color:red\"> Please login First </h2>"); 
				pw.println("<h2 style=\"color:blue\"> Click Here for Login : <a href=\"Login\" color=\"red\">Login</a> </h2>");             
				pw.println("</section>");
				
				
				utility.printHtml("Sidebar.html");
				utility.printHtml("Footer.html");
			
			
		}
		

//request.getRequestDispatcher("/LoginParser").forward(request, response);
}		

}