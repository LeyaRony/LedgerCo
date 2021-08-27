import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputRead 
{
	public static void main(String[] args) 
	{
		InputRead re = new InputRead();
        String filePath = args[0];
        BufferedReader reader;
        try 
        {
        	reader = new BufferedReader(new FileReader(C:\Users\USER\Ledg\Ledg.txt));
            String line;
            while ((line = reader.readLine()) != null)
            {
            	re.handle(line);
            	}
            reader.close();
            }
        catch (IOException e) 
        {
        	e.printStackTrace();
        	}
        }
	}
}
