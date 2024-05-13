package es.taw.sampletaw.dao;

import es.taw.sampletaw.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Integer> {
}
