package com.test.repository;

import com.test.model.MapModel;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Qualifier(value="mapRepository")
public interface MapRepository extends CrudRepository<MapModel, Long> {
    public MapModel findById(long id);
}
