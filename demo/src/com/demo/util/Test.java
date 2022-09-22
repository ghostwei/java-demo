package com.demo.util;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author wei
 * Email: ghostwei@gmail.com
 * Project Name: java-demo
 * DateTime: 2022/9/20 14:32
 */
public class Test {

	public static void main(String[] args) {
		Map<String, String> params = new TreeMap<>();

		Scanner sc = new Scanner(System.in);

		System.out.println("input username:");
		params.put("username", sc.nextLine().trim());

		System.out.println("input password:");
		params.put("password", sc.nextLine().trim());




	}

}
