package wangZhe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class fileInput {
	/**
     * 读取filePath的文件，将文件中的数据按照行读取到String数组中.
     * @param filePath    文件的路径h
     * @return            文件中一行一行的数据
     */
	 public static ArrayList<String[]> readToString(String filePath)
	    {
	        File file = new File(filePath);
	        Long filelength = file.length(); // 获取文件长度
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
	        
	        //return fileContentArr;// 返回文件内容,默认编码
	        return fileTest;
	    }
}
