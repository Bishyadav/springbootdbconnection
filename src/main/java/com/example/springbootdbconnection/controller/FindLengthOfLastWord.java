package com.example.springbootdbconnection.controller;

public class FindLengthOfLastWord {
    public static void main(String[] args) {
        String s="       Hello i am LeetCode      ";
        s=s.trim();
        String[] str=s.split("\\s");
        int leng= str.length;
        System.out.print(str[leng-1].length());
    }
}
