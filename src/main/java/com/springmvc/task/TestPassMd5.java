package com.springmvc.task;

import org.springframework.stereotype.Component;


@Component("testPassMd5")
public class TestPassMd5 {
	
	public void testrun(){
		for(int index = 0;index < 10;index++){
			System.out.print(index+",");
		}
	}
}
