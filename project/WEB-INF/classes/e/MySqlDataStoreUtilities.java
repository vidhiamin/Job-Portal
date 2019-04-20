import java.sql.*;
import java.io.*; 
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class MySqlDataStoreUtilities
{
	Connection con = null;
	PreparedStatement ps= null;
	public MySqlDataStoreUtilities() {}
	public boolean getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();  
			con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/jobboard?autoReconnect=true&useSSL=false","root","root"); 
			if(con!=null)
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		} 
	}
public void  insert(String username, String password, String firstname, String lastname, String usertype,String gender)
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/jobboard?autoReconnect=true&useSSL=false","root","root"); 
		ps = con.prepareStatement("insert into registration(username,password,firstname,lastname,usertype,gender)  values(?,?,?,?,?,?)"); 
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, firstname);
		ps.setString(4, lastname);
		ps.setString(5, usertype);
		ps.setString(6, gender);
		ps.executeUpdate();
		con.close();

	} 
	catch (Exception e)
	{
		e.printStackTrace();
	} 
	finally
	{
		try
		{ 
			if (con != null) 
			con.close(); 
		} 
		catch (SQLException e) 
		{ 
			e.printStackTrace(); 
		}
	}
}

 
public boolean checkuser(String username, String password)
{
	boolean st =false;
	try 
	{
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/jobboard?autoReconnect=true&useSSL=false","root","root"); 
		ps = con.prepareStatement("select * from registration where username =? and password=? "); 
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs= ps.executeQuery();
		st = rs.next();
	} 
	catch (Exception e)
	{
		e.printStackTrace();
	} 
	finally
	{
		try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
	}
	return st;
}

public  void truncateTable() {
   //PreparedStatement ps = null;
   // String queryString = "INSERT INTO Utente(Nome, "
 // boolean st =false;
  
  HashMap<String, Job> hm = new HashMap<String, Job>();
    try {
		Class.forName("com.mysql.jdbc.Driver");  
 con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/jobboard?autoReconnect=true&useSSL=false","root","root"); 


      
        ps = con.prepareStatement("truncate table Job");
  
       
       
         ps.execute();
       //return rs;

    } catch (Exception e) {
        e.printStackTrace();
		//return null;
    } finally {
        try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
//return st;
}

public void  insertJob(String id, String category, String companyname, String jobtype, String jobposition,int salary, String jobdescription, String experiencelevel,String state)
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/jobboard?useSSL=false","root","root"); 
		ps = con.prepareStatement("insert into job(id,category,companyname,jobtype,jobposition,salary,jobdescription ,experiencelevel,state)  values(?,?,?,?,?,?,?,?,?)"); 
		ps.setString(1, id);
		ps.setString(2, category);
		ps.setString(3, companyname);
		ps.setString(4, jobtype);
		ps.setString(5, jobposition);
		ps.setInt(6, salary);
		ps.setString(7, jobdescription);
		ps.setString(8, experiencelevel);
		ps.setString(9, state);
		ps.executeUpdate();
		con.close();

	} 
	catch (Exception e)
	{
		e.printStackTrace();
	} 
	finally
	{
		try
		{ 
			if (con != null) 
			con.close(); 
		} 
		catch (SQLException e) 
		{ 
			e.printStackTrace(); 
		}
	}
}

public  HashMap<String, Job> checkjob(String makers) {
  HashMap<String, Job> hm = new HashMap<String, Job>();
    try {
		Class.forName("com.mysql.jdbc.Driver");  
 con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/jobboard?autoReconnect=true&useSSL=false","root","root");  
        ps = con.prepareStatement("select * from job where category = ? "); 
        ps.setString(1, makers);
		//ps.setString(2, password);
       
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
					Job item = new Job();
					item.setCompanyName(rs.getString("companyname"));
					item.setSalary(rs.getInt("salary"));
					item.setId(rs.getString("id"));
					item.setExperienceLevel(rs.getString("experiencelevel"));
					item.setCategory(rs.getString("category"));
					item.setJobType(rs.getString("jobtype"));
					item.setJobDescription(rs.getString("jobdescription"));
					item.setJobPosition(rs.getString("jobposition"));
					item.setState(rs.getString("state"));
					hm.put(item.getCompanyName(),item);
				}
			return hm;	

    } catch (Exception e) {
        e.printStackTrace();
		return null;
    } finally {
        try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
}

public void insertJob1(String id, String category, String companyname, String jobtype, String jobposition,int salary, String jobdescription,String state,String experiencelevel) {
    try {
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/jobboard?useSSL=false","root","root"); 
		ps = con.prepareStatement("insert into job(id,category,companyname,jobtype,jobposition,salary,jobdescription,state,experiencelevel)  values(?,?,?,?,?,?,?,?,?)"); 
		ps.setString(1, id);
		ps.setString(2, category);
		ps.setString(3, companyname);
		ps.setString(4, jobtype);
		ps.setString(5, jobposition);
		ps.setInt(6, salary);
		ps.setString(7, jobdescription);
		ps.setString(8, state);
		ps.setString(9,experiencelevel);
		ps.executeUpdate();
		con.close();

    } catch (Exception e) {
		
        e.printStackTrace();
    } finally {
        try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
    }

}

