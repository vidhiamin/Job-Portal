import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class AjaxAutoCompleteServlet extends HttpServlet
{
	AjaxUtilities au = new AjaxUtilities();
	String searchKeyword;
	String action;
	HashMap<String, Job> jobs ;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		StringBuffer sb = new StringBuffer();
		boolean prod  = false;
		PrintWriter out= response.getWriter();
		Utilities utility = new Utilities(request,out);
		jobs = au.getJob();
		action = request.getParameter("action");
		searchKeyword = request.getParameter("id");	  
		if(searchKeyword!= "" || !searchKeyword.equals(""))
		{
			if(action.equals("complete"))
			{
				searchKeyword = searchKeyword.trim().toLowerCase();  
				for(Map.Entry<String,Job> entry : jobs.entrySet())
				{
					Job job=(Job)entry.getValue();
					if(job.getCompanyName().toLowerCase().startsWith(searchKeyword))
					{
						sb.append("<product>");
						sb.append("<id>" + job.getId() + "</id>");
						sb.append("<name>" + job.getCompanyName() + "</name>");
						sb.append("</product>");
						prod = true;
					}
				}	
				if(prod)
				{
					response.setContentType("text/xml");
					response.setHeader("Cache-Control","no-cache");
					out.write("<products>" + sb.toString() +"</products>");
				}
				else
				{
					response.setStatus(HttpServletResponse.SC_NO_CONTENT);
				}
			}
			if(action.equals("lookup"))
			{
				request.setAttribute("Job_obj",jobs.get(searchKeyword));
				request.getRequestDispatcher("/Searchproductview").forward(request, response);
			}
		}
	}
}