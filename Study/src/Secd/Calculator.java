package Secd;

public interface Calculator {
	public int plus(int i, int j);
    public int multiple(int i, int j);
    
    default int exec(int i, int j){      //default로 선언함으로 메소드를 구현할 수 있다.
        return i + j;
    }
    
    public static int exec2(int i, int j) {
    	return i * j;
    }

}
