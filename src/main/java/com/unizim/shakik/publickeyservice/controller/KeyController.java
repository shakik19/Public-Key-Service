package com.unizim.shakik.publickeyservice.controller;

import com.unizim.shakik.publickeyservice.model.KeyEntity;
import com.unizim.shakik.publickeyservice.model.KeyHistoryEntity;
import com.unizim.shakik.publickeyservice.model.PostRequestEntity;
import com.unizim.shakik.publickeyservice.service.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class KeyController {
	@Autowired
	private KeyService keyService;
	
	@GetMapping("/key/{id}")
	public KeyEntity get(@PathVariable String id){
		KeyEntity keyEntity = keyService.getKey(id);
		if(keyEntity == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return keyEntity;
	}
	
	@GetMapping("/key/history/{id}")
	public KeyHistoryEntity getHistory(@PathVariable String id){
		KeyHistoryEntity keyHistoryEntity = keyService.getKeyHistory(id);
		if(keyHistoryEntity == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return keyHistoryEntity;
	}

	@PostMapping (value = "/key", consumes = "application/json")
	public HttpStatus create(@RequestBody PostRequestEntity data){
		if(data.getId().isEmpty() || data.getId() == null || data.getId().equals("0") || data.getPublic_key().isEmpty() || data.getPublic_key() == null){
			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
		}
		
		KeyEntity requested_entity = keyService.getKey(data.getId());
		
		if(requested_entity != null){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID or Key already exists");
		}
		
		keyService.save(new KeyEntity(data.getId(), data.getPublic_key()));
		System.out.println("\uD83D\uDC4D\uD83C\uDFFC Entity " + data + "successfully added to the DB");
		return HttpStatus.ACCEPTED;
	}
	
	@DeleteMapping("key/{id}")
	public HttpStatus delete(@PathVariable String id){
		System.out.println("\uD83D\uDEA9 DELETED ID: " + id + "FROM KEYS_DB");
		KeyEntity entity = keyService.getKey(id);
		if(entity == null){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		keyService.delete(id);
	  return HttpStatus.OK;
	}
}