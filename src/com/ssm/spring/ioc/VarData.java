package com.ssm.spring.ioc;

public class VarData {
	String string_var;
	int int_var;
	short short_var;
	char char_var;
	long long_var;
	double double_var;
	boolean boolean_var;
	
	public void init(){
		System.out.println("在init()方法中打印string_var的值是:"+string_var);
		System.out.println("在init()方法中打印int_var的值是:"+int_var);
		System.out.println("在init()方法中打印short_var的值是:"+short_var);
		System.out.println("在init()方法中打印char_var的值是:"+char_var);
		System.out.println("在init()方法中打印long_var的值是:"+long_var);
		System.out.println("在init()方法中打印double_var的值是:"+double_var);
		System.out.println("在init()方法中打印boolean_var的值是:"+boolean_var);
	}
	public void printAll(){
		System.out.println("在printAll()方法中打印string_var的值是:"+string_var);
		System.out.println("在printAll()方法中打印int_var的值是:"+int_var);
		System.out.println("在printAll()方法中打印short_var的值是:"+short_var);
		System.out.println("在printAll()方法中打印char_var的值是:"+char_var);
		System.out.println("在printAll()方法中打印long_var的值是:"+long_var);
		System.out.println("在printAll()方法中打印double_var的值是:"+double_var);
		System.out.println("在printAll()方法中打印boolean_var的值是:"+boolean_var);
	}
	public String getString_var() {
		return string_var;
	}
	public void setString_var(String string_var) {
		this.string_var = string_var;
	}
	public int getInt_var() {
		return int_var;
	}
	public void setInt_var(int int_var) {
		this.int_var = int_var;
	}
	public short getShort_var() {
		return short_var;
	}
	public void setShort_var(short short_var) {
		this.short_var = short_var;
	}
	public char getChar_var() {
		return char_var;
	}
	public void setChar_var(char char_var) {
		this.char_var = char_var;
	}
	public long getLong_var() {
		return long_var;
	}
	public void setLong_var(long long_var) {
		this.long_var = long_var;
	}
	public double getDouble_var() {
		return double_var;
	}
	public void setDouble_var(double double_var) {
		this.double_var = double_var;
	}
	public boolean isBoolean_var() {
		return boolean_var;
	}
	public void setBoolean_var(boolean boolean_var) {
		this.boolean_var = boolean_var;
	}
}
