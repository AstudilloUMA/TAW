package es.taw.sampletaw.controller;


import es.taw.sampletaw.dao.ClienteRepository;
import es.taw.sampletaw.dao.CuentaRepository;
import es.taw.sampletaw.dao.MovimientoRepository;
import es.taw.sampletaw.dao.TipooperacionRepository;
import es.taw.sampletaw.entity.ClienteEntity;
import es.taw.sampletaw.entity.CuentaEntity;
import es.taw.sampletaw.entity.MovimientoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    protected ClienteRepository clienteRepository;

    @Autowired
    protected CuentaRepository cuentaRepository;

    @Autowired
    protected TipooperacionRepository tipooperacionRepository;

    @Autowired
    protected MovimientoRepository movimientoRepository;

    @GetMapping("/")
    public String doInicio(Model model)
    {
        List <CuentaEntity> cuentas = this.cuentaRepository.findAll();
        model.addAttribute("cuentas",cuentas);

        return "listado";
    }

    @GetMapping("/activar")
    public String doActivar(@RequestParam("id") Integer id)
    {
        CuentaEntity cuenta = this.cuentaRepository.findById(id).orElse(null);
        if(cuenta!=null) cuenta.setActiva((short) 1);
        this.cuentaRepository.saveAndFlush(cuenta);
        return "redirect:/";
    }

    @GetMapping("/desactivar")
    public String doDesactivar(@RequestParam("id") Integer id)
    {
        CuentaEntity cuenta = this.cuentaRepository.findById(id).orElse(null);
        if(cuenta!=null) cuenta.setActiva((short) 0);
        this.cuentaRepository.saveAndFlush(cuenta);
        return "redirect:/";
    }

    @GetMapping("/transferencia")
    public String doTransferencia(@RequestParam("id") Integer id, Model model)
    {
        CuentaEntity cuenta = this.cuentaRepository.findById(id).orElse(null);
        model.addAttribute("cuenta",cuenta);
        List <CuentaEntity> cuentas = this.cuentaRepository.findAll();
        model.addAttribute("cuentas",cuentas);

        return "formTransferencia";
    }

    @PostMapping("/realizar")
    public String doRealizarTransferencia(@RequestParam("origen") Integer origen, @RequestParam("destino") Integer destino,
                                          @RequestParam("descripcion") String descripcion, @RequestParam("cantidad") Integer cantidad,
                                          Model model)
    {
        CuentaEntity cuentaSrc = this.cuentaRepository.findById(origen).orElse(null);
        CuentaEntity cuentaDst = this.cuentaRepository.findById(destino).orElse(null);

        MovimientoEntity movimiento = new MovimientoEntity();
        movimiento.setCuentaByCuentaorigen(this.cuentaRepository.findById(origen).orElse(null));
        movimiento.setCuentaByCuentadestinatario(this.cuentaRepository.findById(destino).orElse(null));
        movimiento.setFecha(new Timestamp(System.currentTimeMillis()));
        movimiento.setTipooperacionByTipooperacion(this.tipooperacionRepository.operacion("transferencia"));
        movimiento.setDescripcion(descripcion);
        movimiento.setCantidad(Double.valueOf(cantidad));

        movimientoRepository.saveAndFlush(movimiento);

        cuentaSrc.setSaldoactual(cuentaSrc.getSaldoactual()+cantidad);
        cuentaDst.setSaldoactual(cuentaDst.getSaldoactual()-cantidad);

        cuentaRepository.saveAndFlush(cuentaSrc);
        cuentaRepository.saveAndFlush(cuentaDst);

        List<MovimientoEntity> movimientos = this.movimientoRepository.findAll();
        model.addAttribute("movimientos", movimientos);
        return "movimientos";
    }


}
