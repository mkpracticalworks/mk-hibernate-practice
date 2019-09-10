package dn.hibernate4.gradle.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Muthukumar Thangavinayagam
 *
 */

@Entity
@Table(name = "person")
public class DnPersonDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private long id;

	@Column(name = "name", nullable = true)
	private String name;

	@Column(name = "age")
	private int age;

	@Column(name = "email")
	private String email;

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "person_address")
	private String address;

	public DnPersonDetail(String name, int age, String email, String contactNumber, String address) {
		this.name = name;
		this.age = age;
		this.email = email;
		this.contactNumber = contactNumber;
		this.address = address;
	}
	
	public DnPersonDetail() {
	
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
