
public abstract class Beverage {
//beverage name, beverage type, size, and constant attributes
//for the base price ($2.0) 
//and size price (additional $1 to go a size up).

public String name;
public TYPE type;
public SIZE size;
public final double basePrice = 2.0;
public final double sizeUp = 1.0;

public Beverage (String n , TYPE t, SIZE s) {
	name = n;
	type = t;
	size = s;
}
	

/**
 * calculates and returns the beverage price. 
 * @return beverage price
 */
abstract public double calcPrice();

/**
 * return String representation for Beverage including the name and size
 */
abstract public String toString();

/**
 * checks equality based on name, type, size of the beverage getters and setters 
 * and any other methods that are needed for your design
 * @param obj
 * @return true if two obj are the same 
 */
public boolean equals(Beverage obj) {
	if(name.equals(obj.getBevName()) && size==obj.getSize() && type==obj.getType())
		return true;
	else
		return false;
	
}


public double getBasePrice() {
	return basePrice;
}


public double getSizeUp() {
	return sizeUp;
}


public String getBevName() {
	return name;
}


public TYPE getType() {
	return type;
}


public SIZE getSize() {
	return size;
}


public void setName(String name) {
	this.name = name;
}


public void setType(TYPE type) {
	this.type = type;
}


public void setSize(SIZE size) {
	this.size = size;
} 

	
	
	
}
