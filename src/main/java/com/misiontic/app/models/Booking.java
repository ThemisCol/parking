/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.app.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author cahuc
 */
@Entity
@Table(name = "Booking")
@Data
public class Booking implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_booking")
    private Integer id_booking;

    @Column
    private String init_date;

    @Column
    private String end_date;

    @ManyToOne
    @JoinColumn(name = "id_vehicle")
    private Vehicle Vehicle;

    @Column
    private Double payment_value;
    
    @Column
    private Boolean payment_status;
    
    @Column
    private String createdAt;
    
    @Column
    private String updateAt;
    
    @ManyToOne
    @JoinColumn(name = "id_parkingslot")
    private ParkingSlot ParkingSlot;
}
