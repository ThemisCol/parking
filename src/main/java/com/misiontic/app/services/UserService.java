/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.misiontic.app.services;

import com.misiontic.app.models.User;
import java.util.List;

/**
 *
 * @author cahuc
 */
public interface UserService {

    public User save(User user);

    public void delete(Integer id);

    public User findById(Integer id);

    public List<User> findAll();

    public User findByCredentials(String idUsuario, String clave);

}
