import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
public class ReadByBuffrAndWriteinFile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File f1=new File("d:/dhananjay/FileDemoHsbc/hsbc_file/two.txt");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//FileOutputStream out=new FileOutputStream(f1);
		//sirf f1 se old content delete hoke new overwrite hoga
		//but if we do f1,true then old data ke next space se hi writing gets appended
		FileOutputStream out=new FileOutputStream(f1,true);
		System.out.println("enter your data");
		String st=br.readLine();
		for(int i=0;i<st.length();i++) {
			out.write(st.charAt(i));
		}
		out.close();
		System.out.println("writing complete");

	}

}
