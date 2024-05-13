package es.taw.sampletaw.dao;

import es.taw.sampletaw.entity.RolclienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolClienteRepository extends JpaRepository<RolclienteEntity, Integer> {
}
