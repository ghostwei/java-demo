package com.demo.test;
/**
 * @author wei
 * Email: ghostwei@gmail.com
 * Project Name: java-demo
 * DateTime: 2022/9/23 23:21
 */
public class Animal {

	static {
		System.out.println("发起提问");
	}

	public void question() {
		System.out.println("请问动物吃什么");
	}

	public void eat() {
		System.out.println("各个动物吃的东西都不同");
	}

}
