import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class ViewJob extends HttpServlet 
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out= response.getWriter();
		String username = request.getParameter("username");
		Saxpaser handler = new Saxpaser("C:\\tomcat-7.0.34-preconfigured\\apache-tomcat-7.0.34\\webapps\\project\\WEB-INF\\classes\\JobCatalog.xml");
		HashMap<String, Job> hm3 = handler.getJobs();		 
		String category = request.getParameter("category");
		String id = request.getParameter("id");
		Utilities utility = new Utilities(request,out);
		HttpSession session=request.getSession(); 
		Users user = (Users)session.getAttribute("user");
		if(session.getAttribute("user")!= null )  
		{
			Users users  = new Users();
			System.out.println("======Inside users========");
			users= (Users)session.getAttribute("user");
			if(user.getusertype().equals("Candidate"))
			{
				utility.printHtml("HeaderLogout.html");
				out.println("<section id=\"content\">");
				for(Map.Entry<String,Job> entry : hm3.entrySet())
				{
					Job job=(Job)entry.getValue();
					if(job.getId().equals(id) && job.getCategory().equals(category) )
					{
						
						out.println("<div class=\"col-sm-12 col-md-6\">");
						out.println("<div class=\"thumbnail\">" );
									
						out.println("<div class=\"caption text-center\">" );
						out.println("<p align=\"left\"><b>Company Name:</b>" + job.getCompanyName() + "</p>" );
						out.println("<p align=\"left\"><b>Category:</b>" + job.getCategory() + "</p>" );
						out.println("<p align=\"left\"><b>Job Type:</b> " + job.getJobType() + "</p>" );
						out.println("<p align=\"left\"><b>Salary:</b> " + job.getSalary() + "</p>" );
						out.println("<p align=\"left\"><b>Job Position:</b> " + job.getJobPosition() + "</p>" );
						out.println("<p align=\"left\"><b>Job Description:</b> " + job.getJobDescription() + "</p>" );
						out.println("<p align=\"left\"><b>State:</b> " + job.getState() + "</p>" );					
						if(Integer.parseInt(job.getId()) % 2 == 0)
						{
						out.println("<button><p><a href=\"AddApply?id="+job.getId()+"&&companyname="+job.getCompanyName()+"&&salary=" +job.getSalary()+"&&category=" +job.getCategory()+ "&&description="+job.getJobDescription()+"&&jobtype="+job.getJobType()+"&&jobposition="+job.getJobPosition()+"&&state="+job.getState()+"\" class=\"btnreview\">Quick Apply</a></p></button>" );
						}
					
						else
						{
							out.println("<button><p><a href=\"Review?id="+job.getId()+"&&companyname="+job.getCompanyName()+"&&salary=" +job.getSalary()+"&&category=" +job.getCategory()+ "&&description="+job.getJobDescription()+"&&jobtype="+job.getJobType()+"&&jobposition="+job.getJobPosition()+"&&state="+job.getState()+"\" class=\"btnreview\">Apply</a></p></button>");
						}
						out.println("</div>" );
						out.println("</div>" );
						out.println("</div>");
	
						/* out.println("  <div class=\"col-sm-12 col-md-6\">" +
									"    <div class=\"thumbnail\">" +
									
									"      <div class=\"caption text-center\">" +
									"        <p align=\"left\"><b>Company Name:</b>" + job.getCompanyName() + "</p>" +
									"        <p align=\"left\"><b>Category:</b>" + job.getCategory() + "</p>" +
									"        <p align=\"left\"><b>Job Type:</b> " + job.getJobType() + "</p>" +
									"        <p align=\"left\"><b>Salary:</b> " + job.getSalary() + "</p>" +
									"        <p align=\"left\"><b>Job Position:</b> " + job.getJobPosition() + "</p>" +
									"        <p align=\"left\"><b>Job Description:</b> " + job.getJobDescription() + "</p>" +
									"        <p align=\"left\"><b>State:</b> " + job.getState() + "</p>" +
									"        <button><p><a href=\"AddApply?id="+job.getId()+"&&companyname="+job.getCompanyName()+"&&salary=" +job.getSalary()+"&&category=" +job.getCategory()+ "&&description="+job.getJobDescription()+"&&jobtype="+job.getJobType()+"&&jobposition="+job.getJobPosition()+"&&state="+job.getState()+"\" class=\"btnreview\">Quick Apply</a></p></button>" +
									"		 <button><p><a href=\"Review?id="+job.getId()+"&&companyname="+job.getCompanyName()+"&&salary=" +job.getSalary()+"&&category=" +job.getCategory()+ "&&description="+job.getJobDescription()+"&&jobtype="+job.getJobType()+"&&jobposition="+job.getJobPosition()+"&&state="+job.getState()+"\" class=\"btnreview\">Apply</a></p></button>"+
									"      </div>" +
									"    </div>" +
									"	</div>"); */
					}			   
				}
					out.println("</section>");
					utility.printHtml("Sidebar.html");
					utility.printHtml("Footer.html");
			}
		}
		else
		{
				utility.printHtml("Header.html");
				out.println("<section id=\"content\">");                  
				out.println("<h2 style=\"color:red\"> Please login First </h2>"); 
				out.println("<h2 style=\"color:blue\"> Click Here for Login : <a href=\"Login\" color=\"red\">Login</a> </h2>");             
				out.println("</section>");
				utility.printHtml("Sidebar.html");
				utility.printHtml("Footer.html");

		}
	}		
}