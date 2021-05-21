
public class SwitchExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//switch, case, default, break
		
		int value = 1;
		
		switch(value) {
		case 1:
			System.out.println("1");
			break;
		case 2:
			System.out.println("2");
			break;
		case 3:
			System.out.println("3");
			break;
		default :
			System.out.println("그 외 다른숫자");
		}
		
		String str = "A";
		
		switch(str){
        case "A": 
            System.out.println("1");
        case "B":
            System.out.println("2");
        case "C" :
            System.out.println("3");
        default :
            System.out.println("그 외의 숫자");
    }

		
	}

}
