package es.taw.sampletaw.dao;

import es.taw.sampletaw.entity.TipooperacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TipooperacionRepository extends JpaRepository<TipooperacionEntity, Integer> {
        @Query("select t from TipooperacionEntity t where LOWER(t.operacion) = LOWER(:operacion)")
        public TipooperacionEntity operacion (@Param("operacion") String operacion);
}
