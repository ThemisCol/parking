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
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author cahuc
 */
@Entity
@Table(name = "User")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id_user;

    @Column
    private String name;

    @Column
    private String last_name;

    @Column
    private String phone;
    
    @Column
    private String address;
    
    @Column
    private String role;
    
    @Column
    private String email;
    
    @Column
    private String password;
    
    @Column
    private String document;
    
    @Column
    private String type_document;

}
