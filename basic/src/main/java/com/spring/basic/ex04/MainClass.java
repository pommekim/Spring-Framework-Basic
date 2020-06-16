package com.spring.basic.ex04;

import java.util.Arrays;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
//		Printer printer = new Printer();
		
		//auto-config.xml파일을 생성해서
		//필요한 빈 객체를 등록한 후 의존성 주입을 통해서
		//MainClass에 있는 showPaperInfo()를 호출해 보세요.
		
		GenericXmlApplicationContext ct = 
				new GenericXmlApplicationContext("classpath:auto-config.xml");
		
		Printer printer = ct.getBean("printer", Printer.class);
		
		printer.showPaperInfo();
		
		System.out.println("==================================================");
		
		System.out.println("# 책 내용 확인");
		Book book = ct.getBean("book", Book.class);
		String datas = Arrays.toString(book.getPaper().data);
		System.out.println(datas);
		
		ct.close();
		
		
		
		

	}

}
