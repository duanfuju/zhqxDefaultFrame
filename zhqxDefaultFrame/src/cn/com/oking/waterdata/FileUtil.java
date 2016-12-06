package cn.com.oking.waterdata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class FileUtil {

	public static String rainfilename="raindata.txt";
	public static String windfilename="winddata.txt";
	
	public static void contentToTxt(String fileName,String content) {
		File file0 = new File("D:/paddata");
		if (!file0.exists() && !file0.isDirectory()) {
			file0.mkdir();
		}
		try {
			File f = new File("D:/paddata/"+fileName);
			if (!f.exists()) {
				f.createNewFile();
			}
			BufferedWriter output = new BufferedWriter(new FileWriter(f));
			output.write(content);
			output.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static String readTxtFile(String fileName) {

		String result = "";
		try {
			String encoding = "GBK";
			File file = new File("D:/paddata/"+fileName);
			if (file.isFile() && file.exists()) { // �ж��ļ��Ƿ����
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// ���ǵ������ʽ
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					result += lineTxt;
				}
				read.close();
			} else {
				System.out.println("�Ҳ���ָ�����ļ�");
			}
		} catch (Exception e) {
			System.out.println("��ȡ�ļ����ݳ���");
			e.printStackTrace();
		}
		return result;
	}
}
