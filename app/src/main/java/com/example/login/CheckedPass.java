package com.example.login;

public class CheckedPass {
    public boolean check(String pass){
        String s1 = "", s2 = "", s3 = "", s4 = "";
        boolean check1 = true, check = true;
        for(int i = 0; i < pass.length(); i++){
            if(pass.charAt(i) >= 'a' && pass.charAt(i) <= 'z' ){
                s1 += pass.charAt(i);
            }
            else if(pass.charAt(i) >= 'A' && pass.charAt(i) <= 'Z'){
                s2 += pass.charAt(i);
            }
            else if(pass.charAt(i) >= '0' && pass.charAt(i) <= '9'){
                s3 += pass.charAt(i);
            }
            else if(pass.charAt(i) == ' ' || pass.charAt(i) == '\n'){
                check1 = false;
            }else{
                s4 += pass.charAt(i);
            }
        }
        if(pass.length() >= 6 && s1.length() > 0 && s2.length() > 0 && s3.length() > 0 && s4.length() > 0 && check1 == true)
            return true;
        else return false;
    }
}