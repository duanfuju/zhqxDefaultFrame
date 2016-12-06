/**
 * 
 */
package cn.com.oking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bstek.bdf2.importexcel.model.ExcelDataWrapper;
import com.bstek.bdf2.importexcel.model.RowWrapper;
import com.bstek.bdf2.importexcel.processor.IExcelProcessor;
import com.bstek.bdf2.importexcel.processor.impl.DefaultExcelProcessor;

/** 
* @ClassName: 	ExcelService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author:		Ctt http://weibo.com/u/3227366511  
* @date: 		2015-3-29 下午2:27:59  
* Company:		OKING 广东奥博信息产业有限公司  版权所有
* QQContact:    点击链接加入群【ITTeam】：http://jq.qq.com/?_wv=1027&k=WTydpC 
*/
@Service("bdf2.excelservice")
public class ExcelService  extends DefaultExcelProcessor implements IExcelProcessor {


	/* (non-Javadoc)
	 * @see com.bstek.bdf2.importexcel.processor.IExcelProcessor#execute(com.bstek.bdf2.importexcel.model.ExcelDataWrapper)
	 */
	@Override
	public int execute(ExcelDataWrapper arg0) throws Exception {
		List<RowWrapper>  tl = (List<RowWrapper>)arg0.getRowWrappers();
		tl.remove(0);

		
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.bstek.bdf2.importexcel.processor.IExcelProcessor#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}}
