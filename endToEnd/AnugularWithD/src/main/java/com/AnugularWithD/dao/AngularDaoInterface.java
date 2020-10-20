package com.AnugularWithD.dao;

import java.util.List;

import com.AnugularWithD.entity.Employee;

public interface AngularDaoInterface {
	public List<Employee> viewallProfileDAO();

	public void deleteProfileDao(String email);

	public void createProfileDao(Employee e);

	public void editProfileDao(String email,Employee e) throws Exception;
}
