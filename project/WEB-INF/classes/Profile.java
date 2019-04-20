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
		//Candidates candidate = (Candidates)session.getAttribute("candidate");
		System.out.println("==========in User profile=======" +user);

		try{
			System.out.println("User name : " + user.getusername());
		}catch(Exception e){
			System.out.println("USer object not found");
		}

		Utilities utility = new Utilities(request,pw);
		if(session.getAttribute("user")!= null )  
		{
		Users users  = new Users();
			
			Candidates candidate = 	getCandidateDetails(user.getusername());	
			//System.out.println("Candidate Summary is : " + candidate.getsummary());
			System.out.println("Candidate type is : " + user.getusertype());
			System.out.println("======Inside users data========");
			users= (Users)session.getAttribute("user");
			if(user.getusertype().equalsIgnoreCase("Candidate"))
			{
				System.out.println("======Inside candidate========");
				utility.printHtml("HeaderLogout.html");
				System.out.println("============Candidate========" + candidate);
				utility.printHtmlWithData("Profile.html", user, candidate);
				//utility.printHtmlWithData1("Profile.html", candidate);
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

	public Candidates getCandidateDetails(String username){
		MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();
//		HashMap<String,Users>hm=new HashMap<String,Users>();
		HashMap<String, Candidates> hm = mydata.MyProfile(username);
		return (Candidates) hm.get(username);
	}

}