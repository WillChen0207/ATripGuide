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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@CrossOrigin(origins = {"*"})
@ResponseBody
@Controller
public class LoginController extends BaseController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response){
        Object user = request.getSession().getAttribute("admin");
        if (user != null) {
            try {
                request.getRequestDispatcher("http://localhost:8080/manager/index").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            request.getRequestDispatcher("http://localhost:5173/login").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/loging")
    public Boolean loging(@RequestParam("userName") String userName,
                          @RequestParam("password") String password,
                          RedirectAttributes redirectAttributes,
                          HttpServletRequest request){
        if (Tools.isEmpty(userName)||Tools.isEmpty(password)){
            redirectAttributes.addFlashAttribute("message","用户名密码不得为空!");
            return false;
        }
        try {
            Admin admin = adminService.login(userName, password);
            if (Tools.isEmpty(admin)){
                redirectAttributes.addFlashAttribute("message","用户名不存在或密码错误!");
                return false;
            }else{
                if (admin.getState() == 1) {
                    request.getSession().setAttribute("admin", admin);
                    return true;
                } else {
                    redirectAttributes.addFlashAttribute("message","账户已被停用!");
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
