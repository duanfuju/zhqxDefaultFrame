/**
 * 
 */
package cn.com.oking.util;
 
/** 
* @ClassName: 	Hqls 
* @Description: TODO(������һ�仰��������������) 
* @author:		Ctt http://weibo.com/u/3227366511  
* @date: 		2014-12-16 ����9:54:54 
* Company:		OKING �㶫�²���Ϣ��ҵ���޹�˾  ��Ȩ���� 
*/
public class Hqls {
	

	public static String getHql(String table_name ,String state,String create_by,String state1,String dotask_by){
		StringBuffer sb = new StringBuffer();
		sb.append("  from "+table_name+"  where 1=1  ");
		//������
		if(create_by != null && !create_by.equals("") && dotask_by != null && !dotask_by.equals("")){
			sb.append("  and (create_by = '"+create_by+"'  ");
			sb.append("  or dotaskid = '"+dotask_by+"'  )");
		}else if(create_by != null && !create_by.equals("")){
			sb.append("  and create_by = '"+create_by+"'  ");
		}else if(dotask_by != null && !dotask_by.equals("")){
			sb.append("  and dotaskid = '"+dotask_by+"'  ");
		}
		if(state != null && !state.equals("") && state1 != null && !state1.equals("")){
			sb.append("  and (state = '"+state+"' or state = '"+state1+"')");
		}else if(state != null && !state.equals("")){
			sb.append("  and state = '"+state+"'  ");
		} 
		return sb.toString();
	}
	
}
