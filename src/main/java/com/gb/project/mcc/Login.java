package com.gb.project.mcc;


import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.Map;

@Component
public class Login {
    public String login_post(Map<String, String> body, HttpSession session){
        Connection con = null;
        String server = "localhost"; // MySQL 서버 주소
        String database = "mmc"; // MySQL DATABASE 이름
        String user_name = "root"; //  MySQL 서버 아이디
        String password = "dbswo1025"; // MySQL 서버 비밀번호
        String result ="";

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
            String query = "SELECT userPassword, userNum FROM user WHERE userId='"+body.get("name")+"'";
            ResultSet rs = stmt.executeQuery(query);
            if(rs.getRow() == 0){
                result = "redirect:/";
            }
            while(rs.next()) {
                if (rs.getString(1).equals(body.get("password"))) {
                    if (body.get("name").equals("admin")) {
                        result = "redirect:/admin/register";
                        session.setAttribute("userNum", "admin");
                    } else {
                        result = "redirect:/benefit";
                        session.setAttribute("userNum", rs.getInt(2));
                    }
                } else {
                    result = "redirect:/";
                }
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
        return result;
    }
}
