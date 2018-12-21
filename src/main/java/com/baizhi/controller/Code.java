package com.baizhi.controller;

import com.baizhi.util.CreateValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("img")
public class Code {
    @RequestMapping("createImg")
    public void createImg(HttpSession session, HttpServletResponse res) throws Exception {
        CreateValidateCode cvc = new CreateValidateCode();
        String code = cvc.getCode();
        session.setAttribute("code", code);
        cvc.write(res.getOutputStream());
    }

    @RequestMapping("/checkCode")
    @ResponseBody
    public String checkCode(String code, HttpSession session) {
        String str = (String) session.getAttribute("code");
        if (code.equalsIgnoreCase(str)) {
            return "success";
        }
        return "error";
    }
}
