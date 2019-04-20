import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class updateproductHtml extends HttpServlet
{
	Job job;
	PrintWriter out;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	out= response.getWriter();
	/* String job_id = request.getParameter("id");
	System.out.println("====================UpdateProductHtml===========" + job_id); */
	Utilities utility = new Utilities(request,out);
	utility.printHtml("HeaderAdd.html");
	utility.printHtml("udproduct.html");
	utility.printHtml("SidebarManager.html");
	utility.printHtml("Footer.html");
	}
}

