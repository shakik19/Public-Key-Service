package com.unizim.shakik.publickeyservice.repository;

import com.unizim.shakik.publickeyservice.model.KeyHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeyHistoryRepository extends JpaRepository<KeyHistoryEntity, String> {
}
