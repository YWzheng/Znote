package com.ywzheng.znote.utils.my;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * json解析类
 */
public class GsonUtil {
    private final static Gson gson = new GsonBuilder()
            .serializeNulls()
            .create();


    public static <T> T parseJson(String json, Class<T> clazz) {
        T t = null;

        try {
            t = gson.fromJson(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }

    public static <T> T parseJson(String json, Type typeOfT) {
        T t = null;

        try {
            t = gson.fromJson(json, typeOfT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }

    public static String toJson(Object obj) {
        return obj == null ? null : gson.toJson(obj);
    }



}
