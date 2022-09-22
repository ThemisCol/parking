/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.app.services.impl;

import com.misiontic.app.dao.UserDao;
import com.misiontic.app.models.User;
import com.misiontic.app.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cahuc
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = false)
    public User save(User usuario) {
        return userDao.save(usuario);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Integer id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public User findByCredentials(String id, String clave) {
        return userDao.findByIdUsuarioAndClave(id, clave);
    }

}
