package com.instagramweb.utility;
import com.instagramweb.service.*;
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
