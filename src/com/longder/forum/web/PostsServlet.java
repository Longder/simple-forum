package com.longder.forum.web;

import com.longder.forum.dao.PostsDao;
import com.longder.forum.entity.Posts;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 帖子页面的Servlet
 */
public class PostsServlet extends HttpServlet {
    private final int PAGE_SIZE = 5;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //板块信息
        String category = req.getParameter("category");
        //页数，默认第一页
        int page = 1;

        PostsDao postsDao = new PostsDao();
        if (req.getParameter("page") != null && !req.getParameter("page").equals("")) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        //查询帖子列表
        List<Posts> postsList = postsDao.listPosts(category, page, PAGE_SIZE);
        //查询总页数
        int total = postsDao.getTotalPages(PAGE_SIZE,category);
        req.setAttribute("list", postsList);
        req.setAttribute("total",total);
        req.setAttribute("category",category);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
