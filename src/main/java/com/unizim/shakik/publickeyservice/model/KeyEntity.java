package com.unizim.shakik.publickeyservice.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "keys")
public class KeyEntity {
	@Id
	private String id;
	@Column(name = "public_key")
	private String public_key;
	@Column(name = "date_time_at_creation")
	private LocalDateTime dateTimeAtCreation;
	public KeyEntity(String id, String public_key) {
		this.id = id;
		this.public_key = public_key;
		dateTimeAtCreation = LocalDateTime.now();
	}
	public KeyEntity() {
	}
	
	public String getId() {
		return id;
	}
	
	public String getPublic_key() {
		return public_key;
	}
	
	@Override
	public String toString() {
		return "KeyEntity{" +
						"id='" + id + '\'' +
						", public_key='" + public_key + '\'' +
						", dateTimeAtCreation=" + dateTimeAtCreation +
						'}';
	}
}
