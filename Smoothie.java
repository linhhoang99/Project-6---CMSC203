
public class Smoothie extends Beverage{
	
	private boolean protein; //$1.5
	private int fruit; 
	private final double A_FRUIT = 0.5;
	
	
	public Smoothie(String n, TYPE t, SIZE s) {
		super(n, t, s);
		
	}

	public Smoothie(String n, SIZE s, int f, boolean p) {
		this(n, TYPE.SMOOTHIE, s);
		fruit = f;
		protein = p; 
	}
	
	public Smoothie() {
		this("no name", SIZE.SMALL, 0, false);
	}
	
	public boolean getAddProtien() {
		return protein;
	}

	public int getNumOfFruits() {
		return fruit;
	}

	public void setAddProtein(boolean protein) {
		this.protein = protein;
	}

	public void setExtraFruit(int fruit) {
		this.fruit = fruit;
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
		
		if(protein)
			extra1 = 1.5;
		extra2 = A_FRUIT*fruit;
		
		return basePrice + up*sizeUp + extra1 + extra2; 
		
	}
	
	
	//String representation of a Smoothie drink including the name , size, whether or not protein is added , number of fruits and the price
	@Override
	public String toString() {
		String  s3 = "none";

		if(protein)
			s3 = "added";
		
		String c = String.format("Smoothie name: %s, size %s, %s extra protein, %d extra fruit. Total is $%f", name, size, s3, fruit , calcPrice() );
		return c;		
	}

	@Override
	public boolean equals(Beverage obj) {
		
		if(super.equals(obj))		
			if(protein==((Smoothie) obj).getAddProtien() && fruit==((Smoothie) obj).getNumOfFruits() )
				return true;
		return false;
	}
		
	
}
