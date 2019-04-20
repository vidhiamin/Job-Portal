public class Candidates implements java.io.Serializable{
	 
	String username;
	String firstname;
	String lastname;
	String education;
	String summary;
	String excompany;
	String experiod;
	String skills;
	String certifications;
	String projects;
	
	public Candidates(String username, String firstname, String lastname,String education,String summary,String excompany,String experiod,String skills,String certifications,String projects)
	{
		
		this.username=username;
		this.firstname = firstname;
		this.lastname = lastname;;
		this.education = education;
	    this.summary = summary;
		this.excompany = excompany;
		this.experiod = experiod;
		this.skills = skills;
		this.certifications = certifications;
		this.projects = projects;
		
		
	}
	
	
	public Candidates() {
		
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}

	public String getfirstname() {
		return firstname;
	}

	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getlastname() {
		return lastname;
	}

	public void setlastname(String lastname) {
		this.lastname = lastname;
	}

	public String geteducation() {
		return education;
	}

	public void seteducation(String education) {
		this.education = education;
	}
	public String getsummary() {
		return summary;
	}

	public void setsummary(String summary) {
		this.summary = summary;
	}
	public String getexcompany() {
		return excompany;
	}

	public void setexcompany(String excompany) {
		this.excompany = excompany;
	}
	
	public String getexperiod() {
		return experiod;
	}

	public void setexperiod(String experiod) {
		this.experiod = experiod;
	}
	public String getskills() {
		return skills;
	}

	public void setskills(String skills) {
		this.skills = skills;
	}
	public String getcertifications() {
		return certifications;
	}

	public void setcertifications(String certifications) {
		this.certifications = certifications;
	}
	public String getprojects() {
		return projects;
	}

	public void setprojects(String projects) {
		this.projects = projects;
	}
	

}
