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
        // ����������
        String driver = "com.mysql.jdbc.Driver";
        // URLָ��Ҫ���ʵ����ݿ���scutcs
        String url = "jdbc:mysql://10.1.0.226:3306/game";
        // MySQL����ʱ���û���
        String user = "root"; 
        // MySQL����ʱ������
        String password = "";
        try { 
         // ������������
         Class.forName(driver);
         // �������ݿ�
         Connection conn = DriverManager.getConnection(url, user, password);
         if(!conn.isClosed()) 
          System.out.println("Succeeded connecting to the Database!");
         return conn;
         // statement����ִ��SQL���
//         Statement statement = conn.createStatement();
//         return  statement;
//         // Ҫִ�е�SQL���
//         String sql = "select * from ceshi";
//         // �����
//         ResultSet rs = statement.executeQuery(sql);
//         System.out.println("-----------------");
//         System.out.println("ִ�н��������ʾ:");
//         System.out.println("-----------------");
//         System.out.println(" id" + "\t" + "    user_name" + "\t"+" amount" + "\t" + " roundid");
//         System.out.println("-----------------");
//         String name = null;
//         while(rs.next()) {
//          // ѡ��sname��������
//          name = rs.getString("user_name");
//          // ����ʹ��ISO-8859-1�ַ�����name����Ϊ�ֽ����в�������洢�µ��ֽ������С�
//          // Ȼ��ʹ��GB2312�ַ�������ָ�����ֽ�����
//         // name = new String(name.getBytes("ISO-8859-1"),"GB2312");
//          // ������
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
		
		  // Ҫִ�е�SQL���
     // String sql = "select * from ceshi";
      Statement statement = ((Connection) conn).createStatement();
      // �����
      ResultSet rs = statement.executeQuery(sql);
//      System.out.println("-----------------");
//      System.out.println("ִ�н��������ʾ:");
//      System.out.println("-----------------");
//      System.out.println(" id" + "\t" + "    user_name" + "\t"+" amount" + "\t" + " roundid");
//      System.out.println("-----------------");
     // ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
     // int colcount = rsmd.getColumnCount();
     
  
      ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
      int colcount1 = rsmd.getColumnCount();//ȡ��ȫ������
      Collection list=new HashSet();
      for(int i=1;i<=colcount1;i++){
         String colname = rsmd.getColumnName(i);//ȡ��ȫ������
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
//    	   String colname = rsmd.getColumnName(i);//ȡ��ȫ������
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
       // ѡ��sname��������
     //  name = rs.getString("username");
       // ����ʹ��ISO-8859-1�ַ�����name����Ϊ�ֽ����в�������洢�µ��ֽ������С�
       // Ȼ��ʹ��GB2312�ַ�������ָ�����ֽ�����
      // name = new String(name.getBytes("ISO-8859-1"),"GB2312");
       // ������
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


