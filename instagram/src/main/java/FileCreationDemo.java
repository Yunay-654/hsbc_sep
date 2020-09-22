import java.io.File;
import java.io.IOException;
public class FileCreationDemo {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		File f=new File("d:/dhananjay/FileDemoHsbc/hsbc_file/one.txt");
         if(f.createNewFile()) {
        	 System.out.println("file created");
         }
         else {
        	 System.out.println("could not create file");
         }
	}

}
