/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.misiontic.app.dao;

import com.misiontic.app.models.Detalle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author cahuc
 */
public interface DetalleDao extends JpaRepository<Detalle, Integer> {

        /*
        La estructura de estas consultas es la siguiente:
    
            findBy -- indica que el resultado esperado es UN elemento
            findAllBy -- indica que el resultado esperado es UNA LISTA de elementos
    
    
            Luego vienen los nombres de los campos siguiente la forma camelcase
            es decir iniciando en mayúscula
            
            Si se van a utilizar operadores AND u OR, se pueden agregar para
            buscar por varios parámetros
   
            En este caso la consulta requiere acceder al atributo idTransaccion de la clase Transaccion
            que es el atributo de la llave foranea en la Clase detalle (representada con un @ManyToOne)
    
            findByNombreAtributoForaneo_NombreAtributo
    
     */
    public List<Detalle> findAllByTransaccion_IdTransaccion(Integer idTransaccion);
}
