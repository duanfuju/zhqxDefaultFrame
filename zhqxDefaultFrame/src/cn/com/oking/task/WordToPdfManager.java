package cn.com.oking.task;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



public class WordToPdfManager implements ServletContextListener{
	public Timer timer;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		timer.cancel();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		WordToPdf task=new WordToPdf();
		timer = new Timer();
		//����˵��	
		//task - ��Ҫ���ŵ�����
		//delay - ִ������ǰ���ӳ�ʱ�䣬��λ�Ǻ��롣
		//period - ִ�и���������֮���ʱ��������λ�Ǻ��롣
		timer.schedule(task, 0, 1 * 60 * 1000);
	}
}
