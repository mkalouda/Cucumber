package utils;

import org.json.JSONObject;

public class apiPayloadConstants {

    public static String createEmployeePayload(){
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Moe\",\n" +
                "  \"emp_lastname\": \"Kalouda\",\n" +
                "  \"emp_middle_name\": \"Jib\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1995-07-11\",\n" +
                "  \"emp_status\": \"Employee\",\n" +
                "  \"emp_job_title\": \"CEO\"\n" +
                "}";
        return createEmployeePayload;
    }

    public static String createUserPayload(){
        String createUser = "{\n" +
                "  \"email\": \"munzzzzz@gmail.com\",\n" +
                "  \"password\": \"pass333\"\n" +
                "}";

        return createUser;
    }

    public static String createEmployeeBody(){
        /**
         * we imported a dependency for JSONObject
         */

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", "Moe");
        obj.put("emp_lastname", "Kalouda");
        obj.put("emp_middle_name", "Jib");
        obj.put("emp_gender", "M");
        obj.put("emp_birthday", "1995-07-11");
        obj.put("emp_status", "Employee");
        obj.put("emp_job_title", "CEO");

        return obj.toString();
    }

    public static String createEmployeeBodyMoreDynamic(String firstName, String lastName, String middleName, String gender, String employeeBday, String employeeStatus, String employeeJobTitle){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname", firstName);
        obj.put("emp_lastname", lastName);
        obj.put("emp_middle_name", middleName);
        obj.put("emp_gender", gender);
        obj.put("emp_birthday", employeeBday);
        obj.put("emp_status", employeeStatus);
        obj.put("emp_job_title", employeeJobTitle);

        return obj.toString();
    }
}
