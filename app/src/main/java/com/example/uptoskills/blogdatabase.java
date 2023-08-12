package com.example.uptoskills;

import java.util.ArrayList;
import java.util.List;

public class blogdatabase {
    public static List<String>date1 = new ArrayList<>();
    public static List<String>url1 = new ArrayList<>();
    public static List<String>description1 = new ArrayList<>();
    public static List<String>title1 = new ArrayList<>();
    blogdatabase(String date , String url , String description , String title){
        date1.add(date);
        url1.add(url);
        description1.add(description);
        title1.add(title);
    }
    blogdatabase(){
    }
}
