package com.instagramweb.service;

import java.util.List;
import java.sql.*;
import java.util.List;
import java.util.Map;
import com.instagramweb.dao.InstagramDao;
import com.instagramweb.dao.InstagramDaoInterface;
import com.instagramweb.entity.InstagramUser;
import com.instagramweb.utility.ServiceFactory;
import com.instagramweb.utility.*;

public class InstagramService implements InstagramServiceInterface {
	
	private InstagramDaoInterface id;
	
	public InstagramService() {
		//id=new InstagramDAO();
		id=DAOFactory.createObject("admin service");
	}
//for timee being as for implememting as arraylist we changing returntype as List from int.
	public int createprofileService(InstagramUser iu)throws Exception {
		int i=0;
	i=id.createProfileDAO(iu);
		return i;

	}


	public boolean loginprofileService(InstagramUser iu)throws Exception {
		return id.loginprofileDAO(iu);
		

	}

}









