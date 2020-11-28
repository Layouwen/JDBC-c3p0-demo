package cn.lyw.datasource.jdbctemplate;

import cn.lyw.datasource.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate入门
 */

public class JdbcTemplateDemo01 {
  public static void main(String[] args) {
    // 导入jar包
    // 创建JdbcTemplate对象
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    // 调用方法
    String sql = "UPDATE student SET age = 1000 WHERE id = ?";
    int count = template.update(sql, 3);
    System.out.println(count);
  }
}
