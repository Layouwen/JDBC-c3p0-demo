package cn.lyw.datasource.druid;

import cn.lyw.datasource.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用新的工具类
 */

public class druidDemo02 {
  public static void main(String[] args) {
    /**
     * 完成添加操作
     */
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
      // 获取连接
      conn = JDBCUtils.getConnection();
      System.out.println(conn);
      // 定义sql语句
      String sql = "INSERT INTO student VALUES(null, ?, ?)";
      // 获取pstmt对象
      pstmt = conn.prepareStatement(sql);
      // 赋值操作
      pstmt.setString(1, "王玉玉");
      pstmt.setInt(2, 399);
      // 执行sql语句
      int count = pstmt.executeUpdate();
      System.out.println(count);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      // 释放资源
      JDBCUtils.close(pstmt, conn);
    }
  }
}
