package com.example.Jasper;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
public class Service {

    public List<Student> getAllStudent() {
        List<Student> studentList = new ArrayList<>();
        Student s1 = new Student(1,"Nafiul","SE",14,"January");
        Student s2 = new Student(2,"Islam","SE",14,"January");
        Student s3 = new Student(3,"Nayeem","SE",14,"January");
        Student s4 = new Student(4,"Nafi","SE",14,"January");
        Student s5 = new Student(5,"Ronaldo","SE",14,"January");
        Student s6 = new Student(6,"Messi","SE",14,"January");
        Student s7 = new Student(7,"Neymar","SE",14,"January");
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        studentList.add(s6);
        studentList.add(s7);
        return studentList;
    }

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:Student.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(getAllStudent());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Nafiul Islam");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint,  "\\student.html");
        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint,  "\\student.pdf");
        }

        return "report generated ";
    }
}
