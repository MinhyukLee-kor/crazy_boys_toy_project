package com.example.crazyProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

@Service
public class TestService {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String selectQuerry (String querry) {
        String result = "입력한 쿼리 : "+querry;
        try (Connection connection = dataSource.getConnection()) {
//            System.out.println(dataSource.getClass());
//            System.out.println(connection.getMetaData().getURL());
//            System.out.println(connection.getMetaData().getUserName());
            Statement statement = connection.createStatement();
            if(!(querry.equals("END"))) {
                ResultSet rs = statement.executeQuery(querry);
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                while (rs.next()) {
                    result += "\n";
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs.getString(i);
                        result += rsmd.getColumnName(i) + ":" + columnValue+"  ";
                    }
                }
            } else {
                System.out.println("사요나라~");
            }
        } catch (Exception e) {
            result = "입력한 쿼리 : " + querry + " 는 쿼리가아니라 카레임ㅋㅋ. 다시하셈";
            return result;
        }
        return result;
    }
}
