package com.skilldistillery.jpajobtracker.entities;

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

@Entity
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String position;
	@Column(name = "desc_url")
	private String descriptionURL;
	private String company;
	private String location;
	private String progress;
	@OneToOne
    @JoinColumn(name="note_id")
    private Note note;
	@OneToMany(mappedBy="application")
	private List<Contact> contacts;
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student;
	
	public Application() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDescriptionURL() {
		return descriptionURL;
	}

	public void setDescriptionURL(String descriptionURL) {
		this.descriptionURL = descriptionURL;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Application [id=" + id + ", position=" + position + ", descriptionURL=" + descriptionURL + ", company="
				+ company + ", location=" + location + ", progress=" + progress + ", note=" + note + ", contacts="
				+ contacts.size() + ", student=" + student.getFirstName() + " " + student.getLastName() + "]";
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
		Application other = (Application) obj;
		if (id != other.id)
			return false;
		return true;
	}


}