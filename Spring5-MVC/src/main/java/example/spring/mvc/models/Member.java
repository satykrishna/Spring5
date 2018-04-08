package example.spring.mvc.models;

public class Member {
	
	private String firstName;
	
	private String lastName;
	
	private String membershipId;

	public Member(String firstName, String lastName, String membershipId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.membershipId = membershipId;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(String membershipId) {
		this.membershipId = membershipId;
	}
	
	

}
