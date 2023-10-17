package com.unizim.shakik.publickeyservice.repository;

import com.unizim.shakik.publickeyservice.model.KeyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyRepository extends JpaRepository<KeyEntity, String> {
}