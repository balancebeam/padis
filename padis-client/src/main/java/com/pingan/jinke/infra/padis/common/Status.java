package com.pingan.jinke.infra.padis.common;

public enum Status {
	PRE_MIGRATE("pre_migrate","ԤǨ��"),
	OFFLINE("offline","����"),
	ONLINE("online","����"),
	MIGRATE("migrate","Ǩ��");
	
	private String name;
	private String text;
	
	Status(String name,String text){
		this.name = name;
		this.text = text;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getText(){
		return this.text;
	}
	
	public String toString(){
		return this.name;
	}
}
