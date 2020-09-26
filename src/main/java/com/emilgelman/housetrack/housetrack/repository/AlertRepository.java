package com.emilgelman.housetrack.housetrack.repository;

import com.emilgelman.housetrack.housetrack.domain.Alert;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlertRepository extends MongoRepository<Alert,String> {
}
