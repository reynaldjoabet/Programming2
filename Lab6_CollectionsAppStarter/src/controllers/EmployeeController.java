/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import model.Employee;
import model.EmployeeRoleType;

/**
 *
 * @author harmony
 */
public class EmployeeController {
    TreeSet<Employee> employees;
    
    public  EmployeeController(){
        this.employees= new TreeSet<Employee>(Employee.EmpComparator);
    }
     public void addAllEmployees(){
         
     employees.add(new Employee(1,"Jean Paul",EmployeeRoleType.ANALYST));
     employees.add(new Employee(7,"Jean Jean",EmployeeRoleType.DEVELOPER));
     employees.add(new Employee(8,"Jean Pierer",EmployeeRoleType.TESTER));
     employees.add(new Employee(4,"Clinton Ntop",EmployeeRoleType.PROJECT_LEADER));
     employees.add(new Employee(6,"David Bamenda",EmployeeRoleType.ANALYST));
     employees.add(new Employee(3,"Samuel Paul",EmployeeRoleType.PROJECT_LEADER));
     employees.add(new Employee(5,"Abraham David",EmployeeRoleType.TESTER));
     employees.add(new Employee(2,"Albert Einstein",EmployeeRoleType.DEVELOPER));
     
     }
     
     
     public void  listEmployees(){
         System.out.println("List Elements");
        System.out.println("------------");
         employees.forEach((em) -> {
             System.out.println(em.toString());
        });
     }
     public void listEmployee(EmployeeRoleType roleType){
         System.out.println();
         System.out.println("list Elements by role");
        System.out.println("------------");
         for(Employee em: employees){
             
             if(em.getEmployeeRole()==roleType){
             System.out.println(em.toString());
             }
         }
     }
     
     public void run() {
        System.out.println("Add Elements");
        System.out.println("------------");
        addAllEmployees();
        listEmployees();
         listEmployee(EmployeeRoleType.DEVELOPER);
    
        System.out.println("Sort By Name");
         System.out.println("------------");
     
          displayElements(employees);

    
        

    }
     
     public void displayElements(TreeSet<Employee> customers){
         for(Employee employee:employees){
             System.out.println(employee.toString());
         }
     }

    
    
}
