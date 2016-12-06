package cs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
 
/**
 * file IO流读取并输出文件
 *
 */
public class FileIO {
    public static void main(String[] args) throws IOException {
 
        FileInputStream fis = new FileInputStream("f:\\正则.txt");// 要读的文件路径
 
        InputStreamReader isr = new InputStreamReader(fis);// 字符流
 
        BufferedReader br = new BufferedReader(isr); // 缓冲
        String line = null;
 
        while ((line = br.readLine()) != null) {// 字符不等于空
        	System.out.println(line);
        	line=line.replaceAll("0", "");
            System.out.println(line);// 一行一行地输出
        }
        br.close();// 关闭文件
    }
}
