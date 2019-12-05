package com.gb.project.mcc;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    Login login;
    @Autowired
    Register register;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login_get(){
        return "index";
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String login_post(@RequestParam Map<String, String> body, Model model){
        String result = login.login_post(body);
        model.addAttribute("vas", "123");
        return result;
    }

    @RequestMapping(value = "/benefit", method = RequestMethod.GET, produces = "application/json", headers="Accept=application/json" )
    public String benefit_get(Model model, HttpServletRequest req, HttpServletResponse res){
        HttpSession session = req.getSession();
        session.setAttribute("abc", "def");
        JSONObject obj = new JSONObject();
        obj.put("a", "b");
        model.addAttribute("vas", "123");
        model.addAttribute("list", obj);
        return "index";
    }
    @RequestMapping(value = "/benefit/data", method = RequestMethod.GET, produces = "application/json", headers="Accept=application/json" )
    @ResponseBody
    public String benefit_get_data(Model model, HttpServletRequest req, HttpServletResponse res){
        return "hihi";
    }

    @RequestMapping(value = "/admin/register", method = RequestMethod.GET, produces = "application/json", headers="Accept=application/json")
    public String register_get(Model model, HttpServletRequest request){
        JSONObject obj = register.register_get();
        System.out.println(request.getCookies());
        model.addAttribute("bank_list", obj);
        model.addAttribute("value", "123");
        return "index";
    }
}
