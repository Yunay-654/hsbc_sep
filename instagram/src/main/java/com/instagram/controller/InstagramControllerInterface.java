package com.instagram.controller;
import com.instagram.utility.InstagramException;
public interface InstagramControllerInterface {

	void createProfile() throws Exception;

	void editProfile()throws Exception;

	void deleteProfile()throws Exception;

	void searchProfile()throws InstagramException;

	void viewAllProfile();

	void viewProfile()throws Exception;

	void createcustomtable()throws Exception;
	void userdetailwithhistory();

}
