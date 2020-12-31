package com.baby.bunny.student.management.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    public SessionManager(Context context) {

        preferences = context.getSharedPreferences("hvfuyf", 0);
        editor = preferences.edit();
    }

   /* public static void clearSessionManager(){
        editor.clear().apply();

    }


    public static void saveMPIN(String id) {
        editor.putString("USER_MPIN", id);
        editor.apply();
    }




    public static void savetoken(String mobile) {
        editor.putString("token", mobile);
        editor.apply();
    }


    public static String getUsermpin() {
        return preferences.getString("USER_MPIN", "");
    }

    public static String gettoken() {
        return preferences.getString("token", "");
    }*/




    public static void setLogged(boolean is) {
        editor.putBoolean("login", is);
        editor.apply();
    }


    public static boolean isLogged() {
        return preferences.getBoolean("login", false);
    }


    public static void setCenterManagerLogged(boolean is) {
        editor.putBoolean("CenterManagelogin", is);
        editor.apply();
    }


    public static boolean isCenterManageLogged() {
        return preferences.getBoolean("CenterManagelogin", false);
    }


    public static void setotpenable(boolean is) {
        editor.putBoolean("otp", is);
        editor.apply();
    }

    public static void setotp(String is) {
        editor.putString("otp", is);
        editor.apply();
    }


    public static String getotp() {
        return preferences.getString("otp", "");
    }

    public static void setCenterManagerotpenable(boolean is) {
        editor.putBoolean("CenterManagerotp", is);
        editor.apply();
    }

    public static void setCenterManagerotp(String is) {
        editor.putString("CenterManagerotp", is);
        editor.apply();
    }


    public static String getCenterManagerotp() {
        return preferences.getString("CenterManagerotp", "");
    }






    public static void setidboolean(boolean is) {
        editor.putBoolean("MyPREFERENCES", is);
        editor.apply();
    }


    public static boolean getidboolean() {
        return preferences.getBoolean("MyPREFERENCES", false);
    }


    public static void setidvalue(String id){
        editor.putString("id", id);
        editor.apply();
    }
    public  static String getidvalue(){
        return preferences.getString("id","");
    }



    public static void setCenterManageridboolean(boolean is) {
        editor.putBoolean("CenterManagerMyPREFERENCES", is);
        editor.apply();
    }


    public static boolean getCenterManageridboolean() {
        return preferences.getBoolean("CenterManagerMyPREFERENCES", false);
    }


    public static void setCenterManageridvalue(String id){
        editor.putString("CenterManagerid", id);
        editor.apply();
    }
    public  static String getCenterManageridvalue(){
        return preferences.getString("CenterManagerid","");
    }

    public static void setnamevalue(String name){
        editor.putString("name", name);
        editor.apply();
    }
    public  static String getnamevalue(){
        return preferences.getString("name","");
    }

    public static void setemailidvalue(String email){
        editor.putString("email", email);
        editor.apply();
    }
    public  static String getemailidvalue(){
        return preferences.getString("email","");
    }

    public static void setphnovalue(String phno){
        editor.putString("phno", phno);
        editor.apply();
    }
    public  static String getphnovalue(){
        return preferences.getString("phno","");
    }

    public static void setimagevalue(String image){
        editor.putString("image", image);
        editor.apply();
    }
    public  static String getimagevalue(){
        return preferences.getString("image","");
    }










}
