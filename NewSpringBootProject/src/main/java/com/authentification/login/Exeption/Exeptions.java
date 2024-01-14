package com.authentification.login.Exeption;

import com.google.common.base.Strings;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Exeptions {
    public Exeptions(){};

    public static ResponseEntity<String> getResposeEntity(String responseMessage, HttpStatus httpStatus){
       return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}",httpStatus);
    }

    public static JSONArray getJsonArray(String data)throws JSONException{
        JSONArray jsonArray =new JSONArray(data);
        return jsonArray;
    }

    public static Map<String,Object> getMapJson(String data){
        if(!Strings.isNullOrEmpty(data))
            return new Gson().fromJson(data , new TypeToken<Map<String,Object>>(){
            }.getType());
         return new HashMap<>();
    }


    public static Boolean isFileExist(String path){
        try {
            File file=new File(path);
            return (file!=null && file.exists()) ?Boolean.TRUE:Boolean.FALSE;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


}
