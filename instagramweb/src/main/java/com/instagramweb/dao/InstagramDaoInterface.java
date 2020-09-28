package com.instagramweb.dao;
import java.util.List;
import java.util.Map;
import com.instagramweb.entity.InstagramUser;

public interface InstagramDaoInterface {

	int createProfileDAO(InstagramUser iu)throws Exception;

	boolean loginprofileDAO(InstagramUser iu)throws Exception;

}
