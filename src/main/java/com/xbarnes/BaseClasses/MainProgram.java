/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xbarnes.BaseClasses;

/**
 *
 * @author xbarn
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HttpConnection http = new HttpConnection();
        http.getCrossfitData();
    }
    
}
