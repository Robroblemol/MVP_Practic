package com.raziel.tareamvp.domain.domain;

import com.raziel.tareamvp.domain.domain.IIteratorMvp;

import java.util.Date;


/**
 * Created by raziel on 11/03/18.
 */

public class InteratorMvp implements IIteratorMvp {
    @Override
    public String showInf(String name, String lastName, Date date){
        Date today;
        today = new Date();

        return "nombre: "+name+" apellido: "+lastName+" edad: "+(date);

    }
}
