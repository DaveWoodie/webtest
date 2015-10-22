package hello;

public class Employee {

	private int id;
	private String firstName;
	private String surName;
	
	public Employee() {
		
	}
	
	public Employee(int id, String name1, String name2) {
	
		this.id = id;
		this.firstName = name1;
		this.surName = name2;
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
	
	public void setFirstName(String f) {
        firstName = f;
    }
	
	public String getSurName() {
        return surName;
    }
	
	public void setSurName(String f) {
        surName = f;
    }
	
	@Override
	public String toString() {
		return "[id= " + id + ", name= " + firstName + ", " + surName + "]";
	}

	
}
