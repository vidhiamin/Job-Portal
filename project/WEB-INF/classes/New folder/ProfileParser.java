import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;


public class ProfileParser extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {      
	PrintWriter out= response.getWriter();
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
	MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();
	HashMap<String,Candidates> hm=new HashMap<String,Candidates>();
	try
	{
		FileInputStream fileInputStream = new FileInputStream(new File("C:\\tomcat-7.0.34-preconfigured\\apache-tomcat-7.0.34\\webapps\\project\\ProfileDetails.txt")); 
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		hm= (HashMap)objectInputStream.readObject();
	}
	catch(Exception ex)
	{
		ex.getMessage();
	}
	
		Candidates candidate = new Candidates(username,firstname,lastname,education,summary,excompany,experiod,skills,certifications,projects); 
		hm.put(username, candidate);
		FileOutputStream fileOutputStream = new FileOutputStream("C:\\tomcat-7.0.34-preconfigured\\apache-tomcat-7.0.34\\webapps\\project\\ProfileDetails.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream); 
		objectOutputStream.writeObject(hm);
		objectOutputStream.flush();
		objectOutputStream.close();
		fileOutputStream.close();	
		mydata.insert1(username,firstname,lastname,education,summary,excompany,experiod,skills,certifications,projects);
		request.getRequestDispatcher("/MyProfile").forward(request, response);
  }
}