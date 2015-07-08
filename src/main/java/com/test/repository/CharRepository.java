package com.test.repository;

import com.test.model.CharModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier(value="charRepository")
public interface CharRepository extends CrudRepository<CharModel, Long> {
    public CharModel findById(long id);
    public List<CharModel> findByUserId(long id);
//    public List<MaterialEffectModel> findAll();
}