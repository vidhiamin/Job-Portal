import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;


public class RegistrationParser extends HttpServlet
{
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {      
	PrintWriter out= response.getWriter();
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String firstname = request.getParameter("firstname");
	String lastname = request.getParameter("lastname");
	String usertype=request.getParameter("usertype");
	String gender = request.getParameter("gender");
	MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();
	HashMap<String,Users>hm=new HashMap<String,Users>();
	try
	{
		FileInputStream fileInputStream = new FileInputStream(new File("C:\\tomcat-7.0.34-preconfigured\\apache-tomcat-7.0.34\\webapps\\project\\UserDetails.txt")); 
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		hm= (HashMap)objectInputStream.readObject();
	}
	catch(Exception ex)
	{
		ex.getMessage();
	}
	if(mydata.checkuser(username,password))
	{
		request.setAttribute("Er","Username Already exists");
		request.getRequestDispatcher("/Registration").forward(request, response);
	}
	else
	{	
		Users user = new Users(username,password,firstname,lastname,usertype,gender); 
		hm.put(username, user);
		FileOutputStream fileOutputStream = new FileOutputStream("C:\\tomcat-7.0.34-preconfigured\\apache-tomcat-7.0.34\\webapps\\project\\UserDetails.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream); 
		objectOutputStream.writeObject(hm);
		objectOutputStream.flush();
		objectOutputStream.close();
		fileOutputStream.close();	
		mydata.insert(username,password,firstname,lastname,usertype,gender);
		request.getRequestDispatcher("/Login").forward(request, response);
		//out.close();
	}	
	}
}