package com.facebookweb.service;

import java.util.List;
import java.sql.*;
import java.util.List;
import java.util.Map;
import com.facebookweb.dao.FacebookDAO;
import com.facebookweb.dao.FacebookDAOInterface;
import com.facebookweb.entity.FacebookUser;
import com.facebookweb.utility.FacebookException;
import com.facebookweb.utility.ServiceFactory;
import com.facebookweb.utility.*;

public class FacebookService implements FacebookServiceInterface {
	
	private FacebookDAOInterface id;
	
	public FacebookService() {
		//id=new InstagramDAO();
		id=DAOFactory.createObject("admin service");
	}
//for timee being as for implememting as arraylist we changing returntype as List from int.
	public int createprofileService(FacebookUser iu)throws FacebookException,Exception {
		int i=0;
	i=id.createProfileDAO(iu);
		return i;
		//return ll;

	}

	public int editprofileService(FacebookUser iu)throws Exception{
	
		 int i=id.editProfileDAO(iu);
            return i;
	}

	public int deleteprofileService(FacebookUser iu)throws FacebookException,Exception{
		int uu=id.deleteProfileDAO(iu);
		/*return uu;*/
          return uu;
	}

	public List<FacebookUser> viewallprofileService() throws FacebookException  {
		List<FacebookUser> ll=null;
		 ll=id.viewallProfileDAO();
	
          return ll;

	}

	public List<FacebookUser> searchprofileService(FacebookUser iu)throws FacebookException{
		List<FacebookUser> ll= id.searchProfileDAO(iu);
          return ll;
	}

	public FacebookUser viewprofileService(FacebookUser iu)throws FacebookException,Exception {
		System.out.println(iu.getPassword());
		System.out.println(iu.getName());
		System.out.println(iu.getEmail());
		System.out.println(iu.getAddress());
		FacebookUser uu=id.viewProfileDAO(iu);
		
		return uu;

	}
	public boolean loginprofileService(FacebookUser iu)throws Exception {
		return id.loginprofileDAO(iu);
		

	}
	@Override
	public Map<String, List<FacebookUser>> userdetailwithhistoryservice() throws FacebookException {
		// TODO Auto-generated method stub
		return id.userdetailwithhistorydao();
	}
	@Override
	public List<FacebookUser> friendProfileService(FacebookUser fu) {
		// TODO Auto-generated method stub
		
		return id.friendProfileDAO(fu);
	}

}









