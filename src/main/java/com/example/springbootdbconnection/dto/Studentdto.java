package com.example.springbootdbconnection.dto;

import java.util.Objects;

public class Studentdto {
    private int s_id;
    private String s_name;
    private String s_address;

    public Studentdto(int s_id, String s_name, String s_address) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_address = s_address;
    }

    public int getId() {
        return s_id;
    }

    public void setId(int s_id) {

        this.s_id = s_id;
    }

    public String getName() {
        return s_name;
    }

    public void setName(String s_name) {
        this.s_name = s_name;
    }
    public String getAddress() {
        return s_address;
    }

    public void setAddress(String s_address) {
        this.s_address = s_address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Studentdto that = (Studentdto) o;
        return s_id == that.s_id && Objects.equals(s_name, that.s_name) && Objects.equals(s_address, that.s_address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s_id, s_name, s_address);
    }
}
