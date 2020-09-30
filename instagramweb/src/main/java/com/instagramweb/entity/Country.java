package com.instagramweb.entity;

import com.instagramweb.entity.Country;

//import java.io.Serializable;

public class Country {
	private int cid;
	private String cname;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cid;
		result = prime * result + ((cname == null) ? 0 : cname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (cid != other.cid)
			return false;
		if (cname == null) {
			if (other.cname != null)
				return false;
		} else if (!cname.equals(other.cname))
			return false;
		return true;
	}

	/**
	 * @return the cid
	 */
	public int getCid() {
		return cid;
	}

	/**
	 * @param cid the cid to set
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}

	/**
	 * @return the country
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * @param country the country to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	
	
	/**
	 * @return the sid
	 */
	public Country() {
		
	}
	
	
	

}
