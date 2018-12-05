package wangZhe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class fileInput {
	/**
     * ��ȡfilePath���ļ������ļ��е����ݰ����ж�ȡ��String������.
     * @param filePath    �ļ���·��h
     * @return            �ļ���һ��һ�е�����
     */
	 public static ArrayList<String[]> readToString(String filePath)
	    {
	        File file = new File(filePath);
	        Long filelength = file.length(); // ��ȡ�ļ�����
	        byte[] filecontent = new byte[filelength.intValue()];
	        try
	        {
	            FileInputStream in = new FileInputStream(file);
	            in.read(filecontent);
	            in.close();
	        } catch (FileNotFoundException e)
	        {
	            e.printStackTrace();
	        } catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        
	        String[] fileContentArr = new String(filecontent).split("\r\n");
	        
	        ArrayList<String[]> fileTest= new ArrayList<String[]>();
	        for(int i=0;i<fileContentArr.length;i++) {
	        	String[] lineStr = new String(fileContentArr[i]).split(" ");
	        	fileTest.add(lineStr);
	        }
	        
	        //return fileContentArr;// �����ļ�����,Ĭ�ϱ���
	        return fileTest;
	    }
}
