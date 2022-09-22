/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.misiontic.app.services;

import com.misiontic.app.models.ParkingSlot;
import java.util.List;

/**
 *
 * @author cahuc
 */
public interface ParkingSlotService {

    public ParkingSlot save(ParkingSlot parkingSlot);
    
    public ParkingSlot findById(Integer id);

    public List<ParkingSlot> findAll();

}