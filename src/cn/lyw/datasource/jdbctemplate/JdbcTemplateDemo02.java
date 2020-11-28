package cn.lyw.datasource.jdbctemplate;

import cn.lyw.datasource.domain.Student;
import cn.lyw.datasource.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo02 {
  // 获取JDBCTemplate对象
  private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

  /**
   * 修改数据
   */
  @Test
  public void test1() {
    // 定义sql
    String sql = "UPDATE student SET age = 999 WHERE id = 1";
    // 执行sql
    int count = template.update(sql);
    System.out.println(count);
  }

  /**
   * 添加成员
   */
  @Test
  public void test2() {
    String sql = "INSERT INTO student VALUES(null, ?, ?)";
    int count = template.update(sql, "憨憨", 22);
    System.out.println(count);
  }

  /**
   * 删除刚刚添加的数据
   */
  @Test
  public void test3() {
    String sql = "DELETE FROM student WHERE name = ?";
    int count = template.update(sql, "憨憨");
    System.out.println(count);
  }

  /**
   * 查询结果，并封装成Map集合
   */
  @Test
  public void test4() {
    String sql = "SELECT * FROM student WHERE id = ?";
    Map<String, Object> map = template.queryForMap(sql, 3);
    System.out.println(map);
  }

  /**
   * 查询结果封装为list集合
   */
  @Test
  public void test5() {
    String sql = "SELECT * FROM student WHERE id = ? or id = ?";
    List<Map<String, Object>> maps = template.queryForList(sql, 1, 3);
    for (Map<String, Object> item : maps) {
      System.out.println(item);
    }
  }

  /**
   * 查询所有记录，封装成Student对象
   */
  @Test
  public void test6() {
    String sql = "SELECT * FROM student";
    List<Student> list = template.query(sql, new RowMapper<Student>() {
      @Override
      public Student mapRow(ResultSet rs, int i) throws SQLException {
        Student stu = new Student();
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int age = rs.getInt("age");
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        return stu;
      }
    });
    for (Student a : list) {
      System.out.println(a);
    }
  }

  /**
   * 获取所有数据，封装成BeanPropertyRowMapper对象
   */
  @Test
  public void test7() {
    String sql = "SELECT * FROM student";
    List<Student> list = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
    for (Student a : list) {
      System.out.println(a);
    }
  }

  /**
   * 显示所有数量
   */
  @Test
  public void test8() {
    String sql = "SELECT COUNT(id) FROM student";
    Long total = template.queryForObject(sql, Long.class);
    System.out.println(total);
  }
}
