package utils;

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


}
