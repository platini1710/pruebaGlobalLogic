package com.example.usuario.entity;

import java.io.Serializable;

public class PhonesDTO  implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Integer number;
private int citycode;
private int countrycode;

public Integer getNumber() {
	return number;
}
public void setNumber(Integer number) {
	this.number = number;
}
public int getCitycode() {
	return citycode;
}
public void setCitycode(int citycode) {
	this.citycode = citycode;
}
public int getCountrycode() {
	return countrycode;
}
public void setCountrycode(int countrycode) {
	this.countrycode = countrycode;
}


}
