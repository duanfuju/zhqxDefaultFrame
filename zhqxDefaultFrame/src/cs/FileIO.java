package cs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
 
/**
 * file IO����ȡ������ļ�
 *
 */
public class FileIO {
    public static void main(String[] args) throws IOException {
 
        FileInputStream fis = new FileInputStream("f:\\����.txt");// Ҫ�����ļ�·��
 
        InputStreamReader isr = new InputStreamReader(fis);// �ַ���
 
        BufferedReader br = new BufferedReader(isr); // ����
        String line = null;
 
        while ((line = br.readLine()) != null) {// �ַ������ڿ�
        	System.out.println(line);
        	line=line.replaceAll("0", "");
            System.out.println(line);// һ��һ�е����
        }
        br.close();// �ر��ļ�
    }
}
