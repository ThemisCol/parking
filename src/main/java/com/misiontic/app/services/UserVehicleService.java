/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.misiontic.app.services;

import com.misiontic.app.models.User_Vehicle;
import java.util.List;

/**
 *
 * @author cahuc
 */
public interface UserVehicleService {

    public User_Vehicle save(User_Vehicle userVehicle);

    public void delete(Integer id);

    public User_Vehicle findById(Integer id);

    public List<User_Vehicle> findAll();

}
