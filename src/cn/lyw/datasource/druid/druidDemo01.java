package cn.lyw.datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class druidDemo01 {
  public static void main(String[] args) throws Exception {
    // 导入jar包
    // 定义配置文件
    // 加载文件
    Properties pro = new Properties();
    InputStream is = druidDemo01.class.getClassLoader().getResourceAsStream("druid.properties");
    pro.load(is);
    // 获取连接池对象
    DataSource ds = DruidDataSourceFactory.createDataSource(pro);
    Connection conn = ds.getConnection();

    System.out.println(conn);
  }
}
