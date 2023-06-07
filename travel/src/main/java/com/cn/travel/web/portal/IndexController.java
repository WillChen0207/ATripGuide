package com.cn.travel.web.portal;

import com.cn.travel.utils.Tools;
import com.cn.travel.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class IndexController extends BaseController {


    @RequestMapping("/index")
    public void index(HttpServletRequest request, HttpServletResponse response){
        try {
            response.sendRedirect("http://localhost:5173");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/goLogin")
    public void goLogin(HttpSession httpSession, HttpServletRequest request, HttpServletResponse response){
        try {
            response.sendRedirect("http://localhost:5173/login");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/goLogout")
    public ModelAndView goLogout(HttpSession httpSession){
        if(Tools.notEmpty(httpSession.getAttribute("userName"))){
            httpSession.removeAttribute("userName");
        }
        return new ModelAndView("portal/login");
    }
}
