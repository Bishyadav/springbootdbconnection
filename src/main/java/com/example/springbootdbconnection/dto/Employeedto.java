package com.example.springbootdbconnection.dto;

import java.util.Objects;

public class Employeedto {
    private Integer e_id;
    private String e_name;
    private Integer e_sal;

    public Employeedto(Integer e_id, String e_name, Integer e_sal) {
        this.e_id = e_id;
        this.e_name = e_name;
        this.e_sal = e_sal;
    }

    public Integer getId() {
        return e_id;
    }

    public void setId(Integer e_id) {
        this.e_id = e_id;
    }

    public String getName() {
        return e_name;
    }

    public void setName(String e_name) {
        this.e_name = e_name;
    }

    public Integer getSalary() {
        return e_sal;
    }

    public void setSalary(Integer e_sal) {
        this.e_sal = e_sal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employeedto that = (Employeedto) o;
        return Objects.equals(e_id, that.e_id) && Objects.equals(e_name, that.e_name) && Objects.equals(e_sal, that.e_sal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(e_id, e_name, e_sal);
    }
}
