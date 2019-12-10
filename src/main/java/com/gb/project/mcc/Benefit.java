package com.gb.project.mcc;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

@Component
public class Benefit {
    public JSONObject benefit_post(Map<String, String> body) {
        Connection con = null;
        String server = "localhost"; // MySQL 서버 주소
        String database = "mmc"; // MySQL DATABASE 이름
        String user_name = "root"; //  MySQL 서버 아이디
        String password = "dbswo1025"; // MySQL 서버 비밀번호
        JSONObject obj = new JSONObject();
        ArrayList arr_card = new ArrayList<>();

        // 1.드라이버 로딩
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(" !! <JDBC 오류> Driver load 오류: " + e.getMessage());
            e.printStackTrace();
        }

        // 2.연결
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + server + "/" + database + "?serverTimezone=UTC", user_name, password);
            System.out.println("정상적으로 연결되었습니다.");
            String temp = null;
            Statement stmt = con.createStatement();
            for(Integer i = 0; i < 10; i++) {
                if(body.get(i.toString()) != null){
                    if(temp != null) {
                        temp = temp + " OR benefitNum=" + i;
                    }
                    else{
                        temp = "benefitNum=" + i;
                    }
                }
            }
            String query3 = String.format("select distinct cardNum from cardbenefit where %s", temp);
            ResultSet rs = stmt.executeQuery(query3);
            while(rs.next()){
                obj.put(rs.getInt(1), rs.getString(2));
            }
            rs.close();
            stmt.close();
        } catch(SQLException e) {
            System.err.println("con 오류:" + e.getMessage());
            e.printStackTrace();
        }

        // 3.해제
        try {
            if(con != null)
                con.close();
        } catch (SQLException e) {}
        System.out.println(obj);
        return obj;
    }

}
