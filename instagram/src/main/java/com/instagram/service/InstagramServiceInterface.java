package com.instagram.service;
import com.instagram.utility.InstagramException;
import java.util.List;
import java.util.List;
import java.util.Map;
import com.instagram.entity.InstagramUser;

public interface InstagramServiceInterface {

	int createprofileService(InstagramUser iu)throws Exception;

	int editprofileService(InstagramUser iu)throws Exception;

	int deleteprofileService(InstagramUser iu)throws Exception;

	List<InstagramUser> viewallprofileService();

	List<InstagramUser> searchprofileService(InstagramUser iu) throws InstagramException;

	InstagramUser viewprofileService(InstagramUser iu) throws Exception;
	Map<String, List<InstagramUser>> userdetailwithhistoryservice();

}
