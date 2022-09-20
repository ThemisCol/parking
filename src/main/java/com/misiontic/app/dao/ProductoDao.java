/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.misiontic.app.dao;

import com.misiontic.app.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author cahuc
 */
public interface ProductoDao extends JpaRepository<Producto, Integer> {

        /*
        La estructura de estas consultas es la siguiente:
    
            findBy -- indica que el resultado esperado es UN elemento
            findAllBy -- indica que el resultado esperado es UNA LISTA de elementos
    
            Luego vienen los nombres de los campos siguiente la forma camelcase
            es decir iniciando en mayúscula
            
            Si se van a utilizar operadores AND u OR, se pueden agregar para
            buscar por varios parámetros
   
            En este caso se sigue la estructura findByNombreCampoUno
            es decir que findByNombreProducto permite hacer una consulta SQL de tipo:
    
            WHERE nombreProducto = ? 
      
     */
    
    public Producto findByNombreProducto(String name);

}
