package com.example.uptoskills;

import java.util.ArrayList;
import java.util.List;

public class userdatabase {
    static List<String>username = new ArrayList<>();
    static List<String>email = new ArrayList<>();
    static List<String>password = new ArrayList<>();
    static List<String>title1 = new ArrayList<>();
    userdatabase(String date , String url , String description , String title){
        username.add(date);
        email.add(url);
        password.add(description);
    }
    userdatabase(){
    }
}
