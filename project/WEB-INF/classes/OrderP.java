import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class OrderP implements Serializable
{
    String OrderId;
    String username;
    int salary;
    String CompanyName;
    String JobPosition;
	String date;
	String count;
	String jobtype;
	String experiencelevel;
	
	 public OrderP()
	{
	}
	
	

    void setsalary(int salary) {
        this.salary = salary;
    }

    public int getsalary() {
        return salary;
    }

    void setOrderId(String OrderId) {
	this.OrderId = OrderId;
	}

	public String getOrderId()
	{
		return OrderId;
	}
    void setJobPosition(String JobPosition) {
        this.JobPosition =JobPosition;
    }

    public String getJobPosition() {
        return JobPosition;
    }

    void setUsername(String username) {
	this.username = username;
	}
	public String getUsername()
	{
		return username;
	}
    void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getCompanyName() {
        return CompanyName;
    }
	void setDate(String date) {
	this.date = date;
	}

	public String getDate()
	{
		return date;
	}
	
	void setCount(String count) {
	this.count = count;
	System.out.println("===========count=========" + this.count);
	}

	public String getCount()
	{
		return count;
	}
	
	
	void setJobType(String jobtype) {
	this.jobtype = jobtype;
	}

	public String getJobType()
	{
		return jobtype;
	}
	
	
	
	void setExperienceLevel(String experiencelevel) {
	this.experiencelevel = experiencelevel;
	}

	public String getExperienceLevel()
	{
		return experiencelevel;
	}
	
	
	
	
}

