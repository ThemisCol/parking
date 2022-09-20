/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.misiontic.app.dao;

import com.misiontic.app.models.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author cahuc
 */
public interface TransaccionDao extends JpaRepository<Transaccion, Integer> {

}
