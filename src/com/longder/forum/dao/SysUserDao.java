package com.longder.forum.dao;

import com.longder.forum.entity.SysUser;
import com.longder.forum.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 系统用户表的数据库操作对象
 */
public class SysUserDao {
    /**
     * 数据库连接
     */
    private Connection connection = DBUtil.getConnection();
    /**
     * 预编译查询语句
     */
    private PreparedStatement preparedStatement;
    /**
     * 查询出来的结果集
     */
    private ResultSet resultSet;

    /**
     * 根据登录名查询
     * @param loginName
     * @return
     */
    public SysUser findByLoginName(String loginName){
        SysUser sysUser = null;
        String sql = "SELECT * FROM SYS_USER WHERE LOGIN_NAME_ = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,loginName);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                sysUser = fillUser(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(connection);
        }
        return sysUser;
    }

    /**
     * 添加一个用户
     * @param user
     */
    public void addUser(SysUser user){
        String sql = "INSERT INTO SYS_USER()";

    }

    /**
     * 通过resultSet填充sysUser
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private SysUser fillUser(ResultSet resultSet) throws SQLException {
        SysUser sysUser = new SysUser();
        sysUser.setId(resultSet.getLong("id_"));
        sysUser.setName(resultSet.getString("name_"));
        sysUser.setLoginName(resultSet.getString("login_name_"));
        sysUser.setPassword(resultSet.getString("password_"));
        return sysUser;
    }
}
