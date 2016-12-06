package cn.com.oking.upload;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.h2.store.fs.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.com.oking.entity.SysFileInformation;
import cn.com.oking.service.FileInformationAction;
import cn.com.oking.util.ChangeImage;
import cn.com.oking.util.ConfigUtil;
import cn.com.oking.util.KeyUtil;
import cn.com.oking.util.StringUtil;

import com.bstek.dorado.uploader.DownloadFile;
import com.bstek.dorado.uploader.UploadFile;
import com.bstek.dorado.uploader.annotation.FileProvider;
import com.bstek.dorado.uploader.annotation.FileResolver;
import com.bstek.dorado.uploader.util.ParameterUtils;
import com.bstek.dorado.web.DoradoContext;

@Component
public class MyUploadProcessor {
	
	@Resource
	public FileInformationAction fileInformationAction;
	
	private String getDestPath() {
		return "D:\\upload\\oking\\project\\meteorologymanage";
	}
	
	@FileResolver
	@Transactional
	public Map<String, String> process1(UploadFile file,
			Map<String, Object> parameter) throws Exception {
		String fileid = (String) parameter.get("fileid");// ��ȡUploadAction��parameter��Ӧ�Ĳ���ֵ
		String type = (String) parameter.get("type");
		String pathType = (String) parameter.get("pathType");
		if(!StringUtil.isNotEmpty(fileid)){
			fileid = KeyUtil.getKeyBefore("FILE");
		}
		
		String oldName = file.getFileName();
		oldName = new String(oldName.getBytes("ISO8859-1"),"utf-8");
		
		String newName = getNewFileName(fileid,oldName);
		
		String savePath = getDestPath()+"\\"+pathType;
		File dir = new File(savePath);
		//�ж��ļ����Ƿ����,����������򴴽��ļ���
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File destFile = getDestFile(newName, new File(savePath));
		try {
			
			//�ж�showPath
			String showPath = ConfigUtil.getValue(type)+"\\"+pathType;
			if(pathType.equals("QXSCGL") || pathType.equals("QXSCGLICON")){
				showPath = ConfigUtil.getValue(type);
			}
			if(pathType.equals("QXSCGL")){
				ChangeImage.changeZdImg(file.getInputStream(), savePath+File.separator+newName);
				ChangeImage.getSmallImg(file.getInputStream(), savePath+File.separator+"small"+File.separator+newName);
			}else{
				file.transferTo(destFile);
			}
			
			
			//���浽���ݿ�,��֮ǰ���ļ�ɾ����
			SysFileInformation information = fileInformationAction.getInformationByAss(fileid);
			if(information == null){
				information = new SysFileInformation();
			}
			
			information.setAssociationId(fileid);
			information.setFileName(oldName);
			information.setShowPath(showPath);
			information.setSavaPath(savePath);
			information.setRealName(newName);
			information.setUpPeople("admin");
			information.setUpTime(new Date());
			information.setSort("1");
			
			fileInformationAction.saveInformateion(information);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, String> data = new HashMap<String, String>();
		data.put("fileName", oldName);
		data.put("absolutePath", destFile.getAbsolutePath());
		data.put("fileid", fileid);
		return data;
	}

	@SuppressWarnings("unused")
	@FileResolver
	public void process2(UploadFile file, Map<String, Object> parameter)
			throws Exception {
		String name = (String) parameter.get("name");// ��ȡUploadAction��parameter��Ӧ�Ĳ���ֵ
		System.out.println(getDestPath());
		File destFile = getDestFile(file.getFileName(), new File("C:\\dm"));
		try {
			file.transferTo(destFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private File getDestFile(String fileName, File folder) {

		File destFile;

		// ���ļ�������ֱ�ӷ���
		if (!new File(folder, fileName).exists()) {
			destFile = new File(folder, fileName);
		} else {
			new File(folder, fileName).delete();
			destFile = new File(folder, fileName);
//			int i = 1, lastDotPos = fileName.lastIndexOf("."), len = fileName
//					.length();
//
//			String prefix = null, suffix = null, destFileName;
//
//			// �ļ����в�����"."�������һλ��"."��ʱ��
//			if (lastDotPos == len - 1 || lastDotPos == -1) {
//				prefix = fileName;
//				suffix = "";
//			} else if (lastDotPos != -1) {
//				prefix = fileName.substring(0, lastDotPos);
//				suffix = fileName.substring(lastDotPos + 1);
//			}
//			do {
//				if (suffix.length() == 0) {
//					destFileName = String.format("%s_%d", prefix, i++);
//				} else {
//					destFileName = String.format("%s_%d.%s", prefix, i++,
//							suffix);
//				}
//				destFile = new File(folder, destFileName);
//			} while (destFile.exists());

		}

		FileUtils.createDirectory(destFile.getParent());

		return destFile;
	}

	private DownloadFile getDownloadFile(String fileName) throws IOException {
		String name = fileName;
		ParameterUtils.validateParameterCharacters(name);
		URL url = this.getClass().getResource(name);
		InputStream stream = url.openConnection().getInputStream();
		DownloadFile file = new DownloadFile(name, stream);
		if ("UploadAction.pdf".equals(name)) {
			file.setName("UpdateAction�û�ָ��.pdf");
			//����ļ�����ʱ,�������Ʊ�����,���Բο����д����Զ���ת�뷽ʽ,������DownloadFile��fileName����
			//file.setFileName(new String("UpdateAction�û�ָ��.pdf".getBytes("UTF-8"),"iso8859-1"));
		}
		return file;
	}

	@FileProvider
	public DownloadFile downloadInline(Map<String, String> parameter)
			throws IOException {
		String fileName = parameter.get("file");
		DownloadFile file = getDownloadFile(fileName);
		return file;
	}

	@FileProvider
	public DownloadFile download(Map<String, String> parameter)
			throws IOException {
		String fileName = parameter.get("file");
		DownloadFile file = getDownloadFile(fileName);
		return file;
	}
	
	@FileProvider
	public DownloadFile showImage(Map<String, String> parameter)
			throws IOException {
		String fileName = parameter.get("file");
		ParameterUtils.validateParameterCharacters(fileName);
		String realPath = DoradoContext.getCurrent().getRequest().getSession().getServletContext().getRealPath("\\");
		if (realPath.endsWith("\\")) realPath = realPath.substring(0, realPath.length()-1);
		realPath += "images"+File.separator+fileName;
		return new DownloadFile(new File(realPath));
	}

	
	private static String getNewFileName(String fileid,String fileName){
		String newName = "";
		int lastDotPos = fileName.lastIndexOf("."), len = fileName
				.length();
		String suffix = null;

		// �ļ����в�����"."�������һλ��"."��ʱ��
		if (lastDotPos == len - 1 || lastDotPos == -1) {
			suffix = "";
		} else if (lastDotPos != -1) {
			suffix = fileName.substring(lastDotPos + 1);
		}
		newName = fileid+"."+suffix;
		return newName;
	}
	
	
	
	public static void main(String[] args) {
		
		/*String s = ConfigUtil.getValue("imageShowpath");
		System.out.println(s);*/
		
		//FileUtils.createDirectory("D:\\mail\\doc");
		
	}
}
