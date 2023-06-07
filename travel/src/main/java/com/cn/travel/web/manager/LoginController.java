package com.cn.travel.web.manager;

import com.cn.travel.role.admin.entity.Admin;
import com.cn.travel.role.admin.service.imp.AdminService;
import com.cn.travel.utils.Tools;
import com.cn.travel.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@Controller
public class LoginController extends BaseController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response){

    }

    @ResponseBody
    @RequestMapping("/loging")
    public boolean loging(HttpServletRequest request){
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        try {
            Admin admin = adminService.login(userName, password);
            if (Tools.isEmpty(admin)){
                return false;
            }else{
                if (admin.getState() == 1) {
                    request.getSession().setAttribute("admin", admin);
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        Object user = request.getSession().getAttribute("admin");
        if (user != null) {
            request.getSession().removeAttribute("admin");
        }
        return "/login";
    }
}