public void insertJobOrder(String  OrderId, String Username, String salary,String jobid,java.sql.Date sqlDate,String jobtype,String jobposition ,String state , ArrayList<Cart> list) 
{
  int Order= 0;
    try {
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/jobboard?useSSL=false","root","root"); 
        ps = con.prepareStatement("INSERT INTO joborders(OrderId,username,salary,jobid,AddressDate,jobtype,jobposition,state) VALUES(?,?,?,?,?,?,?,?);",Statement.RETURN_GENERATED_KEYS); 
        ps.setString(1, OrderId);
		ps.setString(2, Username);
        ps.setInt(3, Integer.parseInt(salary));
		ps.setString(4,jobid);
		ps.setString(5,(sqlDate).toString() );
		ps.setString(6,jobtype);
		ps.setString(7,jobposition);
		ps.setString(8,state);
		
        ps.execute();
		ResultSet rs = ps.getGeneratedKeys();
		if(rs.next())
		{
			Order = rs.getInt(1);
		}
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
	//insertcart(list,Order,Zip);

}

public  HashMap<String, OrderP> orderView(String username) {
  HashMap<String, OrderP> hm = new HashMap<String, OrderP>();
    try {
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/jobboard","root","root"); 
        ps = con.prepareStatement("select * from joborders where username = ? "); 
        ps.setString(1, username);
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
					OrderP item = new OrderP();
					item.setUsername(rs.getString("username"));
					item.setsalary(rs.getInt("salary"));
					item.setOrderId(rs.getString("OrderId"));
					//item.setCompanyName(rs.getString("companyname"));
					hm.put(item.getUsername(),item);
				}
			return hm;	
    } catch (Exception e) {
        e.printStackTrace();
		return null;
    } finally {
        try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
}

public void  CancelOrder(String OrderId) {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/jobboard","root","root"); 
			System.out.println(OrderId);
			ps = con.prepareStatement("DELETE FROM jobboard.joborders WHERE jobboard.joborders.OrderId = ?"); 
			ps.setString(1, OrderId);
			ps.executeUpdate();	

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	
	}
	
public LinkedHashMap<String, List<String>>  SoldProduct()
{
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/jobboard","root","root"); 
			LinkedHashMap<String,List<String>> hm = new LinkedHashMap();	  
			ps = con.prepareStatement("SELECT *,count(*) FROM jobboard.joborders,jobboard.job WHERE jobboard.joborders.jobid = jobboard.job.id group by jobboard.joborders.jobid order by Count(jobboard.joborders.jobid) desc  limit 5 ;  "); 
			ResultSet rs= ps.executeQuery();
			while(rs.next()){
						List<String> topp = new ArrayList<String>();
						System.out.println(rs.getString("id")+rs.getString("companyname")+rs.getString("category")+rs.getString("count(*)"));
						//item.setDiscount(rs.getString("discount"));
						topp.add(rs.getString("companyname"));
						topp.add(rs.getString("count(*)"));
						hm.put(rs.getString("id"),topp);
					}
				return hm;	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}

public LinkedHashMap<String, String>  ZipCode()
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/jobboard","root","root"); 
		LinkedHashMap<String, String> hm = new LinkedHashMap();
		ps = con.prepareStatement("SELECT *,count(*) FROM jobboard.joborders group by jobboard.joborders.state order by Count(jobboard.joborders.jobid) desc  limit 5 ;  "); 
		ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getString("state") + rs.getString("count(*)"));
			hm.put(rs.getString("state"),rs.getString("count(*)"));;
		}
		return hm;	
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
		return null;
	} 
	finally 
	{
		try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
	}
}

public void insertcart(Cart cart)
{
	try
	{
		getConnection();
		ps = con.prepareStatement("insert into cart(companyname,salary,category,jobposition, jobtype, state, username , jobid)  values(?,?,?,?,?,?,?,?)"); 
		ps.setString(1, cart.getCompanyName());
		ps.setString(2, cart.getSalary());
		ps.setString(3, cart.getCategory());
		ps.setString(4, cart.getJobPosition());
		ps.setString(5, cart.getJobType());
		ps.setString(6, cart.getState());
		ps.setString(7, cart.getUsername());
		ps.setString(8, cart.getJobId());
		ps.execute();
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
}

public int  deletejob(String pid,String category)
{
    try 
	{
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/jobboard","root","root"); 
		HashMap<String, Job> hm = new HashMap<String, Job>();
        ps = con.prepareStatement("delete from job where id= ? and category= ?; "); 
		ps.setString(1, pid);
		ps.setString(2,category);
        int  rs= ps.executeUpdate();
		return rs;	
    }
	catch (Exception e)
	{
        e.printStackTrace();
		return 0;
    }
	finally 
	{
        try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
}

public HashMap<String, Job>  selectjob(String pid,String category)
{
	ResultSet rs = null;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/jobboard","root","root"); 
		HashMap<String, Job> hm = new HashMap<String, Job>();
		ps = con.prepareStatement("SELECT * FROM jobboard.job where id= ? and category = ? ; "); 
		ps.setString(1, pid);
		ps.setString(2,category);
		rs= ps.executeQuery();
		while(rs.next())
		{
			Job item = new Job();
			item.setCompanyName(rs.getString("companyname"));
			item.setCategory(rs.getString("category"));
			item.setSalary(rs.getInt("salary"));
			item.setJobPosition(rs.getString("jobposition"));
			//item.setSalary(rs.getString("salary"));
			item.setId(rs.getString("id"));
			item.setJobDescription(rs.getString("jobdescription"));
			item.setExperienceLevel(rs.getString("experiencelevel"));
			item.setState(rs.getString("state"));
			item.setJobType(rs.getString("jobtype"));
			hm.put(item.getCompanyName(),item);
		}
		return hm;	
	}
	catch (Exception e)
	{
		e.printStackTrace();
		return null;
	} 
	finally 
	{
		try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
	}
}






}

