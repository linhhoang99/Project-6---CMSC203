import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {

	//for  order number, order time, order day and customer and a list of beverages within this order
	private int orderNum; 
	private DAY day;


	private int time;    
	private Customer person;
	private ArrayList<Beverage> list; 
	
	public int rand() {
		Random random = new Random();
		int num = random.nextInt(80001)+ 10000;  //range of 10000 and 90000
		return num;
	}
	
	public Order(int t, DAY d, Customer c) {
		time = t;
		day = d;
		person = c; 
		orderNum = rand();
		list = new ArrayList<Beverage>();
				
	}
	
	public Order() {
		time = 0;
		day = null;
		person = null;
		orderNum = rand();
		list = new ArrayList<Beverage>();
	}
	
	@Override
	public int compareTo(Order ord) {
		if (orderNum > ord.getOrderNo())
			return 1;      //thid Order > ord
		else if ( orderNum > ord.getOrderNo())
			return 0;		//thid Order = ord
		else
			return -1;      //thid Order = ord
	}

	@Override
	public boolean isWeekend() {
		if (day == DAY.SATURDAY || day == DAY.SUNDAY)
			return true;
		else
			return false;
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		
		return null;
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		//create a drink
		//add to list
		
		Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup); 
		list.add(coffee);
		
		
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size) {
		Alcohol al = new Alcohol(bevName, size, isWeekend());
		list.add(al);
		
	}

	@Override
	public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addPRotien) {
		Smoothie sm = new Smoothie(bevName,size, numOfFruits, addPRotien);
		list.add(sm);
		
	}

	@Override
	public double calcOrderTotal() {
		double sum = 0.0;
		
		for(Beverage obj: list) {
			sum += obj.calcPrice();
		}
		
		return sum;
	}

	@Override
	public int findNumOfBeveType(TYPE type) {
		int num = 0;
		
		for( Beverage obj: list) {
			if (obj.getType() == type)
				num +=1;
		}
		
		return num;
	}

	public DAY getOrderDay() {
		return day;
	}

	public int getOrderTime() {
		return time;
	}

	public Customer getCustomer() {
		return new Customer(person);
	}

	public void setDay(DAY day) {
		this.day = day;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setCustomerPerson(Customer person) {
		this.person = new Customer(person);
	}
	
	public int getOrderNo() {
	return orderNum;
	}
	
	
	public int getTotalItems() {
		return list.size();
	}

	
	

}
