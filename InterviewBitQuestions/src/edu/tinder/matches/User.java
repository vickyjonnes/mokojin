package edu.tinder.matches;

public class User {
	private String name;
	private int age;
	private String sex;
	
	public User(String name, String sex, int age) {
		this.name=name;
		this.sex=sex.toLowerCase();
		this.age=age;
	}
	

	public String getName() {
		return name;
	}


	public int getAge() {
		return age;
	}


	public String getSex() {
		return sex;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User1 [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	
	
	
}
