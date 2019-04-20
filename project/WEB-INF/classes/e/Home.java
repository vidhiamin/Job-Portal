import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Home extends HttpServlet
{
	MySqlDataStoreUtilities ms = new MySqlDataStoreUtilities();
	PrintWriter pw= null;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		pw= response.getWriter();
		String username = request.getParameter("username");
		HttpSession session=request.getSession();  
		ms.truncateTable();
		init();
		Users user = (Users)session.getAttribute("user");
		//String usert = user.usertype;
		Utilities utility = new Utilities(request,pw);
		System.out.println("==========User is here" + user);
		if(session.getAttribute("user")!= null )  
		{
			Users users  = new Users();
			users= (Users)session.getAttribute("user");
			if(user.getusertype().equals("Recruiter"))
			{
			utility.printHtml("HeaderAdd.html");
			utility.printHtml("Job.html");
			utility.printHtml("SidebarManager.html");
			utility.printHtml("Footer.html");
			}
			else
			{
			utility.printHtml("HeaderLogout.html");
			utility.printHtml("Job.html");
			utility.printHtml("Sidebar.html");
			utility.printHtml("Footer.html");
			}

		}
		else
		{
			System.out.println("=========Not logedin ");
			utility.printHtml("Header.html");
			utility.printHtml("Job.html");
			utility.printHtml("Sidebar.html");
			utility.printHtml("Footer.html");
		}
	}	
	public void init()
	{
		System.out.println("================= product ====================");
		String TOMCAT_HOME = System.getProperty("catalina.home");	
		Saxpaser handler = new Saxpaser(TOMCAT_HOME+"\\webapps\\project\\WEB-INF\\classes\\JobCatalog.xml");
		HashMap<String, Job> hm2 = handler.getJobs();
		for(Map.Entry<String,Job> entry : hm2.entrySet())
		{
			Job job =(Job)entry.getValue();
			ms.insertJob(job.getId(), job.getCategory(),job.getCompanyName(),job.getJobType(),job.getJobPosition(),job.getSalary(),job.getJobDescription(),job.getExperienceLevel(),job.getState());
		}
	}	

}