
public class DataSet {				// 이번 과제의 모든 데이터를 총괄하는 클래스
	
	public static int k =1000;
	public static int kk = 10000;
	public static int kkk = 100000;	
	
	private static int sortNumber = 9;
	private static int dataNumber = 6;

	public static int [] reverseData1K = new int [k];
	public static int [] reverseData10K = new int [kk];
	public static int [] reverseData100K = new int [kkk];
	public static int [] randomData1K = new int [k];
	public static int [] randomData10K = new int [kk];
	public static int [] randomData100K = new int [kkk];
	
	public static String [] sortName = new String [sortNumber];
	public static double [][] sortTime = new double [sortNumber][dataNumber];
	
	public static void getData(int num) {				// 여섯 종류의 배열들의 값을 받아준다.
		// 0은 리버스, 1은 랜덤함수 초기화.
		switch(num) {

		case 0 :
		{
			for(int i = 0 ; i < k ; i++) 
				reverseData1K[i] = ( k - i );

			for(int i = 0 ; i < kk ; i++) 
				reverseData10K[i] = ( kk - i );

			for(int i = 0 ; i < kkk ; i++) 
				reverseData100K[i] = ( kkk - i );		// 리버스 배열값 초기화
			break;
		}
		case 1 :
		{
			for(int i = 0; i < k; i++)
				randomData1K[i] = (int)( Math.random() * k ) + 1;
			for(int i = 0 ; i < kk ; i++) 
				randomData10K[i] = (int)( Math.random() * kk ) + 1;
			for(int i = 0 ; i < kkk ; i++) 
				randomData100K[i] = (int)( Math.random() * kkk ) + 1;
			break;
		}
		default :
		{
			System.out.println("잘못된 숫자를 입력하였습니다.");
			break;
		}
		}
	}
	
	public int getMiddle(int data[], int begin, int mid, int end) {	//중앙값 받기 (for quick2)
		if( (data[begin]<=data[mid] && data[mid]<=data[end]) || (data[end]<=data[mid] && data[mid]<=data[begin]))
			return mid;
		else if( (data[mid]<=data[begin] && data[begin]<=data[end]) || (data[end]<=data[begin] && data[begin]<=data[mid]))
			return begin;
		else if( (data[begin]<=data[end] && data[end]<=data[mid]) || (data[mid]<=data[end] && data[end]<=data[begin]))
			return end;
		return 0;
	}

	public void swap(int[] data, int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}
	
	public int getRandom(int end) {		//랜덤한 값을 받는다 (for quick3)
		return (int)(Math.random()*end);
	}
	
}
