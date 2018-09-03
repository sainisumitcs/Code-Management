
public class SportsCar extends CarDecorator {

	public SportsCar(Car c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	public void assemble(){
		super.assemble();
		System.out.print(" Adding features of Sports Car.");
	}
}
