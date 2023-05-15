/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.dao.UsuariosDao;
import modelo.entidad.Usuarios;


@ManagedBean
@ViewScoped
public class UsuariosControl {

    /**
     * Creates a new instance of usuariosControl
     */
    private List<Usuarios> listaUsuarios;
    private Usuarios usuarios;

    public UsuariosControl() {
        usuarios = new Usuarios();
    }

    public List<Usuarios> getListaUsuarios() {
        UsuariosDao ad = new UsuariosDao();
        listaUsuarios = ad.listarUsuarios();
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuarios> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public void limpiarUsuarios() {
        usuarios = new Usuarios();
    }

    public void agregarUsuarios() {
        UsuariosDao ad = new UsuariosDao();
        ad.agregar(usuarios);
    }

    public void modificarUsuarios() {
        UsuariosDao ad = new UsuariosDao();
        ad.modificar(usuarios);
        limpiarUsuarios();
    }

    public void eliminarUsuarios() {
        UsuariosDao ad = new UsuariosDao();
        ad.eliminar(usuarios);
        limpiarUsuarios();
    }
}
