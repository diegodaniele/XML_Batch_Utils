package com.diego.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String areg[]) {


        ApplicationContext context = new ClassPathXmlApplicationContext("spring-batch-context.xml");

        JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
        Job job = (Job) context.getBean("xmlTodbJob");
        Job job2 = (Job) context.getBean("dbToxmlJob");
        Job job3 = (Job) context.getBean("txtToxmlJob");
        Job job4 = (Job) context.getBean("partitionJob");
        Job job5 = (Job) context.getBean("dbupdateJob");

        try {
            JobExecution execution = jobLauncher.run(job5, new JobParameters());
            System.out.println("Job5 Exit Status : " + execution.getStatus());

        } catch (JobExecutionException e) {
            System.out.println("Job5 failed");
            e.printStackTrace();
        }

        try {
            JobExecution execution = jobLauncher.run(job4, new JobParameters());
            System.out.println("Job4 Exit Status : " + execution.getStatus());

        } catch (JobExecutionException e) {
            System.out.println("Job4 failed");
            e.printStackTrace();
        }

        try {
            JobExecution execution = jobLauncher.run(job3, new JobParameters());
            System.out.println("Job3 Exit Status : " + execution.getStatus());

        } catch (JobExecutionException e) {
            System.out.println("Job3 failed");
            e.printStackTrace();
        }

        try {
            JobExecution execution = jobLauncher.run(job2, new JobParameters());
            System.out.println("Job2 Exit Status : " + execution.getStatus());

        } catch (JobExecutionException e) {
            System.out.println("Job2 failed");
            e.printStackTrace();
        }

        try {
            JobExecution execution = jobLauncher.run(job, new JobParameters());
            System.out.println("Job Exit Status : " + execution.getStatus());

        } catch (JobExecutionException e) {
            System.out.println("Job failed");
            e.printStackTrace();
        }
    }

}
