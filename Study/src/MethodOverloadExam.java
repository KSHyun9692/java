
public class MethodOverloadExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClass2 m = new MyClass2();
		
		System.out.println(m.plus(4, 5));
		
		System.out.println(m.plus(4, 5, 7));
		
		System.out.println(m.plus("hello", "world"));

	}

}
