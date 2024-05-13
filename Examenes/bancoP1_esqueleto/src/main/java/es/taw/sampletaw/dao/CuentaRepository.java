package es.taw.sampletaw.dao;

import es.taw.sampletaw.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<CuentaEntity, Integer> {
}
