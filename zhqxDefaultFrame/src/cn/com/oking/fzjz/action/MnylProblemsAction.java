package cn.com.oking.fzjz.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.com.oking.fzjz.dao.MnylAnswerDao;
import cn.com.oking.fzjz.dao.MnylProblemsDao;
import cn.com.oking.fzjz.dao.MnylProblemsStandardLibraryDao;
import cn.com.oking.fzjz.dao.MnylResultrecordDao;
import cn.com.oking.fzjz.entity.MnylAnswer;
import cn.com.oking.fzjz.entity.MnylProblems;
import cn.com.oking.fzjz.entity.MnylProblemsStandardLibrary;
import cn.com.oking.fzjz.entity.MnylResultrecord;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

import com.bstek.bdf2.core.context.ContextHolder;
import com.bstek.dorado.annotation.DataProvider;
import com.bstek.dorado.annotation.DataResolver;
import com.bstek.dorado.data.provider.Page;

@Component
public class MnylProblemsAction {
	@Resource
	private MnylProblemsDao dao;//�����
	@Resource
	private MnylProblemsStandardLibraryDao sdao;//��׼��
	@Resource
	private MnylAnswerDao adao;//�𰸿�
	@Resource
	private MnylResultrecordDao rdao;//��¼��
	
	@DataProvider
	@Transactional
	public List<MnylProblems> findByWhere(String caselibraryId,String zhCase,String drillMode,String roleSelection,String dept){
		List<MnylProblemsStandardLibrary> slist=null;
		List<MnylProblems> list=null;
		String ylId=(String) ContextHolder.getRequest().getSession().getAttribute("yl_id");
		try {
			//������������׼���ѯ����
			if (!StringUtil.isNotEmpty(dept)) {
				slist = sdao.find("from MnylProblemsStandardLibrary " 
						+"where caselibraryId='"+caselibraryId
								+"' and zhCase='"+zhCase
								+"' and drillMode='"+drillMode
								+"' and roleSelection='"+roleSelection+"'");
			}else{
				slist = sdao.find("from MnylProblemsStandardLibrary " 
						+"where caselibraryId='"+caselibraryId
								+"' and zhCase='"+zhCase
								+"' and drillMode='"+drillMode
								+"' and roleSelection='"+roleSelection
								+"' and dept='"+dept+"'");
			}
			
			if (slist.size()>0) {
				//������ӱ�׼����copy���������
				for (int i = 0; i < slist.size(); i++) {
					MnylProblemsStandardLibrary s=slist.get(i);
					this.copyMnylProblems(s,ylId);
				}
				//������������ٲ�ѯ�����
				if (!StringUtil.isNotEmpty(dept)) {
					list = dao.find("from MnylProblems " +
							"where caselibraryId='"+caselibraryId
								+"' and zhCase='"+zhCase
								+"' and drillMode='"+drillMode
								+"' and roleSelection='"+roleSelection
								+"' and ylId='"+ylId+"'");
				}else{
					list = dao.find("from MnylProblems " +
							"where caselibraryId='"+caselibraryId
								+"' and zhCase='"+zhCase
								+"' and drillMode='"+drillMode
								+"' and roleSelection='"+roleSelection
								+"' and dept='"+dept
								+"' and ylId='"+ylId+"'");
				}
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	
	
	
	
	
	@DataProvider
	@Transactional
	public void copyMnylProblems(MnylProblemsStandardLibrary s,String ylId){
		//������ӱ�׼����copy���������
		MnylProblems p=new MnylProblems();
		String key=KeyUtil.getKey();
		p.setId(key);//������������Ҳ������������Ӧ�Ĵ�answerId
		p.setCaselibraryId(s.getCaselibraryId());
		p.setDept(s.getDept());
		p.setDrillMode(s.getDrillMode());
		p.setOpenTime(s.getOpenTime());
		p.setProblem(s.getProblem());
		p.setPtype(s.getPtype());
		p.setRoleSelection(s.getRoleSelection());
		p.setTitle(s.getTitle());
		p.setZhCase(s.getZhCase());
		p.setYlId(ylId);
		dao.save(p);
		//���𰸴Ӵ𰸿���copy����¼����
		copyMnylAnswer(key,s.getId());
	}
	@DataProvider
	@Transactional
	public void copyMnylAnswer(String key,String f_key){
		//���ݱ�׼��ı�Ž�����������Ĵ�ȡ��
		List<MnylAnswer> list=adao.find("from MnylAnswer where answerId='"+f_key+"'");
		//����copy����¼����
		for (int i = 0; i < list.size(); i++) {
			MnylAnswer a=list.get(i);
			MnylResultrecord r=new MnylResultrecord();
			r.setAnswerId(key);
			r.setOptionText(a.getOptionText());
			r.setOptionIstrue(a.getOptionIstrue());
			r.setOptionText(a.getOptionText());
			this.saveMnylResultrecord(r);
		}
	}
	@DataProvider
	@Transactional
	public void saveMnylResultrecord(MnylResultrecord entity){
		if (!StringUtil.isNotEmpty(entity.getId())) {
			entity.setId(KeyUtil.getKey());
		}
		rdao.save(entity);
	}
	
	
	
	@DataProvider
	@Transactional
	public List<MnylProblems> findByYlId(String ylId){
		List<MnylProblems> m=null;
		try {
			m = dao.find("from MnylProblems where ylId='"+ylId+"'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return m;
	}
	
	@DataProvider
	@Transactional
	public MnylProblems findById(String id){
		List<MnylProblems> m=null;
		try {
			m = dao.find("from MnylProblems where id='"+id+"'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return m.get(0);
	}
	
	@Transactional
	@DataProvider	
	public void getAll(Page<MnylProblems> page){
		dao.getAll(page);
	}
	
	@DataResolver
	@Transactional	
	public void saveAll(List<MnylProblems> problems){
		
		for(int i=0;i<problems.size();i++){
			MnylProblems pro = problems.get(i);
			if (!StringUtil.isNotEmpty(pro.getId())) {
				pro.setId(KeyUtil.getKey());
			}
		}		
		dao.persistEntities(problems);
	}
	
	@Transactional
	@DataProvider	
	public void findData(Page<MnylProblems> page,Map<String, Object> params){
		dao.find(page,"from MnylProblems where ylId='"+params.get("ylId")+"'");
	}
	
}
