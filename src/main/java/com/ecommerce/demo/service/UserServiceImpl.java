//package com.ecommerce.demo.service.impl;
//
//import com.ecommerce.demo.entity.User;
//import com.ecommerce.demo.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementSetter;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.Resource;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//@Service("userServices")
//public class UserServiceImpl implements UserService {
//
//    @Resource
//    private JdbcTemplate jdbcTemplate;
//
//
//
//
//    @Override
//    public String insertUser() {
//        int id = 6;
//        String name = "XAVI";
//        String password = "123";
//        int age = 35;
//
//        String sql = "insert into users values(?,?,?,?)";
//        int res = jdbcTemplate.update(sql, id, name, password, age);
//
//        return null;
//    }
//
//    @Override
//    public List<User> readAllUser() {
//        String sql = "select * from users";
//        List<User> list = jdbcTemplate.query(sql, new RowMapper<User>() {
//            @Override
//            public User mapRow(ResultSet resultSet, int i) throws SQLException {
//                User user = new User();
//                user.setId(resultSet.getInt(1));
//                user.setName(resultSet.getString(2));
//                user.setPassword(resultSet.getString(3));
//                user.setAge(resultSet.getInt(4));
//
//                // TODO: 2019-01-08  Do we need to do list.add()?
//                return user;
//            }
//        });
//        return list;
//    }
//
//    @Override
//    public int updateUser(User user) {
//        String sql = "update user set name = ?, password = ?, age = ? where id = ?";
//        int res =  jdbcTemplate.update(sql, new PreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement preparedStatement) throws SQLException {
//                preparedStatement.setString(1, user.getName());
//                preparedStatement.setString(2, user.getPassword());
//                preparedStatement.setInt(3, user.getAge());
//                preparedStatement.setInt(4, user.getId());
//            }
//        });
//
//
//        return res;
//    }
//
//    @Override
//    public int deleteUser(Integer id) {
//        String sql = "delete from users where id = ?";
//        int res = jdbcTemplate.update(sql, new PreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement preparedStatement) throws SQLException {
//                preparedStatement.setInt(1, id);
//            }
//        });
//        return res;
//    }
//}
