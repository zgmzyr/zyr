package com.zgm.zen.dip;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;

import com.zgm.zen.dip.jiekou.ICar;
import com.zgm.zen.dip.jiekou.IDriver;


public class DriverTest {
	
	Mockery context = new JUnit4Mockery();
	
	@Test
	public void testDrive(){
		final ICar car = context.mock(ICar.class);
		
		IDriver zgm = new Driver();
		//
		context.checking(new Expectations(){{
				oneOf(car).run();
		}});
		
		
		zgm.drive(car);
	}
	
	public final int add(int x, int y){
		return x + y;
	}
}
