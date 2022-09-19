package com.victoree2.common;

//계정행위

public interface AccountInterface {
	abstract public void signUP(); //회원가입
	abstract public int login(); //로그인
	abstract public void delete(); //계정 삭제
	abstract public void resetPassword(); //패스워드 초기화
	abstract public void save(); //계정정보 저장
	abstract public void load(); //계정정보 로드
}
