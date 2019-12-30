package com.skilldistillery.jobtracking.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String text;
	
	@OneToOne(mappedBy="note")
    private Student student;
	@OneToOne(mappedBy="note")
    private Cohort cohort;
	@OneToOne(mappedBy="note")
    private Application application;
	@OneToOne(mappedBy="note")
    private Contact contact;
	
	
	public Note() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public Cohort getCohort() {
		return cohort;
	}


	public void setCohort(Cohort cohort) {
		this.cohort = cohort;
	}


	public Application getApplication() {
		return application;
	}


	public void setApplication(Application application) {
		this.application = application;
	}


	public Contact getContact() {
		return contact;
	}


	public void setContact(Contact contact) {
		this.contact = contact;
	}


	@Override
	public String toString() {
		return "Note [id=" + id + ", text=" + text + ", student=" + student.getFirstName() + " " + student.getLastName() + ", cohort=" + cohort.getName() + ", application="
				+ application.getPosition() + ", " + application.getCompany() + ", contact=" + contact.getName() + "]";
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
		Note other = (Note) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
