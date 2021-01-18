package com.zup.loteria.utils;

import java.util.Random;

public class RandomNumber {
	
	public static String getRandomNumber() {
		Random random = new Random();
	    return String.valueOf((random.nextInt(8) + 1) * 10000 + random.nextInt(10000));
	}
}
