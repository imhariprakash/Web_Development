package com.dao;

public class Contact{
    private String name;
    private String username;

    private String password;

    private String department;
    private int year;
    private String phone;

    private static String login_username;
    private static String login_password;

    public Contact(String name, String username, String password, String department, int year, String phone){
        this.name = name;
        this.username = username;
        this.password = password;
        this.department = department;
        this.year = year;
        this.phone = phone;
    }

    public Contact(){
    }

    public String getName(){
        return name;
    }

    public String getUsername(){
        return username;
    }


    public String getPassword(){
        return password;
    }


    public String getDepartment(){
        return department;
    }

    public int getYear(){
        return year;
    }

    public String getPhone(){
        return phone;
    }

    public static String getLogin_username(){
        return login_username;
    }

    public static String getLogin_password(){
        return login_password;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setUsername(String username){
        this.username = username;
    }


    public void setPassword(String password){
        this.password = password;
    }


    public void setDepartment(String department){
        this.department = department;
    }

    public void setYear(int year){
        this.year = year;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public static void setLogin_username(String login_username){
        Contact.login_username = login_username;
    }

    public static void setLogin_password(String login_password){
        Contact.login_password = login_password;
    }

    public String toString(){
        return "Name: " + name + "\nUsername: " + username + "\nPassword: " + password + "\nDepartment: " + department + "\nYear: " + year + "\nPhone: " + phone;
    }
}