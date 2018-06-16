package com.ustrzycki.jhtp.TrafficLight;

import com.ustrzycki.domain.common.TrafficLight;

public class TrafficLight_8_10 {

	public static void main(String[] args) {

		for(TrafficLight light : TrafficLight.values() )
		{
			System.out.println(light.toString() + " duration: " + light.getDuration());
		}
		
		System.out.println(TrafficLight. valueOf("GREEN"));
		
		TrafficLight light;		

	}

}
