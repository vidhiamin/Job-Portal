import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class LoginParser extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter pw= response.getWriter();
		MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
			HttpSession session=request.getSession();  
			session.setAttribute("uname",username);  		
			HashMap<String,Users>hm=new HashMap<String,Users>();
		try
		{
			FileInputStream fileInputStream = new FileInputStream(new File("C:\\tomcat-7.0.34-preconfigured\\apache-tomcat-7.0.34\\webapps\\project\\UserDetails.txt")); 
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			//out.println(username);
			hm= (HashMap)objectInputStream.readObject();
			//out.println("hm ");
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}

		if(mydata.checkuser(username,password,usertype))
		{
			Users user=(Users)hm.get(username);
			session.setAttribute("user",user);
			System.out.println("==============Nih is here"+user+"====================");
			request.getRequestDispatcher("/Home").forward(request, response);

		}
		else
		{

			Utilities utility = new Utilities(request,pw);
			utility.printHtml("Header.html");
			//pw.println("Invalid username and password");
			// pw.println("<section id=\"content\">");
			pw.println("<section id=\"content\">");                  
			pw.println("<h2 style=\"color:red\"> Login Failed. Please try again. </h2>"); 
			pw.println("<h2 style=\"color:blue\"> Click Here for Login : <a href=\"Login\" color=\"red\">Login</a> </h2>");             
			pw.println("</section>");
			//<h2 align="center" margin-top="60px">Login Form</h2>
			//pw.println("</div>");
			utility.printHtml("Sidebar.html");	
			utility.printHtml("Footer.html");
		}	
	}
}