package com.gb.project.mcc;


import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

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
            String query = "SELECT * FROM bank ORDER BY bankNum";
            ResultSet rs = stmt.executeQuery(query);
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

    public void register_post(Map<String, String> body, HttpServletRequest request) throws Exception {
        Connection con = null;
        String server = "localhost"; // MySQL 서버 주소
        String database = "mmc"; // MySQL DATABASE 이름
        String user_name = "root"; //  MySQL 서버 아이디
        String password = "dbswo1025"; // MySQL 서버 비밀번호
        String filePathForDB = null;

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

            MultipartHttpServletRequest multi = (MultipartHttpServletRequest) request;
            MultipartFile file = multi.getFile("cardImg");
            String path ="";
            UUID randomUUID = UUID.randomUUID();

            if(file!=null){
                path = "." + File.separator + "img"+ File.separator;
                InputStream inputStream = null;
                OutputStream outputStream = null;
                String organizedfilePath="";

                if(file.getSize() > 0){
                    inputStream = file.getInputStream();
                    File realUploadDir = new File(path);

                    if(!realUploadDir.exists()){
                        realUploadDir.mkdirs();
                    }

                    organizedfilePath = path + randomUUID + "_" + file.getOriginalFilename();
                    filePathForDB = randomUUID + "_" + file.getOriginalFilename();
                    System.out.println(organizedfilePath);

                    outputStream = new FileOutputStream(organizedfilePath);

                    int readByte = 0;
                    byte[] buffer = new byte[8192];

                    while((readByte = inputStream.read(buffer, 0, 8120)) != -1){
                        outputStream.write(buffer, 0, readByte);
                    }

                }
                outputStream.close();
                inputStream.close();
            }

            Statement stmt = con.createStatement();
            String query = String.format("INSERT INTO card(cardName, bankNum, carImg, cardDetail) VALUES('%s', %d, '%s', '%s')", body.get("cardName"), Integer.parseInt(body.get("selectCard")), filePathForDB, body.get("cardDetail"));
            stmt.executeUpdate(query);
            String query2 = "SELECT MAX(cardNum) as max FROM card";
            ResultSet rs = stmt.executeQuery(query2);
            int max = 0;
            while(rs.next()) {
                max = rs.getInt(1);
            }
            for(Integer i = 0; i < 10; i++) {
                if(body.get(i.toString()) != null){
                    String query3 = String.format("INSERT INTO cardbenefit VALUES(%d, %d)", max, i);
                    stmt.executeUpdate(query3);
                }
            }
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
    }
}
