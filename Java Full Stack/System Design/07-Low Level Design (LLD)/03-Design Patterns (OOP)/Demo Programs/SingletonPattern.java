package javaPrograms;

public class SingletonPattern{
		
	public static void main(String[] args) throws Exception{
		Employer s1 = Employer.getInstance();
		Employer s2 = Employer.getInstance();
			
		System.out.println(s1==s2); //true
	}
}

class Employer{
	private static final Employer INSTANCE = new Employer();

	private Employer() {}

	public static Employer getInstance() {
	    return INSTANCE;
	}
}
	


