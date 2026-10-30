package javaPrograms;

public class School {

	public static void main(String[] args) {
		AssignmentWork aw = new AssignmentWork();
		aw.setPen(new PenAdapter());
		aw.writeAssignment("Writing...");
	}
}

class AssignmentWork{
	private Pen p;
	public void setPen(Pen p) {
		this.p=p;
	}
	public void writeAssignment(String str) {
		System.out.println("Assignment Started");
		p.write(str);
		System.out.println("End of the assignment");
	}
}

interface Pen{
	public void write(String str);
}


class PenAdapter implements Pen{
	PilotPen pp = new PilotPen();
	public void write(String str) {
		pp.work(str);
	}
}

class PilotPen{
	public void work(String str) {
		System.out.println(str);
	}
}