package es.taw.sampletaw.controller;

import es.taw.sampletaw.dao.CuentaClienteRepository;
import es.taw.sampletaw.dao.CuentaRepository;
import es.taw.sampletaw.dao.RolClienteRepository;
import es.taw.sampletaw.dao.TipoComisionRepository;
import es.taw.sampletaw.entity.CuentaEntity;
import es.taw.sampletaw.entity.CuentaclienteEntity;
import es.taw.sampletaw.entity.RolclienteEntity;
import es.taw.sampletaw.entity.TipocomisionEntity;
import es.taw.sampletaw.ui.Filtro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    protected CuentaRepository cuentaRepository;

    @Autowired
    protected CuentaClienteRepository cuentaClienteRepository;

    @Autowired
    protected RolClienteRepository rolClienteRepository;

    @Autowired
    protected TipoComisionRepository tipoComisionRepository;

    @GetMapping("/")
    public String doListar(Model model) {
        List<CuentaEntity> cuentas = this.cuentaRepository.findAll();
        model.addAttribute("cuentas", cuentas);

        List<TipocomisionEntity> tipos = this.tipoComisionRepository.findAll();
        model.addAttribute("tipos", tipos);

        model.addAttribute("filtro",new Filtro());

        return "listado";
    }

    @GetMapping("/mostrar")
    public String doMostrar(@RequestParam("id") Integer id, Model model) {
        CuentaEntity cuenta = this.cuentaRepository.findById(id).orElse(null);
        model.addAttribute("cuenta", cuenta);

        List<CuentaclienteEntity> cuentasClientes = this.cuentaClienteRepository.cuentasClientes(cuenta);
        model.addAttribute("cuentasClientes", cuentasClientes);

        return "mostrarCuenta";
    }

    @GetMapping("/rol")
    public String doChange(@RequestParam("id") Integer id) {
        CuentaclienteEntity cc = this.cuentaClienteRepository.findById(id).orElse(null);
        Integer rol = cc.getRolclienteByRolid().getRolid();
        RolclienteEntity newRol = this.rolClienteRepository.findById(3 - rol).orElse(null);
        cc.setRolclienteByRolid(newRol);
        this.cuentaClienteRepository.saveAndFlush(cc);
        CuentaEntity c = cc.getCuentaByCuentaid();
        return "redirect:/mostrar?id=" + c.getCuentaid();
    }

    @GetMapping("/eliminar")
    public String doEliminar(@RequestParam("id") Integer id) {
        CuentaclienteEntity cc = this.cuentaClienteRepository.findById(id).orElse(null);
        CuentaEntity c = cc.getCuentaByCuentaid();
        this.cuentaClienteRepository.delete(cc);
        this.cuentaClienteRepository.flush();
        return "redirect:/mostrar?id=" + c.getCuentaid();
    }

    @PostMapping("/filtrar")
    public String doFiltrar(@ModelAttribute("filtro") Filtro filtro, Model model)
    {
        List<CuentaEntity> cuentas;

        if (filtro.getSaldoMin()==null) {
            cuentas = this.cuentaRepository.filtro(filtro.getTipoComision(), Double.MIN_VALUE);
        }
        else {
            cuentas = this.cuentaRepository.filtro(filtro.getTipoComision(), filtro.getSaldoMin());
        }

        model.addAttribute("cuentas", cuentas);

        List<TipocomisionEntity> tipos = this.tipoComisionRepository.findAll();
        model.addAttribute("tipos", tipos);

        return "listado";
    }

}
