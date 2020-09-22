import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class ReaderWriteByteDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File f=new File("d:/dhananjay/FileDemoHsbc/hsbc_file/one.txt");
		File f1=new File("d:/dhananjay/FileDemoHsbc/hsbc_file/two.txt");
		FileInputStream in=new FileInputStream(f);
		FileOutputStream out=new FileOutputStream(f1);
		
		int c=0;
		while(!((c=in.read())==-1)) {
			out.write(c);
		}
		out.close();
		in.close();
		System.out.println("writing completed");

	}

}
