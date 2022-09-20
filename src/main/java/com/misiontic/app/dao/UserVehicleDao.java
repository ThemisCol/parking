/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.misiontic.app.dao;

import com.misiontic.app.models.User_Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author cahuc
 */
public interface UserVehicleDao extends JpaRepository< User_Vehicle, Integer> {

    /*
        La estructura de estas consultas es la siguiente:
    
            findBy -- indica que el resultado esperado es UN elemento
            findAllBy -- indica que el resultado esperado es UNA LISTA de elementos
    
    
            Luego vinene los nombres de los campos siguiente la forma camelcase
            es decir iniciando en mayúscula
            
            Si se van a utilizar operadores AND u OR, se pueden agregar para
            buscar por varios parámetros
   
            En este caso se sigue la estructura findByNombreCampoUnoAndNombreCampoDos
            es decir que findByIdUsuarioAndClave permite hacer una consulta SQL de tipo:
    
            WHERE idUsuario = ? AND clave = ?
      
     */
        
    public User_Vehicle findByIdUsuarioAndClave(String idUsuario, String clave);

}
