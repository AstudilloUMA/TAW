package es.taw.sampletaw.dao;

import es.taw.sampletaw.entity.CuentaEntity;
import es.taw.sampletaw.entity.TipocomisionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CuentaRepository extends JpaRepository<CuentaEntity, Integer> {

    @Query("select c from CuentaEntity c where c.tipocomisionByComision = :comision and c.saldoactual > :saldo")
    public List<CuentaEntity> filtro(@RequestParam("comision") TipocomisionEntity comision,
                                                  @RequestParam("saldo") Double saldo);
}
