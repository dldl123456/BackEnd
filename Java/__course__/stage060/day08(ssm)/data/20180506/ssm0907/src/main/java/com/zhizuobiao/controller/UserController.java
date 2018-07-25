package com.zhizuobiao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zhizuobiao.entity.User;
import com.zhizuobiao.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser.do")
    public ModelAndView getUser(@RequestParam(value = "user_id", required = false) Integer id) {

        User user = userService.getUser(id);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("user");

        mv.addObject("data", user);

        return mv;
    }

    @RequestMapping("/voidUser.do")
    public void voidUser(int id, HttpServletResponse resp) throws IOException {

        User user = userService.getUser(id);

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("user=" + user);

    }

    @RequestMapping("/testRedirect.do")
    public String testRedirect() {

        String url = "http://www.baidu.com?data=xiaoming&age=10";
        return "redirect:" + url;

    }

    @RequestMapping("/testForward.do")
    public String testForward() {

        String url = "/user/getUser.do?id=7";
        return "forward:" + url;

    }

}
