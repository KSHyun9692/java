package Secd;

public class InnerExam3 {
	public void exec() {
		class Cal{
	        int value = 0;
	        public void plus(){
	            value++;
	        }
	    }
		Cal cal = new Cal();
		cal.plus();
		System.out.println(cal.value);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InnerExam3 t = new InnerExam3();
        t.exec();

	}

}
