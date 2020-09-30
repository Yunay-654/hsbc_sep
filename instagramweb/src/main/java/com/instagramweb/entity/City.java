package com.instagramweb.entity;

public class City {
private int cid;
private int city;
private int sid;
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + cid;
	result = prime * result + city;
	result = prime * result + sid;
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
	City other = (City) obj;
	if (cid != other.cid)
		return false;
	if (city != other.city)
		return false;
	if (sid != other.sid)
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
 * @return the city
 */
public int getCity() {
	return city;
}
/**
 * @param city the city to set
 */
public void setCity(int city) {
	this.city = city;
}
/**
 * @return the sid
 */
public int getSid() {
	return sid;
}
/**
 * @param sid the sid to set
 */
public void setSid(int sid) {
	this.sid = sid;
}
}
