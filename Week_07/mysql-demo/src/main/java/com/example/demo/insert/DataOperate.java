package com.example.demo.insert;

import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.*;

/**
 * @author
 * @date 2020/11/30 21:48
 */
@Component
public class DataOperate {

    @Resource
    DataSource dataSource;

    /**
     * PreparedStatement批量
     */
    public void preparedStatementInsert (){
        try {
            Connection conn = dataSource.getConnection();
            StopWatch sw = new StopWatch();
            sw.start();
            conn.setAutoCommit(false);
            String sql = "insert into salesorder(orderno,paytime,sendtime,distribution," +
                    "realpay,discountamount,totalprice,addressid) values(?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for(int i=0;i<1000000;i++) {
                pstmt.setString(1, "N1000" + i);
                pstmt.setString(2, "2020-11-30");
                pstmt.setString(3, "2020-11-30");
                pstmt.setInt(4, 2000);//配送id
                pstmt.setDouble(5, 200);
                pstmt.setDouble(6, 100);
                pstmt.setDouble(7, 300);
                pstmt.setInt(8, 1000);//地址id
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            pstmt.close();
            conn.commit();
            conn.setAutoCommit(true);
            sw.stop();
            System.out.println("批量插入数据成功，花费时间："+sw.getTotalTimeMillis()+"毫秒");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void multipleValuesInsert(){
        try {
            Connection conn = dataSource.getConnection();
            StopWatch sw = new StopWatch();
            sw.start();
            conn.setAutoCommit(false);
            StringBuilder sb = new StringBuilder();
                    sb.append("insert into SALESORDER2(orderno,paytime,sendtime,distribution," +
                    "realpay,discountamount,totalprice,addressid) values(?,?,?,?,?,?,?,?)");
            for(int m=0;m<4999;m++) {
                sb.append(",(?,?,?,?,?,?,?,?)");
            }
            PreparedStatement pstmt = conn.prepareStatement(sb.toString());
            for(int i=0;i<200;i++) {
                for (int j = 0; j < 5000; j++) {
                    int count = 8 * j;
                    pstmt.setString(1 + count, "N1000" + (i + count));
                    pstmt.setString(2 + count, "2020-11-30");
                    pstmt.setString(3 + count, "2020-11-30");
                    pstmt.setInt(4 + count, 2000);//配送id
                    pstmt.setDouble(5 + count, 200);
                    pstmt.setDouble(6 + count, 100);
                    pstmt.setDouble(7 + count, 300);
                    pstmt.setInt(8 + count, 1000);//地址id
                }
                pstmt.addBatch();
            }
            pstmt.executeBatch();
            pstmt.close();
            conn.commit();
            conn.setAutoCommit(true);
            sw.stop();
            System.out.println("批量插入数据成功，花费时间："+sw.getTotalTimeMillis()+"毫秒");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
