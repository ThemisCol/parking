/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.app.controllers;

import com.misiontic.app.models.VehicleBrand;
import com.misiontic.app.services.VehicleBrandService;
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
@RequestMapping("/vehicle-brand")
public class VehicleBrandController {

    @Autowired
    private VehicleBrandService brandService;

    @GetMapping(value = "/list")
    public List<VehicleBrand> listBrand() {
        return brandService.findAll();
    }

    @GetMapping(value = "/list/{id}")
    public VehicleBrand getBrandId(@PathVariable Integer id) {
        return brandService.findById(id);
    }

}
