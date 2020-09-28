package com.facebookweb.utility;
import com.facebookweb.dao.FacebookDAO;
import com.facebookweb.dao.FacebookDAOInterface;
public class DAOFactory {
	public static FacebookDAOInterface createObject(String nn) {
		FacebookDAOInterface id=null;
		if(nn.equals("admin service")) {
			id=new FacebookDAO();
		}
		return id;
	}
}
