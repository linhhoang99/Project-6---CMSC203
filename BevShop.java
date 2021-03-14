import java.util.*;
public class BevShop implements BevShopInterface {

	private ArrayList<Order> listOrd;
	private Order currentOrder; 
	@Override
	
	public boolean validTime(int time) {
		if(time >= 8 || time <=23)
			return true;
		
		return false;
	}
	
	public BevShop() {
		listOrd = new ArrayList<Order>();
	}

	@Override
	public boolean eligibleForMore() {
		// findNumOfBeveType(TYPE type)
		//MAX_ORDER_FOR_ALCOHOL
		
		if (currentOrder.findNumOfBeveType(TYPE.ALCOHOL) < MAX_ORDER_FOR_ALCOHOL)
			return true;
		
		return false;
	}

	@Override
	public boolean validAge(int age) {
		if ( age >= MIN_AGE_FOR_ALCOHOL)
			return true;
		
		return false;
	}

	@Override
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		currentOrder = new Order(time, day, new Customer(customerName, customerAge));
		listOrd.add(currentOrder);
	}

	@Override
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
		
	}

	@Override
	public void processAlcoholOrder(String bevName, SIZE size) {
		currentOrder.addNewBeverage(bevName,size);
		
	}

	@Override
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtien) {
		currentOrder.addNewBeverage( bevName, size, numOfFruits, addProtien);
		
	}

	@Override
	public int findOrder(int orderNo) {
		int index = -1;
		int count = 0;
		
		for(Order ord: listOrd) {
			if(ord.getOrderNo() == orderNo)
				return count;
			else
				count += 1;
		}
		return index; // means not found
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		int i = findOrder(orderNo);
		double total = listOrd.get(i).calcOrderTotal();
		
		return total;
	}

	@Override
	public double totalMonthlySale() {
		double total = 0.0;
		for( Order ord: listOrd) {
			total += ord.calcOrderTotal();
		}
		return total;
	}

	@Override
	public void sortOrders() {
		for(int j = 0 ; j <= listOrd.size() - 1; j++) {
			int minIndex = j; 
			
			for(int i = j + 1; i <= listOrd.size(); i++ ) {
				if(listOrd.get(minIndex).compareTo(listOrd.get(i)) == 1)   //if min Order > order at index i
				{
				int minOrderNum = listOrd.get(i).getOrderNo();
				minIndex = findOrder(minOrderNum);
				}
		
			}
			Order temp = listOrd.get(j);
			listOrd.set(j,listOrd.get(minIndex) );
			listOrd.set(minIndex, temp);
		}	
		
	}

	@Override
	public Order getOrderAtIndex(int index) {
		
		return listOrd.get(index);
	}
	
	
	//An Overridden toString method: The string representation of all the orders and the total monthly sale.  	
		public String toString() {
			
			String c = "This Order list has:\n";
			for (Order ord: listOrd) {
				c +=  ord.toString() + "\n";
			}
			
			c += "Total monthly sale:  " + totalMonthlySale();
			
			return c;
		}
	

	public int getNumOfAlcoholDrink() {
		int total = 0;           //findNumOfBeveType(TYPE type) 
		for (Order ord: listOrd) {
			total +=  ord.findNumOfBeveType(TYPE.ALCOHOL) ;
		}
		
		return total;
	}
	
	public Order getCurrentOrder() {
	return currentOrder;
	}
	
	public int totalNumOfMonthlyOrders() {
		return listOrd.size();
	}
	
	
	
	public boolean isMaxFruit(int num) {      //<= 5 is OK
		if(num <= MAX_FRUIT)
			return true;
		else
			return false;
	}


	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	public int getMinAgeForAlcohol() {
		
		return  MIN_AGE_FOR_ALCOHOL;
	}

	
	
	
	
	
	
}
