
public class Customer {
	private String name;
	private int age;
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Customer() {
		name = "no name";
		age  = 0;
	}
	
	/**
	 * copy constructor
	 * @param obj
	 */
	public Customer(Customer obj) {
	name = obj.getName();
	age = obj.getAge();
	}

	public String toString() {
		return String.format(" Name: %s, Age: %d", name, age);
	}
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
