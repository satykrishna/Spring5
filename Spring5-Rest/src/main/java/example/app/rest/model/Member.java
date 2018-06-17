package example.app.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Member {

	private String name;
	
	private String email;
	
	private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Member(String name, String email, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
