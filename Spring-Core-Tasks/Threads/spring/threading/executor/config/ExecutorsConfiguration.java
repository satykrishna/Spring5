package spring.threading.executor.config;

import java.util.Date;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.core.task.support.TaskExecutorAdapter;
import org.springframework.scheduling.concurrent.ScheduledExecutorFactoryBean;
import org.springframework.scheduling.concurrent.ScheduledExecutorTask;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@ComponentScan(basePackages = { "spring.threading.executor" })
public class ExecutorsConfiguration {

	@Bean
	public TaskExecutorAdapter taskExecutorAdapter() {
		return new TaskExecutorAdapter(Executors.newCachedThreadPool());
	}

	@Bean
	public SimpleAsyncTaskExecutor simpleAsyncTaskExecutor() {
		return new SimpleAsyncTaskExecutor();
	}

	@Bean
	public SyncTaskExecutor syncTaskExecutor() {
		return new SyncTaskExecutor();
	}

	@Bean
	public ScheduledExecutorTask scheduledExecutorTask1() {
		ScheduledExecutorTask scheduledExecutorTask = new ScheduledExecutorTask();
		scheduledExecutorTask.setPeriod(1000);
		scheduledExecutorTask.setRunnable(runnable());
		return scheduledExecutorTask;
	}
	
	@Bean
	public ScheduledExecutorTask scheduledExecutorTask2() {
		ScheduledExecutorTask scheduledExecutorTask = new ScheduledExecutorTask();
		scheduledExecutorTask.setPeriod(1000);
		scheduledExecutorTask.setRunnable(runnable());
		return scheduledExecutorTask;
	}

//	@Bean
	public ScheduledExecutorFactoryBean scheduledExecutorFactoryBean() {
		ScheduledExecutorFactoryBean scheduledExecutorFactoryBean = new ScheduledExecutorFactoryBean();
		scheduledExecutorFactoryBean.setScheduledExecutorTasks(scheduledExecutorTask1(), scheduledExecutorTask2());
		scheduledExecutorFactoryBean.setPoolSize(3);
		return scheduledExecutorFactoryBean;
	}

	@Bean
	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(50);
		taskExecutor.setMaxPoolSize(100);
		taskExecutor.setAllowCoreThreadTimeOut(true);
		taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
		return taskExecutor;
	}

	@Bean
	public Runnable runnable() {
		Runnable task = () -> {
			try {
				Thread.sleep(10 * 10);
				System.out.println("Done sleeping !!! ");
			}
			catch (Exception ex) {
				/* ... */ }
			System.out.println("Thread Name  " + Thread.currentThread().getName());
			System.out.printf("Hello at %s \n", new Date());
		};

		return task;
	}
}
