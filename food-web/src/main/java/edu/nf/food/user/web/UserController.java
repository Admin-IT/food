package edu.nf.food.user.web;

import edu.nf.food.label.service.exception.LabelException;
import edu.nf.food.user.dao.UserDao;
import edu.nf.food.user.entity.User;
import edu.nf.food.user.service.UserService;
import edu.nf.food.util.BaseController;
import edu.nf.food.util.CommconsEmail;
import edu.nf.food.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * @author ljf
 * @date 2020/4/2
 * 用户
 */
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserService service;

    @GetMapping("/login_user")
    public ResponseVO login(User user, HttpServletRequest request) {

        System.out.println(user.getUserEmail());
        System.out.println(user.getUserPass());
        User us = service.loginUser(user);
        request.getServletContext().setAttribute("user", us);
        return success("登录成功");
    }


    /**
     * 获取用户信息
     *
     * @param request
     * @return
     */
    @GetMapping("/get_user_info")
    public ResponseVO getUser(HttpServletRequest request) {
        User user1 = (User) request.getServletContext().getAttribute("user");
        System.out.println(user1.getUserId());
        return success(user1);

    }

    @GetMapping("/add_user")
    public ResponseVO addUser(User user, String yzm, HttpServletRequest request) {
        String yzms = (String) request.getServletContext().getAttribute("email");
        System.out.println(yzm);
        System.out.println(yzms + "session");
        if (!yzm.equals(yzms)) {
            throw new LabelException("验证码不正确");
        }
        User us = new User();
        us.setUserPass(user.getUserPass());
        us.setUserEmail(user.getUserEmail());
        us.setUserFans("0");
        us.setUserFollow("0");

        System.out.println("邮箱" + user.getUserEmail());
        System.out.println("密码" + user.getUserPass());
        service.addUser(user);
        return success("注册成功");


    }

    // 发送邮件
    @GetMapping("/send_email")
    public ResponseVO sendemail(String email, HttpServletRequest request)
            throws Exception {

        System.out.println(email);
        int pass = (int) ((Math.random() * 9 + 1) * 100000);//随机生成验证码
        String strText = "【有谱】您的验证码是 " + pass + ",用于有谱网站验证，请勿将验证码透露给他人，如非本人操作，请立即访问www.youpu.shop 查询";
        CommconsEmail.sendTextMail(email, "有谱网站邮件认证", strText);
        request.getServletContext().setAttribute("email", String.valueOf(pass));
        return success("发送成功");
    }

    //用于退出页面
    @GetMapping("/tologout")
    public String tologout(HttpSession session, HttpServletResponse response) throws IOException {

        session.setAttribute("user", null);
        response.sendRedirect("index.html");
        return "退出成功";
    }

}