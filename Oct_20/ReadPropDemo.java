package Oct_20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropDemo {

	public static void main(String[] args) 
	{

		try {
			FileInputStream fis = new FileInputStream(".\\src\\test\\java\\Oct_20\\stud.properties");
	Properties prop = new Properties();
	prop.load(fis);
	String id=prop.getProperty("Sid");
	System.out.println(id);
	
	System.out.println(prop.getProperty("name"));
	System.out.println(prop.getProperty("course"));
		} catch (IOException e) 
		{			
			e.printStackTrace();
		}
		

	}

}
