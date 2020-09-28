package com.facebookweb.utility;
import com.facebookweb.service.*;
public class ServiceFactory {
private ServiceFactory() {
	
}
public static FacebookServiceInterface createObject(String nn) {
	FacebookServiceInterface is=null;
	if(nn.equals("admin service")) {
		is=new FacebookService();
	}
	return is;
}
}
