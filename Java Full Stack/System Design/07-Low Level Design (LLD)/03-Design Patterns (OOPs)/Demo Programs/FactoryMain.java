package javaPrograms;

public class FactoryMain {

	public static void main(String[] args) {
		OperatingSystemFactory osf = new OperatingSystemFactory();
		OS os = osf.getInstance("open");
		os.spec();
	}

}

class OperatingSystemFactory{
	public OS getInstance(String str) {
		if (str.equals("open")) return new Android();
		else if (str.equals("closed")) return new Ios();
		else return new Windows();
	}
}

interface OS{
	public void spec();
}

class Android implements OS{

	@Override
	public void spec() {
		System.out.println("Most Powerful OS...");
		
	}
	
}

class Ios implements OS{

	@Override
	public void spec() {
		System.out.println("Most Secured OS...");
		
	}
	
}

class Windows implements OS{

	@Override
	public void spec() {
		System.out.println("I am about to die...");
		
	}
	
}