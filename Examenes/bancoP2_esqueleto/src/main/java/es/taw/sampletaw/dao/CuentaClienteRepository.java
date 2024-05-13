package es.taw.sampletaw.dao;

import es.taw.sampletaw.entity.CuentaEntity;
import es.taw.sampletaw.entity.CuentaclienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CuentaClienteRepository extends JpaRepository<CuentaclienteEntity, Integer> {

    @Query("select cc from CuentaclienteEntity cc where cc.cuentaByCuentaid = :cuenta")
    public List<CuentaclienteEntity> cuentasClientes (@RequestParam("cuenta") CuentaEntity cuenta);
}
