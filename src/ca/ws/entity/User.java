package ca.ws.entity;

public class User {
	
	private String id;
	private String name;
	private int age;
	private String sex;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}
	
	public User(String id, String name, int age, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}



	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	
}
