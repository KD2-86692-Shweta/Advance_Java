package assign01;

public class Marks {

	public double marks;
	public String subject;
	
	
	
	public Marks() {
		
	}
	public Marks(String subject, double marks) {
		super();
		this.marks = marks;
		this.subject = subject;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
}
