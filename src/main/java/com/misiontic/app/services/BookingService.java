/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.misiontic.app.services;

import com.misiontic.app.models.Booking;
import java.util.List;

/**
 *
 * @author cahuc
 */
public interface BookingService {

    public Booking save(Booking booking);

    public void delete(Integer id);

    public Booking findById(Integer id);

    public List<Booking> findAll();

}
