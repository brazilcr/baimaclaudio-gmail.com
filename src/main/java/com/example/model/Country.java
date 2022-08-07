package com.example.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Country {

	private String country;
	private List<String> languages;

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("***** Country Details *****\n");
		sb.append("ID="+getCountry()+"\n");
		sb.append("Languages="+getLanguages()+"\n");
		sb.append("*****************************");
		
		return sb.toString();
	}
	public List<String> getLanguages() {
		return languages;
	}
	public void setLanguages(List<String>  languages) {
		this.languages = languages;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
