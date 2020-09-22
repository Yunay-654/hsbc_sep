package com.instagram.utility;
import com.instagram.dao.*;
import com.instagram.dao.InstagramDAO;
import com.instagram.dao.InstagramDAOInterface;
public class DAOFactory {
	public static InstagramDAOInterface createObject(String nn) {
		InstagramDAOInterface is=null;
		if(nn.equals("admin service")) {
			is=new InstagramDAO();
		}
		return is;
	}
}
