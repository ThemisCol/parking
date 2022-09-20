/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.misiontic.app.services;

import com.misiontic.app.models.Usuario;
import java.util.List;

/**
 *
 * @author cahuc
 */
public interface UsuarioService {

    public Usuario save(Usuario usuario);

    public void delete(Integer id);

    public Usuario findById(Integer id);

    public List<Usuario> findAll();

    public Usuario findByCredentials(String idUsuario, String clave);

}
