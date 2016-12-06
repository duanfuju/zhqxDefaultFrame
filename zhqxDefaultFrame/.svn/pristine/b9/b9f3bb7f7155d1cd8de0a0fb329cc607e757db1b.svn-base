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
		//参数说明	
		//task - 所要安排的任务。
		//delay - 执行任务前的延迟时间，单位是毫秒。
		//period - 执行各后续任务之间的时间间隔，单位是毫秒。
		timer.schedule(task, 0, 1 * 60 * 1000);
	}
}
