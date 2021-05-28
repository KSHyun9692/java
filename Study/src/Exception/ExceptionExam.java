package Exception;

public class ExceptionExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int i = 10;
         int j = 0;
         
         //오류가 발생할 예상 부분을 try라는 블록으로 감싼 후, 발생할 오류와 관련된 Exception을 catch라는 블록에서 처리한다.
         //오류가 발생했든 안했든 무조건 실행되는 finally라는 블록을 가질 수 있다.
         
         try{
             int k = i / j;
             System.out.println(k);
         }catch(ArithmeticException e){
             System.out.println("0으로 나눌 수 없습니다. : " + e.toString());
         }finally {
             System.out.println("오류가 발생하든 안하든 무조건 실행되는 블록입니다.");
         }
        //finally블록은 생략가능하다.

	}

}
