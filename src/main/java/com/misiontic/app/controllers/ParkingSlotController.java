/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.app.controllers;

import com.misiontic.app.models.ParkingSlot;
import com.misiontic.app.services.ParkingSlotService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cahuc
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/slot")
public class ParkingSlotController {

    @Autowired
    private ParkingSlotService parkingSlotService;

    @GetMapping(value = "/list")
    public List<ParkingSlot> listBrand() {
        return parkingSlotService.findAll();
    }

    @GetMapping(value = "/list/{id}")
    public ParkingSlot getBrandId(@PathVariable Integer id) {
        return parkingSlotService.findById(id);
    }

}
