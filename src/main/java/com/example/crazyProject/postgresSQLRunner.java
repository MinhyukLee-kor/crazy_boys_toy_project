package com.example.crazyProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

@Component
public class postgresSQLRunner implements ApplicationRunner {
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String sql="";
        try (Connection connection = dataSource.getConnection()) {
//            System.out.println(dataSource.getClass());
//            System.out.println(connection.getMetaData().getURL());
//            System.out.println(connection.getMetaData().getUserName());
            Statement statement = connection.createStatement();

            System.out.println("쿼리를 입력해라. 종료하려면 END 를 입력해라");
            Scanner scan = new Scanner(System.in);
            sql = scan.nextLine();
            if(!(sql.equals("END"))) {
                ResultSet rs = statement.executeQuery(sql);
                ResultSetMetaData rsmd = rs.getMetaData();
                System.out.println("입력한 쿼리 : "+sql);
                int columnsNumber = rsmd.getColumnCount();
                while (rs.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs.getString(i);
                        System.out.print(rsmd.getColumnName(i) + ":" + columnValue);
                    }
                    System.out.println("");
                }
            } else {
                System.out.println("사요나라~");
            }
        } catch (Exception e) {
            System.out.println("입력한 쿼리 : "+sql+" 는 쿼리가아니라 카레임ㅋㅋ. 다시하셈");
            run(args);
        }
    }
}