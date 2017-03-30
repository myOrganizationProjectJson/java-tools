package ceshi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import com.mysql.jdbc.ResultSetMetaData;

public class db {
	public Object conn(){
        // 驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名scutcs
        String url = "jdbc:mysql://10.1.0.226:3306/game";
        // MySQL配置时的用户名
        String user = "root"; 
        // MySQL配置时的密码
        String password = "";
        try { 
         // 加载驱动程序
         Class.forName(driver);
         // 连续数据库
         Connection conn = DriverManager.getConnection(url, user, password);
         if(!conn.isClosed()) 
          System.out.println("Succeeded connecting to the Database!");
         return conn;
         // statement用来执行SQL语句
//         Statement statement = conn.createStatement();
//         return  statement;
//         // 要执行的SQL语句
//         String sql = "select * from ceshi";
//         // 结果集
//         ResultSet rs = statement.executeQuery(sql);
//         System.out.println("-----------------");
//         System.out.println("执行结果如下所示:");
//         System.out.println("-----------------");
//         System.out.println(" id" + "\t" + "    user_name" + "\t"+" amount" + "\t" + " roundid");
//         System.out.println("-----------------");
//         String name = null;
//         while(rs.next()) {
//          // 选择sname这列数据
//          name = rs.getString("user_name");
//          // 首先使用ISO-8859-1字符集将name解码为字节序列并将结果存储新的字节数组中。
//          // 然后使用GB2312字符集解码指定的字节数组
//         // name = new String(name.getBytes("ISO-8859-1"),"GB2312");
//          // 输出结果
//          System.out.println(rs.getString("id") + "  " + name + "\t"+rs.getString("amount")  + "\t"+rs.getString("roundid"));
//         }
//         rs.close();
//         conn.close();
        } catch(ClassNotFoundException e) {
         System.out.println("Sorry,can`t find the Driver!"); 
         e.printStackTrace();
        } catch(SQLException e) {
         e.printStackTrace();
        } catch(Exception e) {
         e.printStackTrace();
        }
		return 1; 
	}
	public String select(String sql){
		String Str="";
		try{
     Object conn=conn();
		
		  // 要执行的SQL语句
     // String sql = "select * from ceshi";
      Statement statement = ((Connection) conn).createStatement();
      // 结果集
      ResultSet rs = statement.executeQuery(sql);
//      System.out.println("-----------------");
//      System.out.println("执行结果如下所示:");
//      System.out.println("-----------------");
//      System.out.println(" id" + "\t" + "    user_name" + "\t"+" amount" + "\t" + " roundid");
//      System.out.println("-----------------");
     // ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
     // int colcount = rsmd.getColumnCount();
     
  
      ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
      int colcount1 = rsmd.getColumnCount();//取得全部列数
      Collection list=new HashSet();
      for(int i=1;i<=colcount1;i++){
         String colname = rsmd.getColumnName(i);//取得全部列名
       //  System.out.println(colname);
         list.add(colname);
      }
    
//      ResultSet rrrr=statement.executeQuery("describe rfcorp_admin");
//      //String[] list = new String[]{};
//      Collection list=new HashSet();
//       while (rrrr.next()) {
//    	String ssss=rrrr.getString(1); 
//    	   list.add(ssss);
//    	   System.out.println(ssss);
//      }
    
//      for(int i=0;i<colcount;i++){
//    	   String colname = rsmd.getColumnName(i);//取得全部列名
//    	   System.out.println(colname);
//    	}
       
       Iterator it =list.iterator();
//       while (it.hasNext()){
//	        String s=(String) it.next();
//	        System.out.println(s);
//	        //data+= rs.getString(s)+"\t";
//	       }
//       System.exit(1);
      String name = null;
      String data= "";
      while(rs.next()) {
    	  
    	   while (it.hasNext()){
    	        String s=(String) it.next();
    	        System.out.println(s);
    	        data+= rs.getString(s)+"\t";
    	       }
    	 //  data+="\n";
       // 选择sname这列数据
     //  name = rs.getString("username");
       // 首先使用ISO-8859-1字符集将name解码为字节序列并将结果存储新的字节数组中。
       // 然后使用GB2312字符集解码指定的字节数组
      // name = new String(name.getBytes("ISO-8859-1"),"GB2312");
       // 输出结果
     //  Str+=rs.getString("id") + "  " + name + "\t"+rs.getString("amount")  + "\t"+rs.getString("roundid")+"\n";
      System.out.println(data);
      Str+=data;
      }
      rs.close();
     // conn.close();
		}catch(SQLException e){
			System.out.println("cuowu !!");
		}
		return Str;
	}
}


