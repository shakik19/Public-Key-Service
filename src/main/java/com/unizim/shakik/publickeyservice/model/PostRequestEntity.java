package com.unizim.shakik.publickeyservice.model;

public class PostRequestEntity {
	private String id;
	private String public_key;
	
	public String getId() {
		return id;
	}
	
	public String getPublic_key() {
		return public_key;
	}
	
	@Override
	public String toString() {
		return "PostRequestEntity{" +
						"id='" + id + '\'' +
						", public_key='" + public_key + '\'' +
						'}';
	}
}
