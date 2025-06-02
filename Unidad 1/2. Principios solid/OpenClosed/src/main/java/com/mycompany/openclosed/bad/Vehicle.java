/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.openclosed.bad;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author JAIRO
 */
public class Vehicle {
    
    private String matricule;
    private String type;
    public static final double RATE_CAR = 2000;
    public static final double RATE_MOTORCYCLE = 1000;
    public static final double RATE_TRUCK = 4000;

    public Vehicle(String matricule, String type) {
        this.matricule = matricule;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the matricula
     */
    public String getMatricule() {
        return matricule;
    }

    /**
     * @param matricule the matricula to set
     */
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    
    
    public double calculateParkingCost(LocalTime income, LocalTime exit){
        long hours = ChronoUnit.HOURS.between(exit, income);
        double cost;
        if(this.type.equals("CAR")){
            cost = hours * RATE_CAR;
        }
        else if(this.type.equals("MOTORCYCLE")){
            cost = hours * RATE_MOTORCYCLE;
        }
        else{
            cost = hours * RATE_TRUCK;
        }
        return  cost;
    }
    
    
}
