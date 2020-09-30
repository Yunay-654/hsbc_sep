package com.instagramweb.service;

import java.util.List;
import java.sql.*;
import java.util.List;
import java.util.Map;
import com.instagramweb.dao.InstagramDao;
import com.instagramweb.dao.InstagramDaoInterface;
import com.instagramweb.entity.Country;
import com.instagramweb.entity.InstagramUser;
import com.instagramweb.entity.IrctcUser;
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
	@Override
	public int checkmailService(InstagramUser iu) throws Exception {
		// TODO Auto-generated method stub
		return id.checkmailDAO(iu);
		
	}
	@Override
	public List<IrctcUser> sourceService() throws Exception {
		// TODO Auto-generated method stub
		List<IrctcUser> ll=id.sourceDAO();
		return ll;
	}
	@Override
	public List<String> countryService() throws Exception {
		// TODO Auto-generated method stub
		List<String> ll=id.countryDAO();
		return ll;
	}
	public List<String> stateService(State s) throws Exception {
		// TODO Auto-generated method stub
		List<String> ll=id.stateDAO(s);
		return ll;
	}
	public List<String> cityService() throws Exception {
		// TODO Auto-generated method stub
		List<String> ll=id.cityDAO();
		return ll;
	}

}









