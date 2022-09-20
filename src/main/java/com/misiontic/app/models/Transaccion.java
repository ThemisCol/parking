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
@Table(name = "transaccion")
@Data
public class Transaccion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTransaccion")
    private Integer idTransaccion;

    @Column(name = "tipoTransaccion")
    private String tipoTransaccion;

    @Column(name = "fechaTransaccion")
    private String fechaTransaccion;

    @Column(name = "vendedor")
    private String vendedor;

    @Column(name = "comprador")
    private String comprador;

    @Column(name = "total")
    private double total;

}
