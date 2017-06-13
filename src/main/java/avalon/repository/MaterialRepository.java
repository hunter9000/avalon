package avalon.repository;

import avalon.model.items.MaterialModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier(value="materialRepository")
public interface MaterialRepository extends CrudRepository<MaterialModel, Long> {
    public MaterialModel findById(long id);
    public List<MaterialModel> findAll();
}

