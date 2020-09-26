package com.emilgelman.housetrack.housetrack.services.abs;

import com.emilgelman.housetrack.housetrack.domain.House;
import com.emilgelman.housetrack.housetrack.domain.HouseRetrievalRequest;

import java.util.Set;

public interface DataSourceService {
    Set<House> retrieve(HouseRetrievalRequest houseRetrievalRequest);
}
