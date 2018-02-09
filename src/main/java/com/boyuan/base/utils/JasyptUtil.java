package com.boyuan.base.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boyuan.base.EasyhrException;
import com.boyuan.domain.Post;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;

import java.lang.reflect.Field;

/**
 * @author jiangbo
 * @time 2018/2/8
 */
public class JasyptUtil<T> {

    private static StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

    private static BasicTextEncryptor textEncryptor;

    private static String password = "easyhr is the best";

    /**
     * 加密密码
     */
    public static String encryptPassword(String password){
        return passwordEncryptor.encryptPassword(password);
    }

    /**
     * 检查密码
     */
    public static boolean checkPassword(String inputPassword,String encryptedPassword){
        return passwordEncryptor.checkPassword(inputPassword,encryptedPassword);
    }

    /**
     * 加密文本
     */
    public static String encryptText(String text) throws EasyhrException{
        try{
            if(textEncryptor == null){
                textEncryptor = new BasicTextEncryptor();
                textEncryptor.setPassword(password);
            }
            return textEncryptor.encrypt(text);
        }catch (Exception e){
            throw new EasyhrException("加密失败");
        }
    }

    /**
     * 解密文本
     */
    public static String decryptText(String text) throws EasyhrException{
        try{
            if(textEncryptor == null){
                textEncryptor = new BasicTextEncryptor();
                textEncryptor.setPassword(password);
            }
            return textEncryptor.decrypt(text);
        }catch (Exception e){
            throw new EasyhrException("解密失败");
        }
    }

    /**
     * 加密对象
     */
    public static <T> T encryptObject(Object data,Class<T> clazz) throws Exception{
        JSONObject jsonObject = (JSONObject) JSON.toJSON(data);
        for (String key : jsonObject.keySet()) {
            if (jsonObject.get(key) != null && jsonObject.get(key) instanceof String){
                jsonObject.put(key,encryptText(jsonObject.get(key).toString()));
            }
        }
        return jsonObject.toJavaObject(clazz);
    }

    /**
     * 解密对象
     */
    public static <T> T decryptObject(Object data,Class<T> clazz) throws Exception{
        JSONObject jsonObject = (JSONObject) JSON.toJSON(data);
        for (String key : jsonObject.keySet()) {
            if (jsonObject.get(key) != null && jsonObject.get(key) instanceof String){
                jsonObject.put(key,decryptText(jsonObject.get(key).toString()));
            }
        }
        return jsonObject.toJavaObject(clazz);
    }
}
