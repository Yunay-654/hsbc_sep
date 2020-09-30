package com.facebookweb.dao;
import com.facebookweb.utility.FacebookException;
import java.util.List;
import java.util.Map;
import com.facebookweb.entity.FacebookUser;

public interface FacebookDAOInterface {

	int createProfileDAO(FacebookUser iu)throws FacebookException, Exception;

	int editProfileDAO(FacebookUser iu)throws Exception;

	int deleteProfileDAO(FacebookUser iu)throws FacebookException, Exception;

	List<FacebookUser> searchProfileDAO(FacebookUser iu)throws FacebookException;

	List<FacebookUser> viewallProfileDAO() throws FacebookException;

	FacebookUser viewProfileDAO(FacebookUser iu)throws FacebookException, Exception;
	Map<String, List<FacebookUser>> userdetailwithhistorydao() throws FacebookException;

	boolean loginprofileDAO(FacebookUser iu);

	List<FacebookUser> friendProfileDAO(FacebookUser fu);

}
