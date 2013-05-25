package com.zgm.zen.dip;

import com.zgm.zen.dip.jiekou.ICar;
import com.zgm.zen.dip.jiekou.IDriver;

public class Driver implements IDriver {
	public void drive(ICar car){
		car.run();
	}
}
