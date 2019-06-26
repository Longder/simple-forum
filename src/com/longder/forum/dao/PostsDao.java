package com.longder.forum.dao;

import com.longder.forum.entity.Posts;
import com.longder.forum.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 发帖表的数据库操作对象
 */
public class PostsDao {
    /**
     * 数据库连接
     */
    private Connection connection = DBUtil.getConnection();

    /**
     * 查询帖子列表，分页，带板块。
     *
     * @param category
     * @param page
     * @param pageSize
     * @return
     */
    public List<Posts> listPosts(String category, int page, int pageSize) {
        List<Posts> postsList = new ArrayList<>();
        String sql;
        try {
            /*
              预编译查询语句
             */
            PreparedStatement preparedStatement;
            if (category == null || "".equals(category)) {
                sql = "SELECT * FROM POSTS order by post_time_ desc limit ?,?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, (page - 1) * pageSize);
                preparedStatement.setInt(2, pageSize);
            } else {
                sql = "SELECT * FROM POSTS where category_ = ? order by post_time_ desc limit ?,?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, category);
                preparedStatement.setInt(2, (page - 1) * pageSize);
                preparedStatement.setInt(3, pageSize);
            }
            // 执行查询操作
            /*
              查询出来的结果集
             */
            ResultSet resultSet = preparedStatement.executeQuery();
            //遍历结果集
            while (resultSet.next()) {
                postsList.add(fillPosts(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
        return postsList;
    }


    /**
     * 查询总页数
     *
     * @return
     */
    public int getTotalPages(int pageSize, String category) {
        int totalPages;
        try {
            /*
              预编译查询语句
             */
            PreparedStatement preparedStatement;
            connection = DBUtil.getConnection();
            String sql;
            if (category == null || "".equals(category)) {
                sql = "SELECT COUNT(*) FROM POSTS";
                preparedStatement = Objects.requireNonNull(connection).prepareStatement(sql);
            } else {
                sql = "SELECT COUNT(*) FROM POSTS WHERE category_ = ?";
                preparedStatement = Objects.requireNonNull(connection).prepareStatement(sql);
                preparedStatement.setString(1, category);
            }
            /*
              查询出来的结果集
             */
            ResultSet resultSet = preparedStatement.executeQuery();
            int count = 0;
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            if (count % pageSize == 0) {
                totalPages = count / pageSize;
            } else {
                totalPages = count / pageSize + 1;
            }
            return totalPages;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            DBUtil.closeConnection(connection);
        }
    }

    /**
     * 填充一个帖子对象
     *
     * @param resultSet
     * @return
     */
    private Posts fillPosts(ResultSet resultSet) throws SQLException {
        Posts posts = new Posts();
        posts.setId(resultSet.getLong("id_"));
        posts.setTitle(resultSet.getString("title_"));
        posts.setPostTime(resultSet.getDate("post_time_"));
        posts.setCategory(resultSet.getString("category_"));
        return posts;
    }

}
