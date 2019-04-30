package com.edu.fiap.helpdeskservice.repository;

import com.edu.fiap.helpdeskservice.model.entity.HelpDeskEntity;
import org.springframework.data.repository.CrudRepository;

public interface HelpDeskRepository extends CrudRepository<HelpDeskEntity, Integer> {
}
