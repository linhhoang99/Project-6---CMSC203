
public class Coffee extends Beverage{
	
	private boolean shot;
	private boolean syrup;
	
	
	public Coffee(String n, TYPE t, SIZE s) {
		super(n,t,s);

	}
	
	public Coffee(String n, SIZE s, boolean exShot, boolean exSyrup) {
		this(n, TYPE.COFFEE, s);
		shot = exShot;
		syrup = exSyrup;
	}
	
	public Coffee() {
		this("none", SIZE.SMALL, false, false);
		
	}

	@Override
	public double calcPrice() {
		double extra1 = 0, extra2= 0; 
		int up; 
		switch(size) {
			case MEDIUM:
				up = 1;
				break;
			case LARGE:
				up = 2;
				break;
			default:
				up = 0;
		}
		
		if(shot)
			extra1 = 0.5;
		if(syrup)
			extra2 = 0.5;
		
		return basePrice + up*sizeUp + extra1 + extra2 ; 
	}
	
	// String representation of Coffee beverage, including the name , size ,  whether it contains extra shot, extra syrup and the price of the coffee
	@Override
	public String toString() {
		String s2 = "empty", s3 = "empty", s4 = "empty";
		
		if(shot)
			s3 = "1";
		if(syrup)
			s4 = "1";
		
		switch(size) {
		case SMALL:
			s2 = "small";
		case MEDIUM:
			s2 = "medium";
			break;
		case LARGE:
			s2 = "large";
			break;
		}
		
		String c = String.format("Coffee name: %s, size %s, %s extra shot, %s extra syrup. Total is $%f", name, size, s3, s4, calcPrice() );
		return c;
	}
	
	
	public boolean getExtraShot() {
		return shot;
	}

	public boolean getExtraSyrup() {
		return syrup;
	}

	public void setExtraShot(boolean shot) {
		this.shot = shot;
	}

	public void setExtraSyrup(boolean syrup) {
		this.syrup = syrup;
	}

	@Override
	public boolean equals(Beverage obj) {
		
		if(super.equals(obj))		
			if(shot==((Coffee) obj).getExtraShot() && syrup==((Coffee) obj).getExtraSyrup() )
				return true;
		return false;
	}

}
