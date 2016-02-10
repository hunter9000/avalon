package com.test.repository;

import com.test.model.dungeons.CellModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier(value="cellRepository")
public interface CellRepository extends CrudRepository<CellModel, Long> {
    public CellModel findById(long id);
}
