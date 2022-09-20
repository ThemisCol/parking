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
@Table(name = "User_Vehicle")
@Data
public class User_Vehicle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_vehicle")
    private Integer id_user_vehicle;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User User;
    
    @ManyToOne
    @JoinColumn(name = "id_vehicle")
    private Vehicle Vehicle;
}
