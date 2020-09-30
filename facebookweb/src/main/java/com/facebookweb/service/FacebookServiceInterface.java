package com.facebookweb.service;
import com.facebookweb.utility.FacebookException;
import java.util.List;
import java.util.List;
import java.util.Map;
import com.facebookweb.entity.FacebookUser;

public interface FacebookServiceInterface {

	int createprofileService(FacebookUser iu)throws FacebookException, Exception;

	int editprofileService(FacebookUser iu)throws Exception;

	int  deleteprofileService(FacebookUser iu)throws FacebookException, Exception;

	List<FacebookUser> viewallprofileService() throws FacebookException;

	List<FacebookUser> searchprofileService(FacebookUser iu) throws FacebookException;

	FacebookUser viewprofileService(FacebookUser iu) throws FacebookException, Exception;
	Map<String, List<FacebookUser>> userdetailwithhistoryservice() throws FacebookException;

	boolean loginprofileService(FacebookUser fu) throws Exception;

	List<FacebookUser> friendProfileService(FacebookUser fu);

}
