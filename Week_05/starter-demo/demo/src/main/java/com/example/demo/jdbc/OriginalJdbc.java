package com.example.demo.jdbc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;

/**
 * @author
 * @date 2020/11/18 20:01
 */
@Component
public class OriginalJdbc {

    @Resource
    DataSource dataSource;

    public void jdbcTask() throws ClassNotFoundException, SQLException {
        /*   原生JDBC
        Class.forName("com.mysql.jdbc.Driver");//加载驱动

        String jdbc = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf8";
        Connection conn = DriverManager.getConnection(jdbc, "root", "123456");
        */
        /**
         *  使用Hikari 连接池
         */
        Connection conn = dataSource.getConnection();
        originalExcute(conn);

        startPreparedStatement(conn);

        conn.close();//关闭通道
    }

    /**
     * 原生jdbc
     * @param conn
     * @throws SQLException
     */
    public static void originalExcute(Connection conn) throws SQLException {
        //查询
        Statement state=conn.createStatement();
        String sql="select name,age from student";
        ResultSet rs = state.executeQuery(sql);
        while (rs.next()){
            System.out.println("名字："+rs.getString(1)+",年龄："+rs.getString(2));
        }
        //增加
        sql="insert into student(name,age) values('张三',18)";
        state.executeUpdate(sql);

        //更新
        sql="update student set age=20 where name='张三'";
        state.executeUpdate(sql);

        //删除
        sql="delete from student where name='张三'";
        state.executeUpdate(sql);

        startPreparedStatement(conn);
    }

    /**
     * 批处理，PrepareStatement + 事务
     * @param conn
     */
    public static void startPreparedStatement(Connection conn){
        try {
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement("insert into student(name,age) values(?,?)");
            for(int i=0;i<100;i++) {
                pstmt.setString(1, "李四" + i);
                pstmt.setInt(2, 30);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            pstmt.close();
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
