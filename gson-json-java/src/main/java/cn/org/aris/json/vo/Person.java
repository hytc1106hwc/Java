package cn.org.aris.json.vo;

public class Person {
	private String NAME;
	private String LOCATION;
	
	// GSON sets the fields directly using reflection.
	// so Getters and Setters are not required for this example
	
	@Override
	public String toString(){
		return NAME + " - " + LOCATION;
	}
}
