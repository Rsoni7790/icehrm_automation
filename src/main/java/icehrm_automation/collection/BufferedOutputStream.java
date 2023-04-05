package icehrm_automation.collection;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class BufferedOutputStream {
	

	public static void main(String args[]) throws Throwable
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\rsoni\\OneDrive\\Documents\\cyber1.txt");
		BufferedInputStream bis=new BufferedInputStream(fis);
		FileOutputStream fos=new FileOutputStream("C:\\Users\\rsoni\\OneDrive\\Documents\\success1.txt");
		BufferedOutputStream bos=new BufferedOutputStream();
		  int info;
		  while((info=bis.read())!=-1)
		  {
			  System.out.print((char)info);
			  bos.write(info);
			  
		  }
		  fis.close();bis.close();fos.close();
		  bos.close();
		
	     }

	private void close() {
		// TODO Auto-generated method stub
		
	}

	private void write(int info) {
		// TODO Auto-generated method stub
		
	}

}
