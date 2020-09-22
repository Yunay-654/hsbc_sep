package com.instagram.utility;
import java.util.Comparator; 
import java.lang.Comparable;
import com.instagram.entity.*;
public class SortByAddress implements Comparator<InstagramUser> {

	@Override
	public int compare(InstagramUser o1, InstagramUser o2) {
		// TODO Auto-generated method stub
		return o1.getAddress().compareTo(o2.getAddress());
	}


}
