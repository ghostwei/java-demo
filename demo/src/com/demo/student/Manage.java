package com.demo.student;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author wei
 * Email: ghostwei@gmail.com
 * Project Name: java-demo
 * DateTime: 2022/9/20 14:12
 */
public class Manage {

	private static final int COLOR_RED = 31;
	private static final int COLOR_YELLOW = 32;
	private static final int COLOR_ORANGE = 33;
	private static final int COLOR_BLUE = 34;
	private static final int COLOR_PURPLE = 35;
	private static final int COLOR_GREEN = 36;

	private static final int TYPE_NONE = 0;
	private static final int TYPE_BOLD = 1;
	private static final int TYPE_ITALIC = 3;
	private static final int TYPE_UNDERLINE = 4;


	protected static void fetchItems(ArrayList<Item> items) {
		System.out.println($("编号\t\t学号\t\t年龄\t\t姓名\t\t地址", COLOR_ORANGE, TYPE_ITALIC));
		if(items.size() == 0) {
			System.out.println($("抱歉，系统中没有任何学生信息！", COLOR_RED, TYPE_NONE));
			return;
		}
		for(Item item: items) {
			System.out.println(item.toString());
		}
	}

	protected static void addItem(ArrayList<Item> items) {
		Scanner sc = new Scanner(System.in);
		Item item = new Item();

		String number = "";
		while(number.length() != 5 || !number.matches("^[\\d]{5}$")) {
			System.out.print("输入学生学号(5位数字)：");
			number = sc.nextLine().trim();
			boolean isNumberExist = false;
			for(Item item1: items) {
				if(item1.getNumber().equals(number)) {
					isNumberExist = true;
					break;
				}
			}
			if(isNumberExist == true) {
				number = "";
				System.out.println($("该学号已经存在！", COLOR_RED, TYPE_BOLD));
			}
		}
		item.setNumber(number);

		String age = "";
		while(!age.matches("^[1-9][\\d]?$")) {
			System.out.print("输入学生年龄(1-99)：");
			age = sc.nextLine().trim();
		}
		item.setAge(Integer.parseInt(age));

		String name = "";
		while(name.length() == 0 || name.length() > 20) {
			System.out.print("输入学生姓名：");
			name = sc.nextLine().trim();
		}
		item.setName(name);

		String address = "";
		while(address.length() == 0 || address.length() > 120) {
			System.out.print("输入学生地址：");
			address = sc.nextLine().trim();
		}
		item.setAddress(address);

		item.setId(items.size() + 1);

		items.add(item);
		System.out.println($("添加学生成功(学号：" + number + ")！", COLOR_GREEN, TYPE_BOLD));
	}

	protected static void deleteItem(ArrayList<Item> items) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("输入学生编号(退出请按\"0\")：");
			String number = sc.nextLine().trim();
			if(number.equals("0")) {
				break;
			}
			boolean isRemoved = false;
			for(Item item: items) {
				if(item.getNumber().equals(number)) {
					System.out.println($("删除学生成功(学号：" + item.getNumber() + ")！", COLOR_BLUE, TYPE_BOLD));
					items.remove(item);
					isRemoved = true;
					break;
				}
			}
			if(!isRemoved) {
				System.out.println($("该学号不存在！", COLOR_RED, TYPE_BOLD));
			}
		}
	}

	protected static void editItem(ArrayList<Item> items) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("输入学生编号(退出请按\"0\")：");
			String number = sc.nextLine().trim();
			if(number.equals("0")) {
				break;
			}

			boolean found = false;
			for(Item item: items) {
				if(item.getNumber().equals(number)) {
					found = true;

					String age = "";
					while(!age.matches("^[1-9][\\d]?$")) {
						System.out.print("输入学生年龄(1-99)：");
						age = sc.nextLine().trim();
					}
					item.setAge(Integer.parseInt(age));

					String name = "";
					while(name.length() == 0 || name.length() > 20) {
						System.out.print("输入学生姓名：");
						name = sc.nextLine().trim();
					}
					item.setName(name);

					String address = "";
					while(address.length() == 0 || address.length() > 120) {
						System.out.print("输入学生地址：");
						address = sc.nextLine().trim();
					}
					item.setAddress(address);
					System.out.println($("学生信息修改成功(学号：" + number + ")！", COLOR_GREEN, TYPE_BOLD));
					break;
				}
			}
			if(!found) {
				System.out.println($("该学号不存在！", COLOR_RED, TYPE_BOLD));
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Item> items = new ArrayList<Item>();
		Random random = new Random();
		for(int i = 1; i <= 9; i++) {
			items.add(new Item(i, random.nextInt(100) + 1, "0000" + i, "Name " + i, "Address " + i));
		}

		boolean end = false;
		while(!end) {
			System.out.println($("+++++++++++++++++++++++++++++++++++++", COLOR_YELLOW, TYPE_BOLD));
			System.out.println($("++++      欢迎来到学生管理系统      ++++", COLOR_YELLOW, TYPE_BOLD));
			System.out.println($("+++++++++++++++++++++++++++++++++++++", COLOR_YELLOW, TYPE_BOLD));
			System.out.println("1:查看所有学生");
			System.out.println("2:添加学生");
			System.out.println("3:删除学生");
			System.out.println("4:修改学生");
			System.out.println("0:退出");
			System.out.print("请输入你的选择：");

			Scanner sc = new Scanner(System.in);
			switch(sc.nextLine().trim()) {
				case "1":
					//查看所有学生
					fetchItems(items);
					break;
				case "2":
					//添加学生
					addItem(items);
					break;
				case "3":
					//删除学生
					deleteItem(items);
					break;
				case "4":
					//修改学生
					editItem(items);
					break;
				case "0":
					System.out.println("感谢您的使用，再见！！");
					end = true;
					break;
			}
			System.out.println("=====================================");
		}
	}

	protected static String $(String text, int color, int type) {
		boolean hasType = type != 1 && type != 3 && type != 4;
		if(hasType) {
			return String.format("\033[%dm%s\033[0m", color, text);
		} else {
			return String.format("\033[%d;%dm%s\033[0m", color, type, text);
		}
	}

}


