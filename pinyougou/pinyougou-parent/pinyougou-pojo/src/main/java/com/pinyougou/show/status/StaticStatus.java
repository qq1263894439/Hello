package com.pinyougou.show.status;

public enum StaticStatus {
	authstr("待审核","0"),
	OK("通过","1"),
	NOTOK("未通过","2"),
	close("关闭","3");
	private String name;
	
	private String value;

	
	private StaticStatus(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
