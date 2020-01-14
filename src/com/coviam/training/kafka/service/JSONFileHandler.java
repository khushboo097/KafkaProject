package com.coviam.training.kafka.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONFileHandler implements FileHandler {
    static int i = 0;
    static List<Employee> list = new ArrayList<>();

    private void JsRead() throws IOException, ParseException {
        Object obj = new org.json.simple.parser.JSONParser().parse(new FileReader("/Users/sangeetha/Downloads/employee.json"));

        List<Employee> employeeArrayList = new ArrayList();
        JSONArray jo = (JSONArray) obj;


        jo.forEach(jsonObject -> {
            JSONObject jsonObject1 = (JSONObject) jsonObject;
            Employee employee = new Employee();
            employee.setFirstName(((String) jsonObject1.get("firstName")));
            employee.setLastName((String) jsonObject1.get("lastName"));
            employee.setDateOfBirth(((String) jsonObject1.get("dateOfBirth")));
            Long temp =  (long)jsonObject1.get("experience");
            employee.setExperience((double) temp);
            //employeeArrayList.add(employee);
            list.add(employee);


            /*for (Employee e: list)
            System.out.println("JsRead emp = " + e);*/
           // System.out.println("size of list in JsRead = " + list.size());

        });
       // for (Employee e: list)
           // System.out.println("JsRead emp = " + e);
        //return  list;

    }

    public  Employee read() throws Exception {


        //List<Employee> list =
        JsRead();
        Employee emp = new Employee();
        emp = list.get(i);
        System.out.println("json" + emp );
        i++;
        return emp;

    }
}