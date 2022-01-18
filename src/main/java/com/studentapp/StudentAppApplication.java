package com.studentapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class StudentAppApplication {
	
	@Value("${call.logs.timeFrameIn7Days}")
    private String timeFrameIn7Days;
	
//	@Value("${call.logs.timeFrameIn30Days}")
//    private int timeFrameIn30Days;
//	
//	@Value("${call.logs.timeFrameIn12Months}")
//    private int timeFrameIn12Months;

	public void timeFrameIn7Days() {
		System.out.println(timeFrameIn7Days);
		if (Integer.parseInt(timeFrameIn7Days) < 5) {
			System.out.println("No of calls = "+ timeFrameIn7Days +"  Color = Green");

		} else if (Integer.parseInt(timeFrameIn7Days) >= 5 && Integer.parseInt(timeFrameIn7Days) <= 10) {
			System.out.println("No of calls = "+ timeFrameIn7Days +"  Color = Amber");

		} else if (Integer.parseInt(timeFrameIn7Days) >= 11) {
			System.out.println("No of calls = "+ timeFrameIn7Days +"  Color = Red");

		} else {
			System.out.println("Invalid");
		}
	}

	public void timeFrameIn30Days() {
		int timeFrameIn30Days = 23;
		if (timeFrameIn30Days < 10) {
			System.out.println("No of calls = "+ timeFrameIn30Days +"  Color = Green");

		} else if (timeFrameIn30Days >= 10 && timeFrameIn30Days <= 25) {
			System.out.println("No of calls = "+ timeFrameIn30Days +"  Color = Amber");

		} else if (timeFrameIn30Days > 25) {
			System.out.println("No of calls = "+ timeFrameIn30Days +"  Color = Red");

		} else {
			System.out.println("Invalid");
		}
	}

	public void timeFrameIn12Months() {
		int timeFrameIn12Months = 73;
		if (timeFrameIn12Months <= 36) {
			System.out.println("No of calls = "+ timeFrameIn12Months +"  Color = Green");

		} else if (timeFrameIn12Months >= 37 && timeFrameIn12Months <= 72) {
			System.out.println("No of calls = "+ timeFrameIn12Months +"  Color = Amber");

		} else if (timeFrameIn12Months > 72) {
			System.out.println("No of calls = "+ timeFrameIn12Months +"  Color = Red");

		} else {
			System.out.println("Invalid");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentAppApplication.class, args);
		StudentAppApplication timeFrame = new StudentAppApplication();
			timeFrame.timeFrameIn7Days();
//			timeFrame.timeFrameIn30Days();
//			timeFrame.timeFrameIn12Months();
		}
}

