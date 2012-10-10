/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ramki.report.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


/**
 *
 * @author ramki
 */
@ManagedBean
@SessionScoped
public class DemoBean {
    
    private List<Student> listOfStudents;
    
    public DemoBean() {
        Student student = new Student("ramki", ")2CS14");
        
        Mark m1 = new Mark(50, 40, 90);
        Mark m2 = new Mark(50, 60, 90);
        Mark m3 = new Mark(50, 50, 90);
        
        List<Mark> listmark = new ArrayList<Mark>();
        listmark.add(m1);
        listmark.add(m2);
        listmark.add(m3);
        
        Record record1 = new Record("r1");
        record1.setListOfMark(listmark);
        
         Mark r2m1 = new Mark(60, 40, 90);
        Mark r2m2 = new Mark(60, 60, 90);
        Mark r2m3 = new Mark(60, 50, 90);
        
        List<Mark> listmark1 = new ArrayList<Mark>();
        listmark1.add(r2m1);
        listmark1.add(r2m2);
        listmark1.add(r2m3);
        
        Record record2 = new Record("r2");
        record2.setListOfMark(listmark1);
        
          Mark r3m1 = new Mark(70, 40, 90);
        Mark r3m2 = new Mark(70, 60, 90);
        Mark r3m3 = new Mark(70, 50, 90);
        
        List<Mark> listmark2 = new ArrayList<Mark>();
        listmark2.add(r3m1);
        listmark2.add(r3m2);
        listmark2.add(r3m3);
        
        Record record3 = new Record("r3");
        record3.setListOfMark(listmark2);
        
        List<Record> listrecord = new ArrayList<Record>();
        listrecord.add(record1);
        listrecord.add(record2);
        listrecord.add(record3);
        student.setListOfRecord(listrecord);
        
        listOfStudents = new ArrayList<Student>();
        listOfStudents.add(student);
        
    }
    
    public String pdf() throws JRException, IOException {

        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(listOfStudents);
        String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reports/mai.jasper");
        JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, new HashMap(), beanCollectionDataSource);
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
        
        return null;
    }
}
