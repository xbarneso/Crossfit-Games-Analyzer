/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xbarnes.StructureInterfaces;

import com.xbarnes.BaseClasses.Athlete;

/**
 *
 * @author xbarn
 */
public interface AbsFactoryAthlete {
    
    public Athlete createAthlete(int id, String compName, String lastName, boolean status, char gender, String countryOfOrigin, String countryOfOriginCode, int divisionId, int affiliateID, String affiliateName, int age, String height, String weight);
    
}
