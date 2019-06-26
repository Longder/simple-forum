package com.longder.forum.web;

import com.longder.forum.dao.SysUserDao;
import com.longder.forum.entity.SysUser;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 登录功能的Servlet
 */
public class LoginServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginName = req.getParameter("loginName");
        String password = req.getParameter("password");
        SysUserDao sysUserDao = new SysUserDao();
        SysUser sysUser = sysUserDao.findByLoginName(loginName);
        if (sysUser == null) {
            req.setAttribute("errorMessage", "用户名不存在");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else if (!sysUser.getPassword().equals(password)) {
            req.setAttribute("errorMessage", "密码错误");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            //登录成功与否的信息放到cookie中
            Cookie coo = new Cookie("isLogin", "true");
            resp.addCookie(coo);
            resp.sendRedirect("/posts");
        }
    }
}
