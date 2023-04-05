package icehrm_automation.collection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ByteReadWrite {
	public static void main(String args[]) throws Throwable
	{
		String filepath="C:\\Users\\rsoni\\OneDrive\\Documents\\cyber2.txt";
		FileInputStream fis=new FileInputStream(filepath);
		int info;
		while((info=fis.read())!=-1)
		{
			System.out.print((char)info+"");
		}
		fis.close();
	}

}
