package com.litl.www.util;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DataProviderUtil {
    private static Connection conn;
    private static Statement stat;
    private static ResultSet resultSet;
    private static ProUtil prop;




    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop = new ProUtil("src/sql.properties");
            conn = DriverManager.getConnection("jdbc:mysql://"+prop.getPro("url")+"?useSSL=false", prop.getPro("user"), prop.getPro("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (!conn.isClosed()) {
                System.out.println("链接成功");
            } else {
                System.out.println("链接失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stat = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Object[][] getTestData(String tablename) throws SQLException {
        resultSet = stat.executeQuery("select * from " + tablename);
        List<Object[]> list = new ArrayList<Object[]>();
        int column = resultSet.getMetaData().getColumnCount();
        while (resultSet.next()) {
            String[] str = new String[column];
            for (int i = 0; i < str.length; i++) {
                str[i] = resultSet.getString(i + 1);
            }
            list.add(str);
        }

        stat.close();
        Object[][] results = new Object[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            results[i] = list.get(i);
        }
        return results;
    }

    public static void insertResult(String tablename,String casename,String result) throws SQLException {

        String sql="insert into "+tablename+"(casename,result,create_time) values(?,?,?)";
        PreparedStatement pstmt=conn.prepareStatement(sql);//获得预置对象
        pstmt.setString(1, casename);//设置占位符的值
        pstmt.setString(2, result);
        pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

        int res=pstmt.executeUpdate();//执行sql语句
        if(res>0){
            System.out.println("数据录入成功");
        }
        pstmt.close();//关闭资源
    }


}
