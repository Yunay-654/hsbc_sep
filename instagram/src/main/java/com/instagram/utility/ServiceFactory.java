package com.instagram.utility;
import com.instagram.service.*;
public class ServiceFactory {
private ServiceFactory() {
	
}
public static InstagramServiceInterface createObject(String nn) {
	InstagramServiceInterface is=null;
	if(nn.equals("admin service")) {
		is=new InstagramService();
	}
	return is;
}
}
