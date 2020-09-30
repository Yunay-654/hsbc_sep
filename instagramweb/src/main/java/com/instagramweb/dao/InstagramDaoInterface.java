package com.instagramweb.dao;
import java.util.List;
import java.util.Map;

import com.instagramweb.entity.Country;
import com.instagramweb.entity.InstagramUser;
import com.instagramweb.entity.IrctcUser;

public interface InstagramDaoInterface {

	int createProfileDAO(InstagramUser iu)throws Exception;

	boolean loginprofileDAO(InstagramUser iu)throws Exception;

	int checkmailDAO(InstagramUser iu);

	List<IrctcUser> sourceDAO() throws Exception;

	List<String> countryDAO() throws Exception;

	List<String> stateDAO(Country c)throws Exception;

	List<String> cityDAO(State s)throws Exception;
	

}
