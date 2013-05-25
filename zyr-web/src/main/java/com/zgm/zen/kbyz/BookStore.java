package com.zgm.zen.kbyz;

import java.text.NumberFormat;
import java.util.ArrayList;

public class BookStore {

	private final static ArrayList<IBook> bookList = new ArrayList<IBook>();
	
	static{
		bookList.add(new NovelBook("大唐双龙传", 10100));
		bookList.add(new NovelBook("寻秦记", 6722));
		bookList.add(new NovelBook("悲惨世界", 8822));
		
		bookList.add(new OffNovelBook("大唐双龙传", 10100));
		bookList.add(new OffNovelBook("寻秦记", 6722));
		bookList.add(new OffNovelBook("悲惨世界", 8822));
	}
	
	public static void main(String[] args){
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
		numberFormat.setMaximumFractionDigits(2);
		
		System.out.println("------------书店卖出去的已知记录如下如下:-----------------");
		
		for(IBook book : bookList){
			System.out.println("书籍名称： "  + book.getName() + "\t书籍价格：" +
					           numberFormat.format(book.getPrice() / 100.0) + "元");
		}
	}
}
