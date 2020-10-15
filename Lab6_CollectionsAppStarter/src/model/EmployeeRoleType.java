/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author harmony
 */
public enum EmployeeRoleType {
    PROJECT_LEADER('A',6),
    ANALYST('B',3),
    DEVELOPER('B',3),
    TESTER('C',1);
    private final  char salaryGrade;
    private final int noticePeriod;

    private EmployeeRoleType(char salaryGrade,int noticePeriod) {
        this.salaryGrade=salaryGrade;
        this.noticePeriod=noticePeriod;
    }
    
    
}
