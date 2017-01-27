package com.cfemex.lv.is.GEMMAA;

import java.sql.Timestamp;

/**
 * Created by JCDI on 11/11/2016.
 */
public class RegistroBitacora {
    int id;
    String proyecto;
    String tablaAfectada;
    String camposAfectados;
    int nipResponsable;
    String ip;
    String tipoMovimiento;
    String valorAnterior;
    String valorNuevo;
    String fecha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getTablaAfectada() {
        return tablaAfectada;
    }

    public void setTablaAfectada(String tablaAfectada) {
        this.tablaAfectada = tablaAfectada;
    }

    public String getCamposAfectados() {
        return camposAfectados;
    }

    public void setCamposAfectados(String camposAfectados) {
        this.camposAfectados = camposAfectados;
    }

    public int getNipResponsable() {
        return nipResponsable;
    }

    public void setNipResponsable(int nipResponsable) {
        this.nipResponsable = nipResponsable;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getValorAnterior() {
        return valorAnterior;
    }

    public void setValorAnterior(String valorAnterior) {
        this.valorAnterior = valorAnterior;
    }

    public String getValorNuevo() {
        return valorNuevo;
    }

    public void setValorNuevo(String valorNuevo) {
        this.valorNuevo = valorNuevo;
    }
}
