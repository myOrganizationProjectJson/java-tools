package key;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

public class snapshotUtil {
	
	  public static void main(String[] args) throws IOException, AWTException{
		  
		  Timer timer = new Timer();
		  Integer cacheTime = 10000 * 3;  
		    timer.schedule(new TimerTask() {
		      public void run() {
		    	  try {
		    		System.out.println("Task is run ");  
					snapshotUtil.snapshot();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
		    }, 1000,cacheTime);
		  
	  }
	
	public static void snapshot() throws IOException, AWTException {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    	GraphicsDevice[] gs = ge.getScreenDevices();
    	int i = 0;
    	SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd HH：mm：ss");//设置日期格式
    	
    	SimpleDateFormat dfdir = new SimpleDateFormat("yyyyMMdd");//设置日期格式
    	
    	SimpleDateFormat dfdirH = new SimpleDateFormat("HH");//设置日期格式
    	
    	String dir = "E:\\\\snapshot\\\\";
    	
    	String path = dir+dfdir.format(new Date())+"\\\\"+dfdirH.format(new Date());
    	if(!new File(path).exists())   {
    	    new File(path).mkdirs();
    	}
    	
    	
    	
    	for(GraphicsDevice curGs : gs){
            i++;
    		GraphicsConfiguration[] gc = curGs.getConfigurations();
    		Robot robot = null;
    		for(GraphicsConfiguration curGc : gc)
    		{
    			Rectangle bounds = curGc.getBounds();
    			ColorModel cm = curGc.getColorModel();
    			robot= new Robot();  
  	            BufferedImage img=robot.createScreenCapture(bounds);  
  	            if(img!=null&&img.getWidth()>1){  
  	                ImageIO.write(img, "png", new File(path+"\\snapshot["+i+"]-"+df.format(new Date())+".png"));
  	            }  
  	            
    			System.out.println("" + bounds.getX() + "," + bounds.getY() + " " + bounds.getWidth() + "x" + bounds.getHeight() + " " + cm);
    		}
    	}
		
	}
}
