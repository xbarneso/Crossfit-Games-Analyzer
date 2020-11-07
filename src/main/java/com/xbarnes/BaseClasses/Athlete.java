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
public class Athlete {
    
    private int id;
    private String compName; 
    private String firstName;
    private String lastName;
    private boolean status;
    private char gender;
    private String countryOfOrigin; 
    private String countryOfOriginCode;
    private int divisionId;
    private int affiliateID;
    private String affiliateName;
    private int age; 
    private String height;
    private String weight;
    
    public Athlete(int id, String compName, String lastName, boolean status, char gender, String countryOfOrigin, String countryOfOriginCode, int divisionId, int affiliateID, String affiliateName, int age, String height, String weight) {
        this.id = id;
        this.firstName = compName;
        this.lastName = lastName;
        this.status = status;
        this.gender = gender;
        this.countryOfOrigin = countryOfOrigin;
        this.countryOfOriginCode = countryOfOriginCode;
        this.divisionId = divisionId;
        this.affiliateID = affiliateID;
        this.affiliateName = affiliateName;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the compName
     */
    public String getCompName() {
        return compName;
    }

    /**
     * @param compName the compName to set
     */
    public void setCompName(String compName) {
        this.compName = compName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * @return the gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * @return the countryOfOrigin
     */
    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    /**
     * @param countryOfOrigin the countryOfOrigin to set
     */
    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    /**
     * @return the countryOfOriginCode
     */
    public String getCountryOfOriginCode() {
        return countryOfOriginCode;
    }

    /**
     * @param countryOfOriginCode the countryOfOriginCode to set
     */
    public void setCountryOfOriginCode(String countryOfOriginCode) {
        this.countryOfOriginCode = countryOfOriginCode;
    }

    /**
     * @return the divisionId
     */
    public int getDivisionId() {
        return divisionId;
    }

    /**
     * @param divisionId the divisionId to set
     */
    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    /**
     * @return the affiliateID
     */
    public int getAffiliateID() {
        return affiliateID;
    }

    /**
     * @param affiliateID the affiliateID to set
     */
    public void setAffiliateID(int affiliateID) {
        this.affiliateID = affiliateID;
    }

    /**
     * @return the affiliateName
     */
    public String getAffiliateName() {
        return affiliateName;
    }

    /**
     * @param affiliateName the affiliateName to set
     */
    public void setAffiliateName(String affiliateName) {
        this.affiliateName = affiliateName;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the height
     */
    public String getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * @return the weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    
}
