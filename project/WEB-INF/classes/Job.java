import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class Job implements Serializable {
   
    String companyname;
    String id;
    String category;
    String jobtype;
    int salary;
	String experiencelevel;
	String jobdescription;
	String jobposition;
	String state;
	String jobid;
	
    public Job(){
		
		this.companyname = companyname;
		this.id = id;
		this.category = category;
		this.jobtype = jobtype;
		this.salary = salary;
		this.experiencelevel = experiencelevel;
		this.jobdescription = jobdescription;
		this.jobposition = jobposition;
		this.state = state;
        
		
    }

	
	
void setId(String id) {
	this.id = id;
}
public String getId()
{
	return id;
}
void setJobtId(String id) {
	this.jobid = id;
}
public String getJobId()
{
	return jobid;
}


void setCategory(String category) {
	this.category = category;
}

public String getCategory()
{
	return category;
}

void setCompanyName(String companyname) {
	this.companyname = companyname;
}
public String getCompanyName()
{
	return companyname;
}

void setJobType(String jobtype) {
	this.jobtype = jobtype;
}

public String getJobType()
{
	return jobtype;
}


void setJobPosition(String jobposition) {
	this.jobposition = jobposition;
}

public String getJobPosition()
{
	return jobposition;
}

void setSalary(int salary) {
	this.salary = salary;
}

public int getSalary()
{
	return salary;
}

void setJobDescription(String jobdescription) {
	this.jobdescription = jobdescription;
}

public String getJobDescription()
{
	return jobdescription;
}

void setExperienceLevel(String experiencelevel) {
	this.experiencelevel = experiencelevel;
}

public String getExperienceLevel()
{
	return experiencelevel;
}

void setState(String state) {
	this.state = state;
}
public String getState()
{
	return state;
}




}
