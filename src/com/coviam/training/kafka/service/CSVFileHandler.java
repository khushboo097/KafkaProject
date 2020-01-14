package com.coviam.training.kafka.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVFileHandler implements FileHandler {
    static int i =0 ;
    public Employee read() throws Exception {
        List<Employee> employees=new ArrayList<>();
        String csvfile="/Users/sangeetha/Downloads/employee.csv";
        BufferedReader br=null;
        String line="";
        String splitby=",";
        try {
            br=new BufferedReader(new FileReader(csvfile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while((line=br.readLine())!=null)
        {
            Employee emp=new Employee();
            String[] record=line.split(splitby);
            //System.out.println(record[1]+" "+record[2]);
            emp.setFirstName(record[0]);
            emp.setLastName(record[1]);
            emp.setDateOfBirth(record[2]);
            emp.setExperience(Double.parseDouble(record[3]));
            employees.add(emp);
        }
        i++;
        System.out.println("CSV  " + employees.get(i));

        return employees.get(i);

    }
}
