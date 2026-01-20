package d0120;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_Test {

	public static void main(String[] args) {
		FileWriter fw = null;
		
		try {
			fw = new FileWriter("test.txt");
			fw.write("Hello Java!");
			fw.write("FileWriter 예제입니다.\n");
			fw.write("end..");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("파일 쓰기가 완료되었습니다.");
	}
}
