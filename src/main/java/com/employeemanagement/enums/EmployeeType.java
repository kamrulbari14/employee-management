package com.employeemanagement.enums;

public enum EmployeeType {
    FULL,
    PART_TIME;
    public static Boolean findByName(String name) {
        Boolean result = false;
        for (EmployeeType EmployeeType : values()) {
            if (EmployeeType.name().equalsIgnoreCase(name)) {
                result = true;
                break;
            }
        }
        return result;
    }
    
}
