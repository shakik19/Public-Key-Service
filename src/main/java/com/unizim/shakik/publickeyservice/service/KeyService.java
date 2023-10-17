package com.unizim.shakik.publickeyservice.service;

import com.unizim.shakik.publickeyservice.model.KeyEntity;
import com.unizim.shakik.publickeyservice.model.KeyHistoryEntity;
import com.unizim.shakik.publickeyservice.repository.KeyHistoryRepository;
import com.unizim.shakik.publickeyservice.repository.KeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeyService {
	@Autowired
	private KeyRepository keyRepository;
	@Autowired
	private KeyHistoryRepository keyHistoryRepository;
	
//	public Iterable<KeyEntity> get(){ return keyRepository.findAll();}
	public KeyEntity getKey(String id){ return keyRepository.findById(id).orElse(null);}
	public KeyHistoryEntity getKeyHistory(String id){ return keyHistoryRepository.findById(id).orElse(null);}
	public void save(KeyEntity keyEntity){
		keyRepository.save(keyEntity);
		keyHistoryRepository.save(new KeyHistoryEntity(keyEntity.getId(), keyEntity.getPublic_key()));
	}
	public void delete(String id){ keyRepository.deleteById(id); }
}