import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Home extends HttpServlet
{
	MySqlDataStoreUtilities ms = new MySqlDataStoreUtilities();
	PrintWriter pw= null;
	HashMap<String,Job> jobMap = null;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		pw= response.getWriter();
		String username = request.getParameter("username");
		//String usertype = request.getParameter("usertype");
		HttpSession session=request.getSession();  
		ms.truncateTable();
		init();
		session.setAttribute("JobMap",jobMap);
		Users user = (Users)session.getAttribute("user");
		
		try{
			System.out.println("User name : " + user.getusername());
		}catch(Exception e){
			System.out.println("USer object not found");
		}
		//String usert = user.usertype;
		Utilities utility = new Utilities(request,pw);
		System.out.println("==========User is here" + user);
		if(session.getAttribute("user")!= null)  
		{
			//
			String usertype = (String)session.getAttribute("usertype");
			Users users  = new Users();
			users= (Users)session.getAttribute("user");
			if(user.getusertype().equals("Recruiter"))
			{
			System.out.println("================Inside the recruiter===========");
			utility.printHtml("HeaderAdd.html");
			utility.printHtml("Job.html");
			utility.printHtml("SidebarManager.html");
			utility.printHtml("Footer.html");
			}
			
			else if(user.getusertype().equals("Administrator"))
			{
			System.out.println("================Inside the Admin===========");
			utility.printHtml("HeaderAdmin.html");
			utility.printHtml("Job.html");
			utility.printHtml("SidebarAdmin.html");
			utility.printHtml("Footer.html");
			}
			else
			{
				System.out.println("================Inside the Candidate===========");
			utility.printHtml("HeaderLogout.html");
			utility.printHtml("Job.html");
			utility.printHtml("Sidebar.html");
			utility.printHtml("Footer.html");
			}
		
/* 		else
		{
			System.out.println("=========Not logedin ");
			utility.printHtml("Header.html");
			utility.printHtml("Job.html");
			utility.printHtml("Sidebar.html");
			utility.printHtml("Footer.html");
		} */
		
	//Change
		
	//Change
pw.println("<section id = \"content\">");
pw.println("<h2 align=\"center\" style=\"color:red;\">Welcome to JobBoard</h2>");
pw.println("<article style=\"background-color:lightgrey\">");
pw.println("<h2 style=\"color:red;\">Trending Jobs</h2>");
DealMatches dl = new DealMatches();
HashMap<String, Job> selectjob = dl.getJobData();
ArrayList<String> tweets = dl.getTweets();
Collections.reverse(tweets);
if(tweets.isEmpty())
{
	pw.println("<h2>No Trending jobs are found</h2>");
	
}
else
{
	for( String tw : tweets)
	{
		pw.println("<h3 style=\"color:blue\">"+tw+"</h2>");
	}
}
pw.println("</article>");
pw.println("<h2 align=\"center\">jobs of JobBoard</h2>");
pw.println("<article style=\"background-color:lightgrey\">");
pw.println("<table cellspacing=\"0\" class=\"shopping-cart\">");
pw.println("<thead>");
pw.println("<tr class=\"headings\">");
pw.println("<th class=\"link\">&nbsp;</th>");
pw.println("</tr>");
pw.println("</thead>");
if(selectjob == null || selectjob.size() == 0)
{
	
	pw.println("<h2>No jobs found  in JobBoard!!</h2>");
	
}
else
{
	for(Map.Entry<String,Job> entry : selectjob.entrySet())
		
	{
		Job job = (Job)entry.getValue();
		
				pw.println("<tbody>"); 
				pw.println("<ul>");
				pw.println("<li class=\"desc\">CompanyName : " + job.getCompanyName() +"</li>");
                pw.println("<li>Salary: $" + job.getSalary() + "</li>");
				pw.println("<li>Category: " + job.getCategory() + "</li>");
				pw.println("<li>JobType: " + job.getJobType() + "</li>");
				pw.println("<li>Salary: " + job.getSalary() + "</li>");
				pw.println("<li>JobPosition: " + job.getJobPosition() + "</li>");
				pw.println("<li>State: " + job.getState() + "</li>");
				pw.println("<p><a href=\"ViewJob?id="+job.getId()+"&&category=" +job.getCategory()+"\"class=\"btn btn-primary\" role=\"button\">View Job</a></p>" );		
			
				
			/* 	pw.println("<li>Quantity  " + product.getQuantity() + "</li>");				 
				pw.println("<li><a href=\"Review?name="+product.getName()+"&&price=" +product.getPrice()+"&&image=" +product.getImage()+"\">WriteReview</a></li>" );               
                pw.println("<li><a href=\"ViewReview?name="+product.getName()+"\" class=\"btnreview\">View Review</a></li>");
                pw.println("<li><a href=\"ViewItem?id="+product.getId()+"&&category=" +product.getCategory()+"&&qty=" +product.getQuantity()+"\" class=\"btnreview\">View Item</a></li>");
				 */
				pw.println("</ul>");	
				pw.println("</tbody>");
	}
}
			pw.println("</table>");
			pw.println("</article>");
			pw.println("</section >");
			utility.printHtml("Sidebar.html");
			utility.printHtml("Footer.html");	
}
else
{
utility.printHtml("Header.html");
pw.println("<section id = \"content\">");
pw.println("<h2 align=\"center\" style=\"color:red;\">Welcome to JobBoard</h2>");
pw.println("<article style=\"background-color:lightgrey\">");
pw.println("<h2 style=\"color:red;\">Trending Jobs  Found</h2>");
DealMatches dl = new DealMatches();
HashMap<String, Job> selectjob = dl.getJobData();
ArrayList<String> tweets = dl.getTweets();
Collections.reverse(tweets);
if(tweets.isEmpty())
{
	pw.println("<h2>No Trending Jobs found</h2>");
	
}
else
{
	for( String tw : tweets)
	{
		pw.println("<h3 style=\"color:blue\">"+tw+"</h2>");
	}
}
pw.println("</article>");
pw.println("<h2 align=\"center\">Jobs of JobBoard</h2>");
pw.println("<article style=\"background-color:lightgrey\">");
pw.println("<table cellspacing=\"0\" class=\"shopping-cart\">");
pw.println("<thead>");
pw.println("<tr class=\"headings\">");
pw.println("<th class=\"link\">&nbsp;</th>");
pw.println("</tr>");
pw.println("</thead>");
if(selectjob == null || selectjob.size() == 0)
{
	
	pw.println("<h2>No Trending Jobs founds in JobBoard</h2>");
	
}
else
{
	for(Map.Entry<String,Job> entry : selectjob.entrySet())
		
	{
		Job job = (Job)entry.getValue();
		
				pw.println("<tbody>");

				pw.println("<ul>");
				pw.println("<li class=\"desc\">CompanyName : " + job.getCompanyName() +"</li>");
                //pw.println("<li>Salary: $" + job.getSalary() + "</li>");
				pw.println("<li>Category: " + job.getCategory() + "</li>");
				pw.println("<li>JobType: " + job.getJobType() + "</li>");
				pw.println("<li>Salary: " + job.getSalary() + "</li>");
				pw.println("<li>JobPosition: " + job.getJobPosition() + "</li>");
				pw.println("<li>State: " + job.getState() + "</li>");
				pw.println("<p><a href=\"ViewJob?id="+job.getId()+"&&category=" +job.getCategory()+"\"class=\"btn btn-primary\" role=\"button\">View Job</a></p>" );		
			
				pw.println("</ul>");	
				pw.println("</tbody>");
	}
}


pw.println("</table>");
pw.println("</article>");
pw.println("</section >");
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
		jobMap = hm2;
		for(Map.Entry<String,Job> entry : hm2.entrySet())
		{
			Job job =(Job)entry.getValue();
			ms.insertJob(job.getId(), job.getCategory(),job.getCompanyName(),job.getJobType(),job.getJobPosition(),job.getSalary(),job.getJobDescription(),job.getExperienceLevel(),job.getState());
		}
	}	

}