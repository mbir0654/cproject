package business.model;


public class Grade {
	private int grade = 0;
	private Exam exam;
    private Student stud;
	
	/**
	 * Constructor de copiere
	 * 
	 * @param n este nota de copiat
	 */
	public Grade(Grade n){
		grade = n.grade;
		stud = n.stud;
	}
	
	/**
	 * Constructor parametrizat
	 * 
	 * @param n este nota propriu-zisa
	 * 
	 * @param s este studentul caruia i se acorda nota
	 * 
	 * @param s este examenul la care se acorad nota
	 */
	public Grade(int n, Student s, Exam e){
		grade = n;
		stud = s;
		exam = e;
	}
	
	/**
	 * 
	 * @param n va fi noua nota
	 */
	public void setGrade(int n){
		grade = n;
	}
	
	/**
	 * 
	 * @return valoarea notei
	 */
	public int getGrade(){
		return grade;
	}
	
	/**
	 * @param exam the exam to set
	 */
	public void setExam(Exam exam) {
		this.exam = exam;
	}

	/**
	 * @return the exam
	 */
	public Exam getExam() {
		return exam;
	}

    /**
    * 
    * @param stud va fi noul student asociat notei
    */
    public void setStud(Student stud) {
    	this.stud = stud;
	}

	/**
    *
    * @return studentul asociat notei
    */
    public Student getStud() {
    	return stud;
	}
    
    /**
     * @return un string continand cursul, tipul, studentul si nota
     */
    @Override
    public String toString() {
    	return stud+" "+grade;
    }
}
