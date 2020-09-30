package com.instagramweb.service;
import java.util.List;
import java.util.List;
import java.util.Map;
import com.instagramweb.entity.IrctcUser;
import com.instagramweb.entity.Country;
import com.instagramweb.entity.InstagramUser;

public interface InstagramServiceInterface {

	int createprofileService(InstagramUser iu)throws Exception;

	boolean loginprofileService(InstagramUser fu) throws Exception;

	int checkmailService(InstagramUser iu)throws Exception;
	List<IrctcUser> sourceService()throws Exception;
	List<String> countryService()throws Exception;
	List<String> stateService()throws Exception;
	List<String> cityService()throws Exception;

}
