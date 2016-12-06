package cs;

import java.util.ArrayList;
import java.util.List;

import com.jacob.com.ComThread;

import cn.com.oking.util.Document;
import cn.com.oking.util.GF_JacobUtil;

class person{
	private int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}


public class test {
	public static void main(String[] args) {
		
		Document doc;
		try {
			doc = new Document();
			doc.wordToPDF("f:\\加薪申请表.doc", "f:\\加薪申请表.pdf");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		String str="年终总结_段福举.docx";
		String  strs=str.substring(0,str.indexOf("."));
		System.out.println(strs);
		*/
		/*
		GF_JacobUtil doc=new GF_JacobUtil();
		doc.openWord(false);  
		doc.wordToPDF("f:\\加薪申请表.doc", "f:\\加薪申请表.pdf");
		doc.closeDocument();  
		doc.closeWord(); 
		*/
		
	}
}
