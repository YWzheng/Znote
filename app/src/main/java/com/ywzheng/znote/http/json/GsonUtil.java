package com.ywzheng.znote.http.json;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by yongwei on 2016/9/22.
 * description: Gson的封装
 */

public class GsonUtil {

    private static Gson gson;

    static {
        GsonBuilder builder = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
//                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//会把字段首字母大写,注:对于实体上使用了@SerializedName注解的不会生效.
                .setPrettyPrinting() //对json结果格式化.
                .serializeNulls()
                .setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")//时间转化为特定格式
                .excludeFieldsWithoutExposeAnnotation() //不导出实体中没有用@Expose注解的属性
                .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
                .setVersion(1.0)    //有的字段不是一开始就有的,会随着版本的升级添加进来,
                                    // 那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.
                                    //@Since(版本号)能完美地实现这个功能.还的字段可能,随着版本的升级而删除,那么
                                    //@Until(版本号)也能实现这个功能,GsonBuilder.setVersion(double)方法需要调用.
                .registerTypeAdapter(Date.class, new JsonDeserializer() {
                    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
                        return json == null ? null : new Date(json.getAsLong() * 1000L);
                    }
                });
        gson = builder.create();
    }

    private GsonUtil() {
    }

    public static <T> T fromJson(String json, Type type) {
        return gson.fromJson(json, type);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static <T> T fromJson(byte[] bytes, Class<T> clazz) {
        return gson.fromJson(new String(bytes), clazz);
    }

    public static String toJson(Object src) {
        return gson.toJson(src);
    }


}
