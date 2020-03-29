package com.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.InetAddress;


public  class Main {
    public static void main(String[] args) throws IOException {
       Pet pet = new Pet();
       pet.age = 10;
       pet.name = "HUI";
       pet.weight = 5;
       pet.countChlens = 2;
       pet.hot = false;
       Gson gson = new Gson();
       String json = gson.toJson(pet);
       System.out.println(json);

       BlockingRS rs = new BlockingRS("0.0.0.0", 9090);
       rs.Send(gson.toJson(pet));
       String message = rs.Read();
       pet = gson.fromJson(message,Pet.class);



    }

}
