
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.lang.Object;
import java.net.URLConnection;
import java.net.*;
import java.util.*;

public class Utilities extends HttpServlet{
	
	HttpServletRequest req;
	PrintWriter pw;
	HttpSession session;
	String url;
	Users user;
	
	public Utilities(HttpServletRequest req, PrintWriter pw)
	{
		this.req=req;
		this.pw=pw;
		this.url=this.fetchURL();
	}
	
	public void printHtmlWithData(String htmlFile, Users user, Candidates candidate){
//		String result=HtmlToString(htmlFile, user);
//		StringBuffer sb = new StringBuffer();
//		sb.append("");

		
		String text=null;
		String newPage=url+ htmlFile;
		//pw.print(newPage);
		try
		{
			URL url = new URL(newPage);
			//pw.println(url);
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			InputStreamReader inr= new InputStreamReader(in);
			int readChars;
			char[] arr=new char[1024];
			StringBuffer sb=new StringBuffer();
			while((readChars=inr.read(arr)) > 0)
			{
				sb.append(arr,0,readChars);
			}
			
			text=sb.toString();
			String prevUserNameStr = "id=\"username\" name = \"username\"";
			String newUserNameStr = "id=\"username\" value = \""+user.getusername()+"\" name = \"username\"";
			String prevFirstName = "id=\"firstname\" name = \"firstname\"";
			String newFirstName = "id=\"firstname\" value = \""+candidate.getfirstname()+"\" name = \"firstname\"";
			String prevLastName = "id=\"lastname\" name = \"lastname\"";
			String newLastName = "id=\"lastname\" value = \""+candidate.getlastname()+"\" name = \"lastname\"";
			String prevEducation = "id=\"education\" name = \"education\"";
			String newEducation = "id=\"education\" value = \""+candidate.geteducation()+"\" name = \"education\"";
			String prevSummary = "id=\"summary\" name = \"summary\"";
			String newSummary = "id=\"summary\" value = \""+candidate.getsummary()+"\" name = \"summary\"";
			String prevExcompany = "id=\"excompany\" name = \"excompany\"";
			String newExcompany = "id=\"excompany\" value = \""+candidate.getexcompany()+"\" name = \"excompany\"";
			String prevExperiod = "id=\"experiod\" name = \"experiod\"";
			String newExperiod = "id=\"experiod\" value = \""+candidate.getexperiod()+"\" name = \"experiod\"";
			String prevSkills = "id=\"skills\" name = \"skills\"";
			String newSkills = "id=\"skills\" value = \""+candidate.getskills()+"\" name = \"skills\"";
			String prevCertifications = "id=\"certifications\" name = \"certifications\"";
			String newCertifications = "id=\"certifications\" value = \""+candidate.getcertifications()+"\" name = \"certifications\"";
			String prevProjects = "id=\"projects\" name = \"projects\"";
			String newProjects = "id=\"projects\" value = \""+candidate.getprojects()+"\" name = \"projects\"";
			text = text.replaceAll(prevUserNameStr, newUserNameStr);
			text = text.replaceAll(prevFirstName, newFirstName);
			text = text.replaceAll(prevLastName, newLastName);
			text = text.replaceAll(prevEducation, newEducation);
			text = text.replaceAll(prevSummary, newSummary);
			text = text.replaceAll(prevExcompany, newExcompany);
			text = text.replaceAll(prevExperiod, newExperiod);
			text = text.replaceAll(prevSkills, newSkills);
			text = text.replaceAll(prevCertifications, newCertifications);
			text = text.replaceAll(prevProjects, newProjects);
			
			
			pw.println(text);
			//log(text);
			//System.out.println(text);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//e.printStace();
		}

	}
	
	


	public void printHtml(String htmlFile)
	{	
	//pw.println("hi");
		String result=HtmlToString(htmlFile);
		//pw.println("hi");
		StringBuffer sb = new StringBuffer();
		sb.append("");
		//pw.println(sb);
		
		/*if(htmlile == "Header.Html")
		{
			HttpSession session=req.getSession(); 
			if(session.getAttribute("user") != null)
			{
				Users user= (Users)session.getAttribute("user");
				sb.append("<li class=\"register\"> <a href=\"./Registration\" >register</a></li><li class=\"login\"> <a href=\"LogoutServlet\" >logout</a></li><li class=\"login\">"+user.getfirstname()+"</li>");
			}
			else
			{
				sb.append("<li class=\"register\"> <a href=\"./Registration\" >register</a></li><li class=\"login\"> <a href=\"./Login\" >login</a></li>");
			}
			
		}*/
		
		
	}
	
	public String fetchURL()
	{
		String scheme=req.getScheme();
		//pw.println(scheme);
		String server=req.getServerName();
		//pw.println(server);
		int port=req.getServerPort();
		//pw.println(port);
		String path=req.getContextPath();
		//pw.println(path);
		StringBuffer sb=new StringBuffer();
		sb.append(scheme).append("://").append(server);
		if((port!=80))
		{
			sb.append(":").append(port);
		}
		sb.append(path).append("/Html/");
		return sb.toString();
	}
		
	public String HtmlToString(String htmlFile)
	{
		String text=null;
		String newPage=url+ htmlFile;
		//pw.print(newPage);
		try
		{
			URL url = new URL(newPage);
			//pw.println(url);
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			InputStreamReader inr= new InputStreamReader(in);
			int readChars;
			char[] arr=new char[1024];
			StringBuffer sb=new StringBuffer();
			while((readChars=inr.read(arr)) > 0)
			{
				sb.append(arr,0,readChars);
			}
			
			text=sb.toString();
			pw.println(text);
			//log(text);
			//System.out.println(text);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//e.printStace();
		}
		
		return text;
	}
	
}