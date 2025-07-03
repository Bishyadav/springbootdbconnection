package com.example.springbootdbconnection.controller;

public class ReverseWord {
    public static void main(String[] args) {
        String st="Good morning sir";
        st=st.trim().replaceAll("\\s"," ");
        String rev="";
        String[] str=st.split("\\s");
        for(int i= str.length-1;i>=0;i--){
            rev=rev+str[i];
            if(i!=0){
                rev=rev+" ";
            }
        }
        System.out.print(rev);
    }
}
