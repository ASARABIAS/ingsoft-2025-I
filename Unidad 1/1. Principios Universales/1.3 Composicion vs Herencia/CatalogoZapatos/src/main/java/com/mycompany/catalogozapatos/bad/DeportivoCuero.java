/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.catalogozapatos.bad;

/**
 *
 * @author JAIRO
 */
public class DeportivoCuero  extends Deportivo{
    @Override
    public String getDescripcion() {
        return super.getDescripcion() + "\n" + " A base de cuero";
    }
}
