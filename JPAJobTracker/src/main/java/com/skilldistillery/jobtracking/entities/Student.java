package com.skilldistillery.jobtracking.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String email;
	@Column(name = "github_username")
	private String githubUsername;
	private boolean vettec;
	@Column(name = "gi_bill")
	private boolean giBill;
	private boolean employed;
	private boolean accepted;
	@Column(name = "deposit_paid")
	private boolean depositPaid;
	@Column(name = "needs_loaner_laptop")
	private boolean needsLoanerLaptop;
	@Column(name = "education_level")
	private String educationLevel;
	@Column(name = "open_to_relocation")
	private boolean openToRelocation;
	private String clearance;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "note_id")
	private Note note;
	@ManyToOne
	@JoinColumn(name = "cohort_id")
	private Cohort cohort;
	@JsonIgnore
	@OneToMany(mappedBy = "student")
	private List<Address> addresses;
	@JsonIgnore
	@OneToMany(mappedBy = "student")
	private List<Application> applications;

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGithubUsername() {
		return githubUsername;
	}

	public void setGithubUsername(String githubUsername) {
		this.githubUsername = githubUsername;
	}

	public boolean getVettec() {
		return vettec;
	}

	public void setVettec(boolean vettec) {
		this.vettec = vettec;
	}

	public boolean getGiBill() {
		return giBill;
	}

	public void setGiBill(boolean giBill) {
		this.giBill = giBill;
	}

	public boolean getEmployed() {
		return employed;
	}

	public void setEmployed(boolean employed) {
		this.employed = employed;
	}

	public boolean getAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public boolean getDepositPaid() {
		return depositPaid;
	}

	public void setDepositPaid(boolean depositPaid) {
		this.depositPaid = depositPaid;
	}

	public boolean getNeedsLoanerLaptop() {
		return needsLoanerLaptop;
	}

	public void setNeedsLoanerLaptop(boolean needsLoanerLaptop) {
		this.needsLoanerLaptop = needsLoanerLaptop;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public boolean getOpenToRelocation() {
		return openToRelocation;
	}

	public void setOpenToRelocation(boolean openToRelocation) {
		this.openToRelocation = openToRelocation;
	}

	public String getClearance() {
		return clearance;
	}

	public void setClearance(String clearance) {
		this.clearance = clearance;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public Cohort getCohort() {
		return cohort;
	}

	public void setCohort(Cohort cohort) {
		this.cohort = cohort;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	@Override
	public String toString() {
		try {
			return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ ", githubUsername=" + githubUsername + ", vettec=" + vettec + ", giBill=" + giBill + ", employed="
					+ employed + ", accepted=" + accepted + ", depositPaid=" + depositPaid + ", needsLoanerLaptop="
					+ needsLoanerLaptop + ", educationLevel=" + educationLevel + ", openToRelocation="
					+ openToRelocation + ", clearance=" + clearance + ", user=" + user + ", note=" + note + ", cohort="
					+ cohort.getName() + ", addresses=" + addresses.size() + ", applications=" + applications.size()
					+ "]";
		} catch (Exception e) {
			return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ "]";
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}

}