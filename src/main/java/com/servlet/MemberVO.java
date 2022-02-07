package com.servlet;

public class MemberVO {
	
	/* 
	 * 1. DB관련 컬럼을 은닉된 변수로 선언
	 * 2. getter, setter메서드를 선언합니다.
	 * 3. 생성자는 기본생성자와, 모든 멤버변수를 초기화 하는 생성자를 만듭니다.
	 */
	private String id;
	private String pw;
	private String name;
	private String region;
	private String gender;
	
	//기본생성자
	public MemberVO() {

	}
	
	//멤버변수를 초기화하는 생성자
	public MemberVO(String id, String pw, String name, String region, String gender) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.region = region;
		this.gender = gender;
	}

	//getter, setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
	

}
