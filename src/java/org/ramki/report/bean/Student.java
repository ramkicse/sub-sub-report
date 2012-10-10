/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ramki.report.bean;

import java.util.List;

/**
 *
 * @author ramki
 */
public class Student {
     private String name;
    private String rollNo;
    private List<Record> listOfRecord;

   

    public Student() {
    }

    public Student(String name, String rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public List<Record> getListOfRecord() {
        return listOfRecord;
    }

    public void setListOfRecord(List<Record> listOfRecord) {
        this.listOfRecord = listOfRecord;
    }

   
    
    
}
