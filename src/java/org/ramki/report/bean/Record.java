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
public class Record {
    
    public String name;
    private List<Mark> listOfMark;

    public String getName() {
        return name;
    }
     public String getname() {
        return name;
    }

    public void setName1(String name) {
        this.name = name;
    }

    public List<Mark> getListOfMark() {
        return listOfMark;
    }

    public void setListOfMark(List<Mark> listOfMark) {
        this.listOfMark = listOfMark;
    }

    public Record() {
    }

   

   

    
   

    public Record(String name) {
        this.name = name;
    }
    
    
}
