package com.neon.arthurabreu.neon.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by af2g on 15/12/2017.
 */

public class Preferences extends Cripto{

    private SharedPreferences prefs;
    private Context context;

    public Preferences(Context context,String name)
    {
        prefs = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        this.context = context;
    }

    public void setString(String nome, String valor)
    {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(nome, valor);
        editor.commit();
    }

    public String getString(String nome)
    {
        String valor = prefs.getString(nome, "");
        return valor;
    }

    public void setInt(String nome, int valor)
    {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(nome, valor);
        editor.commit();
    }

    public Integer getInt(String nome)
    {
        Integer valor = prefs.getInt(nome, 0);
        return valor;
    }

    public void setBool(String nome, boolean valor)
    {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean(nome, valor);
        editor.commit();
    }

    public boolean getBool(String nome)
    {
        boolean valor = prefs.getBoolean(nome, false);
        return valor;
    }

    public void setLong(String nome, long valor)
    {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(nome, valor);
        editor.commit();
    }

    public long getLong(String nome)
    {
        long valor = prefs.getLong(nome, -1);
        return valor;
    }

//    public void setObject(String nome, Object valor)
//    {
//        try {
//            String json = Webservice.unparser(valor);
//            SharedPreferences.Editor editor = prefs.edit();
//            json = Cripto.encryptNew(context,json);
//            editor.putString(nome, json);
//            editor.apply();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public <T> Object getObject(String nome, Type type)
//    {
//        try {
//            String valorEnc = prefs.getString(nome, "");
//            if(!SystemSettings.isStringEmptyOrNull(valorEnc)){
//                valorEnc = Cripto.decryptNew(context,valorEnc);
//                if (!SystemSettings.isStringEmptyOrNull(valorEnc)) {
//                    return Webservice.parser(valorEnc,type);
//                }
//            }
//            return null;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    public void clearData(){
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.commit();
    }

    public void setArrayList(String key, ArrayList<? extends Object> list){
        Gson gson = new Gson();
        String json = gson.toJson(list);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, json);
        editor.commit();
    }

    public ArrayList<? extends Object> getArrayList(String key, Type type){

        ArrayList<? extends Object> list;

        Gson gson = new Gson();
        String json = prefs.getString(key, "");

        if (json.isEmpty()) {
            return null;
        } else {
            list = gson.fromJson(json, type);
        }
        return list;
    }
}