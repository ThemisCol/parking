/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.app.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cahuc
 */
public class PasswordHash {

    public static String cifrarPassword(String password) {

        /*
          Se le denomina SALT a un valor que se agrega al password para hacerlo 
          más seguro al cifrarlo, este valor normalmente es secreto y se compone
          de varios caracteres especiales
         */
        return toHexString(getSHA(password, "3?_op!7px@"));
    }

    public static byte[] getSHA(String input, String salt) {

        String cifrado = input + salt;

        /* MessageDigest permite crear una instancia de generación de claves SHA512*/
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordHash.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* digest() es utilizado para cifrar el mensage y retornar array of bytes */
        return md.digest(cifrado.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        /* Convertir el byte array en un número muy grande*/
        BigInteger number = new BigInteger(1, hash);

        /* Convertir el valor numérico a hexadecimal */
        StringBuilder hexString = new StringBuilder(number.toString(16));

        /* Si hay menos de 32 caracteres de longitud, llenar con ceros */
        while (hexString.length() < 32) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

}
