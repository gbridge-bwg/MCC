package com.gb.project.mcc;

import org.graalvm.compiler.lir.CompositeValue;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.Map;
@Component
public class Login {
    public String login_post(Map<String, String> body){
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
            String query = "SELECT userPassword FROM user WHERE userId='"+body.get("name")+"'";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                if(rs.getString(1).equals(body.get("password"))){
                    if(body.get("name").equals("admin")){
                        result = "redirect:/admin/register";
                    }
                    else{
                        result = "redirect:/benefit";
                    }
                }
                else{
                    result = "redirect:/";
                }
                //System.out.println("학생이름 : " + rs.getString(1) + " 학수번호 : " + rs.getInt(2) + " 성적 : " + rs.getString(3));
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
