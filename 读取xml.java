package projectT;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

;public class test {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		// TODO Auto-generated method stub
		
		
//		TestJaxb TestJaxb=new TestJaxb();
//		TestJaxb.XMLStringToBean();
		
		
//		
	long lasting =System.currentTimeMillis(); 
//		����try{ 
//			
//			
			
		File f=new File("C:\\Users\\Json\\Desktop\\test1.xml"); 
		
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder =factory.newDocumentBuilder(); 
		Document doc = builder.parse(f);
		
		NodeList nl = doc.getElementsByTagName("name"); 
	
		
		
		String test=doc.getElementsByTagName("name").item(0).getFirstChild().getNodeValue();
		
		String test1=doc.getElementsByTagName("string").item(0).getFirstChild().getNodeValue();
		
		
		
//		System.out.println(test);
//		System.out.println(test1);
//		
	//	System.exit(0);
		
		  info info =new info();
		
		  String [][] arr =new String [nl.getLength()/3][3];;
		  
	      int z=0;
		for (int i=0;i<nl.getLength();i=i+3){ 
			String PlayerId=doc.getElementsByTagName("name").item(i).getFirstChild().getNodeValue();
			String PlayerIdv=doc.getElementsByTagName("string").item(i).getFirstChild().getNodeValue();
			
			String Total_Stake_Accurate=doc.getElementsByTagName("name").item(i+1).getFirstChild().getNodeValue();
			String Total_Stake_Accuratev=doc.getElementsByTagName("string").item(i+1).getFirstChild().getNodeValue();
			
			String Total_PNL=doc.getElementsByTagName("name").item(i+2).getFirstChild().getNodeValue();
			String Total_PNLv=doc.getElementsByTagName("string").item(i+2).getFirstChild().getNodeValue();
			
//			System.out.println(PlayerIdv); 
//			System.out.println(Total_Stake_Accuratev); 
//			System.out.println(Total_PNLv); 
//			
			
			info.setPlayerId(PlayerIdv);
			info.setTotal_Stake_Accurate(Total_Stake_Accuratev);
			info.setTotal_PNL(Total_PNLv);
			
			
			arr[z][0]=PlayerIdv;
			arr[z][1]=Total_Stake_Accuratev;
			arr[z][2]=Total_PNLv;
			
			
		
            z++;
//		�� ��} 
//		����}catch(Exception e){ 
//		������e.printStackTrace(); 
//		} 
	}
		
		//System.out.println(arr[0]);
		
		 
		System.out.println(arr.length);
		
		 for(int x = 0; x< arr.length; x++){  //��λ��  
			 
	            for(int y = 0; y<arr[x].length; y++){  //��λÿ�е�Ԫ�ظ���  
	            	
	              System.out.print(arr[x][y]);  
	                
	                
	            }  
	        }  
		

		
		
////		
//		System.out.println(getInfo.get(1).getPlayerId());
//		System.out.println(getInfo.get(0).getTotal_Stake_Accurate());
//		
//		
//		  Iterator<info> iter = getInfo.iterator(); 
//		
		  
		  
//		  while(iter.hasNext())  
//	        {  
//	            iter.next();  
//	            
//	           System.out.println(iter.next().getPlayerId());  
//	        }  
//		  
//		
	
	
	
 	
}
		 public static void readXML() {
		  SAXReader sr = new SAXReader();// ��ȡ��ȡxml�Ķ���
		  try {
		   Document doc = sr.read("D:\\zend\\DDF-SVN\\trunk\\test1.xml");// �õ�xml����λ�á�Ȼ��ʼ��ȡ���������ݷ���doc��
		   Element el_root = doc.getRootElement();// ����ȡ���ݣ���ȡxml�ĸ��ڵ㡣
		   System.out.println("���ڵ㣺" + el_root.getName());
		   Iterator it = el_root.elementIterator();// �Ӹ��ڵ������α�������ȡ���ڵ��������ӽڵ�
		
		   while (it.hasNext()) {// �����ӽڵ�
		    Object o = it.next();
		    Element el_row = (Element) o;
		    String str = el_row.getText();
		    Iterator it_row = el_row.elementIterator();
		    while (it_row.hasNext()) {
		     Element el_ename = (Element) it_row.next();
		     System.out.println(el_ename.getName() + "="
		       + el_ename.getData());
		     
		    }
		   }
		  } catch (DocumentException e) {
		   e.printStackTrace();
		  }
		 }
	
	
	
}
	
	
