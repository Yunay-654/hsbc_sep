
package com.AnugularWithD.entity;

public class Employee {

	private String name;
     private String password;
     private String email;
     private String address;
     /**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	public void setName(String name) {
    	 this.name=name;
     }
     public String getName() {
    	 return name;
     }
     public void setPassword(String password) {
    	 this.password=password;
     }
     public String getPassword() {
    	 return password;
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}


