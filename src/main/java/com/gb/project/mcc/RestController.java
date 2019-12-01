package com.gb.project.mcc;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    @PostMapping("/aa")
    public String testapi(@RequestParam Map<String, String> body){
        Connection con = null;
        String server = "localhost"; // MySQL 서버 주소
        String database = "studentinfo"; // MySQL DATABASE 이름
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
            String query = "SELECT prnumber FROM student WHERE stname='"+body.get("name")+"'";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                if(rs.getInt(1)==Integer.parseInt(body.get("password"))){
                    result = "로그인 성공";
                }
                else{
                    result = "로그인 실패";
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
