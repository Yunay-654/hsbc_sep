package com.facebookweb.utility;
import java.util.Comparator; 
import java.lang.Comparable;
import com.facebookweb.entity.*;
public class SortByAddress implements Comparator<FacebookUser> {

	@Override
	public int compare(FacebookUser o1, FacebookUser o2) {
		// TODO Auto-generated method stub
		return o1.getAddress().compareTo(o2.getAddress());
	}


}
