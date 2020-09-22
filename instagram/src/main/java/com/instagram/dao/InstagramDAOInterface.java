package com.instagram.dao;
import com.instagram.utility.InstagramException;
import java.util.List;
import java.util.Map;
import com.instagram.entity.InstagramUser;

public interface InstagramDAOInterface {

	int createProfileDAO(InstagramUser iu)throws Exception;

	int editProfileDAO(InstagramUser iu)throws Exception;

	int deleteProfileDAO(InstagramUser iu)throws Exception;

	List<InstagramUser> searchProfileDAO(InstagramUser iu)throws InstagramException;

	List<InstagramUser> viewallProfileDAO();

	InstagramUser viewProfileDAO(InstagramUser iu)throws Exception;
	Map<String, List<InstagramUser>> userdetailwithhistorydao();

}
