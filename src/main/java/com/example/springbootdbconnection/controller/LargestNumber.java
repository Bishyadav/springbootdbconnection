package com.example.springbootdbconnection.controller;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        int[] nums={2,6,3,9,1};
        System.out.print(largestNumber(nums));
    }
    public static String largestNumber(int[] nums) {
        String[] str=new String[nums.length];
        String temp="";
        for(int i=0;i<nums.length;i++){
            str[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));

        if (str[0].equals("0")) {
            return "0";
        }
        StringBuilder largestNumber = new StringBuilder();
        for (String st : str) {
            largestNumber.append(st);
        }

        return largestNumber.toString();
    }
}
