package org.yy.demo.task.module2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyJob {

	public void run() {
		System.out.println(" task is running...");
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				new String[] { "classpath:spring/applicationContext-task-module2.xml" });
	}
}
