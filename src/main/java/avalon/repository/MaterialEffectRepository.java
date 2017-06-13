package avalon.repository;

import avalon.model.items.MaterialEffectModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier(value="materialEffectRepository")
public interface MaterialEffectRepository extends CrudRepository<MaterialEffectModel, Long> {
    public MaterialEffectModel findById(long id);
//    public List<MaterialEffectModel> findAll();
}