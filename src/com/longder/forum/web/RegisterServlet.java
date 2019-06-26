package com.longder.forum.web;

import com.longder.forum.dao.SysUserDao;
import com.longder.forum.entity.SysUser;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注册功能的Servlet
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //取出表单数据
        String name = req.getParameter("name");
        String loginName = req.getParameter("loginName");
        String password = req.getParameter("password");

        //添加用户
        SysUserDao sysUserDao = new SysUserDao();
        SysUser user = new SysUser(name,loginName,password);
        sysUserDao.addUser(user);

        //重定向到登录页
        resp.sendRedirect("/login.jsp");

    }
}
