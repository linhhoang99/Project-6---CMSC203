
public class Alcohol extends Beverage {
	private boolean weekend;
	private final double ADD = 0.6;  // addition per drink in the weekend
	
	
	public Alcohol(String n, TYPE t, SIZE s) {
		super(n, t, s);
		
	}
	
	public Alcohol(String n , SIZE s, boolean w) {
		this(n, TYPE.ALCOHOL, s);
		weekend = w;
	}
	
	public Alcohol() {
		this("no name", SIZE.SMALL, false);
	}
	
	public boolean isWeekend() {
		return weekend;
	}

	public void setWeekend(boolean weekend) {
		this.weekend = weekend;
	}
	
	public double calcPrice() {
		double extra = 0.0; 
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
		
		if(weekend)
			extra = 1;
		
		return basePrice + up*sizeUp + extra*ADD;
	}

	//String representation of a alcohol drink including the name,
	//size, whether or not beverage is offered in the weekend and the price.
	@Override
	public String toString() {
		String s = "empty", s3 = "is NOT";
		
		switch(size) {
		case SMALL:
			s = "small";
		case MEDIUM:
			s = "medium";
			break;
		case LARGE:
			s = "large";
			break;
		}
		
		if(weekend)
			s3 = "is";
		//
		String c = String.format("Alcohol name: %s, size %s, %s offered in the weeked. Total is $%f", name, size, s3, calcPrice() );
		return c;		
	}
	

	@Override
	public boolean equals(Beverage obj) {
		
		if(super.equals(obj))		
			if(weekend==((Alcohol) obj).isWeekend() )
				return true;
		return false;
	}

	
}
