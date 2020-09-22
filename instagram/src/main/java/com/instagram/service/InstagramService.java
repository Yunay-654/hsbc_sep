package com.instagram.service;

import java.util.List;
import java.sql.*;
import java.util.List;
import java.util.Map;
import com.instagram.dao.InstagramDAO;
import com.instagram.dao.InstagramDAOInterface;
import com.instagram.entity.InstagramUser;
import com.instagram.utility.InstagramException;
import com.instagram.utility.ServiceFactory;
import com.instagram.utility.*;

public class InstagramService implements InstagramServiceInterface {
	
	private InstagramDAOInterface id;
	
	public InstagramService() {
		//id=new InstagramDAO();
		id=DAOFactory.createObject("admin service");
	}

	public int createprofileService(InstagramUser iu)throws Exception {
		int i=0;
		 i=id.createProfileDAO(iu);
		
		return i;

	}

	public int editprofileService(InstagramUser iu)throws Exception{
	
		 int i=id.editProfileDAO(iu);
            return i;
	}

	public int deleteprofileService(InstagramUser iu)throws Exception {
		int uu=id.deleteProfileDAO(iu);
		return uu;

	}

	public List<InstagramUser> viewallprofileService() {
		List<InstagramUser> ll=null;
		 ll=id.viewallProfileDAO();
	
          return ll;

	}

	public List<InstagramUser> searchprofileService(InstagramUser iu)throws InstagramException{
		return id.searchProfileDAO(iu);

	}

	public InstagramUser viewprofileService(InstagramUser iu)throws Exception {
		System.out.println(iu.getPassword());
		System.out.println(iu.getName());
		System.out.println(iu.getEmail());
		System.out.println(iu.getAddress());
		InstagramUser uu=id.viewProfileDAO(iu);
		
		return uu;

	}
	@Override
	public Map<String, List<InstagramUser>> userdetailwithhistoryservice() {
		// TODO Auto-generated method stub
		return id.userdetailwithhistorydao();
	}

}









