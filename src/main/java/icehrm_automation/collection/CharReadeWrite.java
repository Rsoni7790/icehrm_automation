package icehrm_automation.collection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class CharReadeWrite {
	public static void main(String args[]) throws Throwable
	{
		FileReader fr=new FileReader("C:\\Users\\rsoni\\OneDrive\\Documents\\cyber2.txt");
		FileWriter fw=new FileWriter("C:\\Users\\rsoni\\OneDrive\\Documents\\success2.txt");
		int info;
		while((info=fr.read())!=-1)
		{
			System.out.print((char)info);
		   fw.write(info);
		}
		fr.close();
		fw.close();
	}
	

}
