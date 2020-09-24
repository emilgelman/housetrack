package com.emilgelman.housetrack.housetrack.services.abs;

import com.emilgelman.housetrack.housetrack.domain.House;
import com.emilgelman.housetrack.housetrack.domain.HouseRetrievalRequest;

import java.util.List;

public interface DataSourceService {
    List<House> retrieve(HouseRetrievalRequest houseRetrievalRequest);
}
