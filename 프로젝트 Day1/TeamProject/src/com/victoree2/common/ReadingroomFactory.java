package com.victoree2.common;

import com.victoree2.user.SignupSystem;

// 클래스 집합

public class ReadingroomFactory extends returnmessage{
	public SignupSystem getUser() {
		return new SignupSystem();
	}
	public void createRoom(String type) {
		
	}
}
