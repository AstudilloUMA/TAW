package es.taw.sampletaw.dao;

import es.taw.sampletaw.entity.TipocomisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoComisionRepository extends JpaRepository<TipocomisionEntity, Integer> {
}
