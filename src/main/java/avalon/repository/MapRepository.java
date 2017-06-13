package avalon.repository;

import avalon.model.dungeons.MapModel;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier(value="mapRepository")
public interface MapRepository extends CrudRepository<MapModel, Long> {
    public MapModel findById(long id);
}
