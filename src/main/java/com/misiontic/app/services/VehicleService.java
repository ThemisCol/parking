/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.misiontic.app.services;

import com.misiontic.app.models.Vehicle;
import java.util.List;

/**
 *
 * @author cahuc
 */
public interface VehicleService {

    public Vehicle save(Vehicle vehicle);

    public void delete(Integer id);

    public Vehicle findById(Integer id);

    public List<Vehicle> findAll();

}
