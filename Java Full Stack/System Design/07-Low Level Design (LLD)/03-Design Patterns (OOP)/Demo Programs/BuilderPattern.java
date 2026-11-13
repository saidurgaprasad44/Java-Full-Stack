package javaPrograms;

public class BuilderPattern {

	public static void main(String[] args) {
		Employe e = Employe.builder(101, "sai") //mandatory fields
				.salary(908983) //optional
				.department("developer") //optional
				.build();
		
		System.out.println(e);
	}

}


class Employe {
	
	private final int id;
	private final String name;
	
	private String department;
    private double salary;

    
    private Employe(Builder builder){
    	this.id = builder.id;
		this.name = builder.name;
		this.department = builder.department;
		this.salary = builder.salary;
    }
    
    public static Builder builder(int id, String name) {
    	
		return new Builder(id, name);
    	
    }
    
    @Override
    public String toString() {
    	return this.id + " " + this.name + " " + this.department + " " + this.salary;
    }
    
    public static class Builder{
    	private final int id;
    	private final String name;
    	
    	private String department;
        private double salary;
        
        Builder(int id, String name){
        	this.id=id;
        	this.name=name;
        }
        
        public Builder department(String department) {
        	this.department = department;
        	return this;
        }
        
        public Builder salary(double salary) {
        	this.salary = salary;
        	return this;
        }
        
        public Employe build() {
        	return new Employe(this);
        }
    }
}

