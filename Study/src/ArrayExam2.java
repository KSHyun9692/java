
public class ArrayExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = new int[3][4];
		array[0][1] = 10;
		
		int[][] array1 = new int[3][];
		array1[0] = new int[1];
		array1[0][0] = 10;
		
		int[][] array2 = {{1},{1,2},{1,2,3}};
		
		System.out.println(array2[0][0]);
		System.out.println(array2[2][2]);

	}

}
