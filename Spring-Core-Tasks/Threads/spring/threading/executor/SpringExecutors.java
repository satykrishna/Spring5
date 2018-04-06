package spring.threading.executor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.core.task.support.TaskExecutorAdapter;
import org.springframework.scheduling.concurrent.ScheduledExecutorFactoryBean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class SpringExecutors {
	
	@Autowired
	private SimpleAsyncTaskExecutor asyncTaskExecutor;
	
	@Autowired
	private SyncTaskExecutor syncTaskExecutor;
	
	@Autowired
	private TaskExecutorAdapter taskExecutorAdapter;
	
	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	
	@Autowired
	private Runnable task;
	

	@PostConstruct
	
	public void submitJobs() {
//		syncTaskExecutor.execute(task);
//		asyncTaskExecutor.submit(task);
		taskExecutorAdapter.submit(task);
		for(int i = 0; i  < 10; i++)
			taskExecutorAdapter.submit(task);
//		
//		for(int i = 0; i < 500; i++)
//			threadPoolTaskExecutor.submit(task);
		
//	scheduledExecutorFactoryBean.getObject();
	}
}
