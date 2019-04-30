package com.edu.fiap.watchlistservice.repository;

import com.edu.fiap.watchlistservice.model.entity.WatchListItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface WatchListRepository extends CrudRepository<WatchListItemEntity, Integer> {
}
