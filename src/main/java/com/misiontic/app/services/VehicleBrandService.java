/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.misiontic.app.services;

import com.misiontic.app.models.VehicleBrand;
import java.util.List;

/**
 *
 * @author cahuc
 */
public interface VehicleBrandService {

    public VehicleBrand save(VehicleBrand vehicleBrand);

    public void delete(Integer id);

    public VehicleBrand findById(Integer id);

    public List<VehicleBrand> findAll();

}
