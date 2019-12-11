package com.gb.project.mcc;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    Login login;
    @Autowired
    Register register;
    @Autowired
    Benefit benefit;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login_get(){
        return "index";
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String login_post(@RequestParam Map<String, String> body, HttpSession session){
        String result = login.login_post(body, session);
        return result;
    }

    @RequestMapping(value = "/admin/register/getbank", method = RequestMethod.GET)
    @ResponseBody
    public String register_getCard(){
        return register.register_get().toJSONString();
    }

    @RequestMapping(value = "/admin/register", method = RequestMethod.GET)
    public String register_get(HttpSession session){
        if(session.getAttribute("userNum").equals("admin"))
            return "index";
        else
            return "redirect:/";
    }
    @RequestMapping(value = "/admin/register", method = RequestMethod.POST)
    public String register_post(@RequestParam Map<String, String> body, HttpServletRequest request) throws Exception{
        System.out.println(body);
        register.register_post(body, request);
        return "redirect:/admin/register";
    }


    @RequestMapping(value = "/benefit", method = RequestMethod.GET)
    public String benefit_get(HttpSession session){
        if(session.getAttribute("userNum") != null)
            return "index";
        else
            return "redirect:/";
    }
    @RequestMapping(value = "/benefit/getNum", method = RequestMethod.POST)
    @ResponseBody
    public String benefit_getNum(@RequestParam Map<String, String> body) throws Exception{

        Connection con = null;
        String server = "localhost"; // MySQL 서버 주소
        String database = "mmc"; // MySQL DATABASE 이름
        String user_name = "root"; //  MySQL 서버 아이디
        String password = "dbswo1025"; // MySQL 서버 비밀번호
        String result ="";
        ArrayList arr_card = new ArrayList<>();
        JSONObject obj = new JSONObject();
        String temp = null;

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
            System.out.println(body);
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
            temp="";
            while(rs.next()){
                arr_card.add(rs.getInt(1));
                temp = temp+rs.getInt(1)+",";
            }
            for(int i = 0; i < arr_card.size(); i++){
                String query = "SELECT carImg FROM card WHERE cardNum="+arr_card.get(i);
                ResultSet rs2 = stmt.executeQuery(query);
                while(rs2.next()){
                    File file = new File("img/"+rs2.getString(1));
//        InputStream in = getClass().getResourceAsStream("../"+result);
                    InputStream in = new FileInputStream(file);
                    obj.put("card", IOUtils.toByteArray(in));
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
        System.out.println(obj.toString());
        System.out.println(temp);
        return temp.substring(0, temp.length()-1);

    }

    @RequestMapping(value = "/benefit/getSavedNum", method = RequestMethod.GET)
    @ResponseBody
    public String benefit_getSavedNum(@RequestParam Map<String, String> body, HttpSession session) throws Exception{

        Connection con = null;
        String server = "localhost"; // MySQL 서버 주소
        String database = "mmc"; // MySQL DATABASE 이름
        String user_name = "root"; //  MySQL 서버 아이디
        String password = "dbswo1025"; // MySQL 서버 비밀번호
        String temp = "";

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
            System.out.println(body);
            Statement stmt = con.createStatement();

            String query = "select benefitNum from savednum where userNum=" + session.getAttribute("userNum");
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                temp = temp+rs.getInt(1)+",";
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
        return temp.substring(0, temp.length()-1);
    }

    @RequestMapping(value = "/benefit/saveNum", method = RequestMethod.POST)
    @ResponseBody
    public String benefit_saveNum(@RequestParam Map<String, String> body, HttpSession session) throws Exception{

        Connection con = null;
        String server = "localhost"; // MySQL 서버 주소
        String database = "mmc"; // MySQL DATABASE 이름
        String user_name = "root"; //  MySQL 서버 아이디
        String password = "dbswo1025"; // MySQL 서버 비밀번호

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
            System.out.println(body);
            Statement stmt = con.createStatement();

            String query = "select benefitNum from savednum where userNum=" + session.getAttribute("userNum");
            ResultSet rs = stmt.executeQuery(query);
            System.out.println(rs.getRow());
            if(rs.next()){
                query = "DELETE FROM savednum WHERE userNum="+session.getAttribute("userNum");
                stmt.executeUpdate(query);
            }
            for(Integer i = 1; i < 10; i++){
                if(body.get(i.toString()) != null){
                    query = String.format("INSERT INTO savednum VALUES(%s, %s)", session.getAttribute("userNum"), body.get(i.toString()));
                    stmt.executeUpdate(query);
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
        return "성공";

    }
    @RequestMapping(value = "/benefit/getCard", method = RequestMethod.POST)
    public String benefit_(@RequestParam Map<String, String> body, Model model){
        String result = benefit.benefit_post(body).toJSONString();
        return result;
    }

    @RequestMapping(value = "/benefit/Image", method = RequestMethod.POST, produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] benefit_image(@RequestParam Map<String, String> body) throws Exception{
        Connection con = null;
        String server = "localhost"; // MySQL 서버 주소
        String database = "mmc"; // MySQL DATABASE 이름
        String user_name = "root"; //  MySQL 서버 아이디
        String password = "dbswo1025"; // MySQL 서버 비밀번호
        byte[] result = null;

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
            String query = "SELECT carImg FROM card WHERE cardNum='"+body.get("num")+"'";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                File file = new File("img/"+rs.getString(1));
//        InputStream in = getClass().getResourceAsStream("../"+result);
                InputStream in = new FileInputStream(file);
                result =  IOUtils.toByteArray(in);
                System.out.println("이미지 보냄");
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

    @RequestMapping(value = "/benefit/data", method = RequestMethod.POST)
    @ResponseBody
    public String benefit_data(@RequestParam Map<String, String> body) throws Exception{
        Connection con = null;
        String server = "localhost"; // MySQL 서버 주소
        String database = "mmc"; // MySQL DATABASE 이름
        String user_name = "root"; //  MySQL 서버 아이디
        String password = "dbswo1025"; // MySQL 서버 비밀번호
        JSONObject obj = new JSONObject();
        String cartegory = "";

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
            String query = "SELECT benefitName FROM benefit, cardbenefit WHERE cardNum='"+body.get("num")+"' AND benefit.benefitNum = cardbenefit.benefitNum";
            System.out.println(body.get("num") + "aa");
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                cartegory += (rs.getString(1) + ",");
            }
            System.out.println(cartegory);
            obj.put("cardCategory", cartegory.substring(0, cartegory.length()-1));
            query = "SELECT cardName, bankName, cardDetail FROM card, bank WHERE card.bankNum = bank.bankNum AND cardNum='" + body.get("num")+"'";
            rs = stmt.executeQuery(query);
            while(rs.next()){
                obj.put("cardName", rs.getString(1));
                obj.put("bankName", rs.getString(2));
                obj.put("cardDetail", rs.getString(3));
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
        return obj.toJSONString();
    }


}
