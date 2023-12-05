package com.yagmur;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import com.yagmur.entity.User;
import com.google.gson.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
    private static final String URL = "https://randomuser.me/api/?results=5";
    public static void main(String[] args) {
        User user = new User();
        /*
        user.gender ="M";
        user.name.title = "DR.";
        user.name.first = "Ali";
         */

        Scanner sc = null;
        List<User> userList=new ArrayList<>();
        try{
            sc = new Scanner(new URL(URL).openStream(), StandardCharsets.UTF_8);
            StringBuilder sb = new StringBuilder();

            while (sc.hasNext()){
                System.out.println(sc.nextLine());
            }
            Gson gson = new Gson();
            JsonElement jsonElement = JsonParser.parseString(sb.toString()); //1. afım string to json element
            JsonObject jsonObject = jsonElement.getAsJsonObject (); //2. adımm  jsonelement json objecte dönüştürülür.
            JsonArray jsonArray = jsonObject.get("results").getAsJsonArray();

            int size = jsonObject.size();
            jsonArray.size();

            for(int i=0; i<size; i++){
                JsonObject userObject = jsonArray.get(i).getAsJsonObject();
                User user1 = gson.fromJson(userObject, User.class);
                userList.add(user);
            }
            System.out.println(userList);
        }catch (Exception exception){
            System.out.println("Beklenmeyen hata...: "+ exception.toString());
        }
    }





}
