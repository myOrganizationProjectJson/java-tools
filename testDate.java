package projectT;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



	

public class testDate {
	
	public static void main(String[] args)  {
        
//		info infos = null;
//		infos=new info();
//		infos.setPlayerId("1100");
//		infos.setTotal_PNL("testss");
//		infos.setTotal_Stake_Accurate("gggggg");
//		
//		List<info> lists= new ArrayList<info>();
//		lists.add(infos);
//		for(info z:lists){
//			System.out.println(z.getPlayerId());
//		}
//		
//		Iterator<info> iter = lists.iterator();
//		  
//		 while(iter.hasNext())  
//         {  
//            System.out.println(iter.next().getPlayerId());  
//         }  
//		
//		  
//		  
//		  Map map = new HashMap();
//		  
//		  map.put("aaa","aaa");
//		  
//	    	System.out.println(map.get("aaa"));
//		
		//List<info> infolist=null;
		
        
		//((info) infolist).setTotal_PNL("111");
		
		
		
		
		
		
		
		
		
		
		//��ʽ��ʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Calendar cl = Calendar.getInstance();
		
		System.out.println(Calendar.MINUTE);
		
		cl.setTime(new Date());
		//ʱ��
		cl.set(Calendar.HOUR_OF_DAY, cl.get(Calendar.HOUR_OF_DAY) + (-12));
		
		//����
		cl.set(Calendar.MINUTE, (cl.get(Calendar.MINUTE) + 1));
		
		String endTime = sdf.format(cl.getTime());
		
		System.out.println(cl.getTime());
		//���÷��Ӽ�49
		cl.set(Calendar.MINUTE, cl.get(cl.MINUTE) - 49);
		String beginTime = sdf.format(cl.getTime());
		
		//ʱ���
		long createTime = cl.getTime().getTime() / 1000;
		
		System.out.println("createTime:"+createTime);
		System.out.println("beginTime:"+beginTime);
		System.out.println("endTime:"+endTime);
		
		
		
		
		
    }
	
	
	
	
	
	

}
