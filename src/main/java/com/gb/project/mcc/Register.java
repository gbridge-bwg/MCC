package com.gb.project.mcc;


import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.sql.*;

@Component
public class Register {
    public JSONObject register_get() {
        Connection con = null;
        String server = "localhost"; // MySQL 서버 주소
        String database = "mmc"; // MySQL DATABASE 이름
        String user_name = "root"; //  MySQL 서버 아이디
        String password = "dbswo1025"; // MySQL 서버 비밀번호
        JSONObject obj = new JSONObject();

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
            Statement stmt = con.createStatement();
            String query = "SELECT bankName FROM bank";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                obj.put(rs.getString(1), rs.getString(1));
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
