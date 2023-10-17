package com.unizim.shakik.publickeyservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
@Entity
@Table(name = "keys_history")
public class KeyHistoryEntity {
	@Id
	private String id;
	@Column(name = "public_key")
	private String public_key;
	@Column(name = "date_time_at_creation")
	private LocalDateTime dateTimeAtCreation;
	
	public KeyHistoryEntity() {
	}
	
	public KeyHistoryEntity(String id, String public_key) {
		this.id = id;
		this.public_key = public_key;
		dateTimeAtCreation = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		return "KeyHistoryEntity{" +
						"id='" + id + '\'' +
						", public_key='" + public_key + '\'' +
						", dateTimeAtCreation=" + dateTimeAtCreation +
						'}';
	}
}
