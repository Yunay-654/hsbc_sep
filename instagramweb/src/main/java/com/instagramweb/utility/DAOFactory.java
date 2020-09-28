package com.instagramweb.utility;
import com.instagramweb.dao.InstagramDao;
import com.instagramweb.dao.InstagramDaoInterface;
public class DAOFactory {
	public static InstagramDaoInterface createObject(String nn) {
		InstagramDaoInterface id=null;
		if(nn.equals("admin service")) {
			id=new InstagramDao();
		}
		return id;
	}
}
