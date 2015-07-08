package com.test.repository;

import com.test.model.RecipeModel;
import com.test.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier(value = "recipeRepository")
public interface RecipeRepository extends CrudRepository<RecipeModel, Long> {
//    public RecipeModel findByUserId(long id);

}

