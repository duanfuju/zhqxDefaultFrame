package cn.com.oking.util;

import java.util.ArrayList;
   
import cn.com.oking.util.Document;
  
  public class test
  {
	  public test(){
		  Document doc = null; 
		  try { 
			  doc = new Document(); 
			  doc.open("d:/czfa_jy.doc"); 
			  ArrayList tableData = new ArrayList(3); 
			  String[] title = { 
			  "部门", "防范应对"}; 
			  tableData.add(title); 
			  String[] field1 = { 
			 "751002", "北京天池创新软件技术有限公司自动化生产平台"}; 
			  tableData.add(field1); 
			  String[] field2 = { 
			 "751004", "产品数据管理系统"}; 
			  tableData.add(field2); 
			  
			  doc.insertAtBookmark("PO_table",tableData,"网格型"); 
			  
			  
			  doc.insertAtBookmark("PO_table_append",tableData,"网格型"); 
			  /*
			   * 第三个参数，需要自己到word文档中的选中表格，
			   * 然后在表格工具-->设计-->表格样式中选择
			   * 光标浮动在表格样式中时显示的文字就是这里的第三个参数
			  */
			  doc.saveAs("d:/czfa_jy_copy.doc");
		  } 
		  catch (Exception e) { 
			  e.printStackTrace(); 
		  } 
		  finally { 
			  try {
				doc.close(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  }
	  }

   
	  public static void main(String[]args)
	  {
		  /*test test1=new test();*/
		  
			Document doc=null;
			try {
				doc = new Document();
				doc.wordToPDF("F:\\年终总结_段福举.docx","F:\\年终总结_段福举.pdf");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	  }
}
