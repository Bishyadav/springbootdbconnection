package com.example.springbootdbconnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class MyService {
    @Autowired
    private Repository repository;

    public String getGreeting() throws SQLException {
        return repository.getConnectStatus();
    }
}
