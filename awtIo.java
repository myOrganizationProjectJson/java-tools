package ceshi;

import java.awt.*;
import java.io.*;
import java.awt.event.*;
public class IOtest extends Frame implements ActionListener{
     private Frame f;
     private TextArea ta;   //ta������ʾ�򿪵�����
     private Button btn;
     private FileDialog fd;
     private File file1 = null;
     public static void main(String []args){
         IOtest iof = new IOtest();//��������ʼ��IOtest����iof
         iof.show();
    }
     //���캯����ʼ
      public IOtest(){
           btn = new Button("��");
           ta = new TextArea(5,50);
           btn.addActionListener(this);//����ť����¼�������
             }
             //����ť�����Ϊ
      public void actionPerformed(ActionEvent e){
          if (e.getSource()==btn) { //�����򿪰�ťʱ   
                fd = new FileDialog(f,"Open",FileDialog.LOAD);
                fd.setVisible(true);   //��������ʾ���ļ��Ի���
               
              //if ((fd.getDirectory()!=null) && (fd.getFile()!=null)) {
               
                try {   //�Ի�������ʽ��ȡ�ļ�����
               
                  file1 = new File(fd.getDirectory(),fd.getFile());
                    FileReader fr = new FileReader(file1);
                    BufferedReader br = new BufferedReader(fr);
                    String aline;
                    while ((aline=br.readLine()) != null)//���ж�ȡ�ı�
                    ta.append(aline+"\r\n");
                    fr.close();
                    br.close();
                  }
               catch (IOException ioe){
               
                  System.out.println(ioe);
                }
              }
           //}
             
      }
       public void show()
         {
            f = new Frame("�����ļ�����");         //��ʼ������f
            f.setSize(500,300);                //���ô���f�Ĵ�С
            //���ò��ֹ�����ΪFlowLayout
           f.setLayout(new FlowLayout(FlowLayout.LEFT,30,20));
           f.add(btn);   
           f.add(ta);               
           //Ϊ����f���WindowListener������
           f.addWindowListener(new WindowAdapter(){
                      public void windowClosing(WindowEvent evt){ //ʵ��windowClosing����
                        f.setVisible(false);         //���ô���f���ɼ�
                        f.dispose();            //�ͷŴ��ڼ������������Ļ��Դ
                        System.exit(0);            //�˳�����
                    }
                });
                f.setLocation(200,200);
        f.setVisible(true);                //���ô���f����
    }
}