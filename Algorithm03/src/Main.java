
public class Main {

	public static int k =1000;
	public static int kk = 10000;
	public static int kkk = 100000;	

	public static int [] reverseData1K = new int [k];
	public static int [] reverseData10K = new int [kk];
	public static int [] reverseData100K = new int [kkk];
	public static int [] randomData1K = new int [k];
	public static int [] randomData10K = new int [kk];
	public static int [] randomData100K = new int [kkk];		//�������� �迭�� ����

	public static double [][] sortTime = new double[7][6];		// random1K, reverse1K, random10K, reverse10K ...
	public static String [] sortName = new String[7];

	public static void main(String[] args) {
		MySort goSort = new MySort();

		getFirstLine();		//ù�� ���

		doBubble(goSort);
		doSelection(goSort);
		doInsertion(goSort);
		doMerge(goSort);
		doQuick(goSort);

		handlePrint();
	}

	private static void handlePrint() {
		for(int i=0; i < 7; i++) {
			System.out.print(sortName[i]+" :  \t");
			for(int j=0; j < 6; j++) {
				System.out.printf(" %.5f ", sortTime[i][j]);
				System.out.print("\t ");
			}
			System.out.println(" ");
		}
	}

	private static void doBubble(MySort goSort) {
		getData(0);
		sortName[0] = "Bubble";
		sortTime[0][1] = goSort.bubbleSort(reverseData1K, k);
		sortTime[0][3] = goSort.bubbleSort(reverseData10K, kk);
		sortTime[0][5] = goSort.bubbleSort(reverseData100K, kkk);

		for(int i = 0; i < 10; i++) {
			getData(1);
			sortTime[0][0] += goSort.bubbleSort(randomData1K, k);
			sortTime[0][2] += goSort.bubbleSort(randomData10K, kk);
			sortTime[0][4] += goSort.bubbleSort(randomData100K, kkk);
		}
		sortTime[0][0] /= 10; sortTime[0][2] /= 10; sortTime[0][4] /= 10;
	}

	private static void doSelection(MySort goSort) {
		getData(0);
		sortName[1] = "Selection";
		sortTime[1][1] = goSort.selectionSort(reverseData1K, k);
		sortTime[1][3] = goSort.selectionSort(reverseData10K, kk);
		sortTime[1][5] = goSort.selectionSort(reverseData100K, kkk);

		for(int i = 0; i < 10; i++) {
			getData(1);
			sortTime[1][0] += goSort.selectionSort(randomData1K, k);
			sortTime[1][2] += goSort.selectionSort(randomData10K, kk);
			sortTime[1][4] += goSort.selectionSort(randomData100K, kkk);
		}
		sortTime[1][0] /= 10; sortTime[1][2] /= 10; sortTime[1][4] /= 10;

	}
	
	private static void doInsertion(MySort goSort) {
		getData(0);
		sortName[2] = "Insertion";
		sortTime[2][1] = goSort.insertionSort(reverseData1K, k);
		sortTime[2][3] = goSort.insertionSort(reverseData10K, kk);
		sortTime[2][5] = goSort.insertionSort(reverseData100K, kkk);

		for(int i = 0; i < 10; i++) {
			getData(1);
			sortTime[2][0] += goSort.insertionSort(randomData1K, k);
			sortTime[2][2] += goSort.insertionSort(randomData10K, kk);
			sortTime[2][4] += goSort.insertionSort(randomData100K, kkk);
		}
		sortTime[2][0] /= 10; sortTime[2][2] /= 10; sortTime[2][4] /= 10;
	}
	
	private static void doMerge(MySort goSort) {
		getData(0);
		sortName[3] = "Merge";
		sortTime[3][1] = goSort.mergeSort(reverseData1K, 0, k-1);
		sortTime[3][3] = goSort.mergeSort(reverseData10K, 0, kk-1);
		sortTime[3][5] = goSort.mergeSort(reverseData100K, 0, kkk-1);

		for(int i = 0; i < 10; i++) {
			getData(1);
			sortTime[3][0] += goSort.mergeSort(randomData1K, 0, k-1);
			sortTime[3][2] += goSort.mergeSort(randomData10K, 0, kk-1);
			sortTime[3][4] += goSort.mergeSort(randomData100K, 0, kkk-1);
		}
		sortTime[3][0] /= 10; sortTime[3][2] /= 10; sortTime[3][4] /= 10;

	}
	
	private static void doQuick(MySort goSort) {
		
		// quick1 : �� ������ ���� pivot���� �ϴ� ����
		getData(0);
		sortName[4] = "Quick1";
		sortTime[4][1] = goSort.quickSort1(reverseData1K, 0, k-1);
		sortTime[4][3] = goSort.quickSort1(reverseData10K, 0, kk-1);
//		sortTime[4][5] = goSort.quickSort1(reverseData100K, 0, kkk-1);		//stackoverflow

		for(int i = 0; i < 10; i++) {
			getData(1);
			sortTime[4][0] += goSort.quickSort1(randomData1K, 0, k-1);
			sortTime[4][2] += goSort.quickSort1(randomData10K, 0, kk-1);
//			sortTime[4][4] += goSort.quickSort1(randomData100K, 0, kkk-1);
		}
		sortTime[4][0] /= 10; sortTime[4][2] /= 10; sortTime[4][4] /= 10;

		//quick2 : ó��,�߰�,������ �߰����� pivot���� �ϴ� ����
		getData(0);
		sortName[5] = "Quick2";
		sortTime[5][1] = goSort.quickSort2(reverseData1K, 0, k-1);
		sortTime[5][3] = goSort.quickSort2(reverseData10K, 0, kk-1);
//		sortTime[5][5] = goSort.quickSort2(reverseData100K, 0, kkk-1);		//stackoverflow

		for(int i = 0; i < 10; i++) {
			getData(1);
			sortTime[5][0] += goSort.quickSort2(randomData1K, 0, k-1);
			sortTime[5][2] += goSort.quickSort2(randomData10K, 0, kk-1);
//			sortTime[5][4] += goSort.quickSort2(randomData100K, 0, kkk-1);
		}
		sortTime[5][0] /= 10; sortTime[5][2] /= 10; sortTime[5][4] /= 10;

		//quick3 : ������ ���� pivot���� �ϴ� ����
		getData(0);
		sortName[6] = "Quick3";
		sortTime[6][1] = goSort.quickSort3(reverseData1K, 0, k-1);
		sortTime[6][3] = goSort.quickSort3(reverseData10K, 0, kk-1);
//		sortTime[6][5] = goSort.quickSort3(reverseData100K, 0, kkk-1);		//stackoverflow

		for(int i = 0; i < 10; i++) {
			getData(1);
			sortTime[6][0] += goSort.quickSort3(randomData1K, 0, k-1);
			sortTime[6][2] += goSort.quickSort3(randomData10K, 0, kk-1);
//			sortTime[6][4] += goSort.quickSort3(randomData100K, 0, kkk-1);
		}
		sortTime[6][0] /= 10; sortTime[6][2] /= 10; sortTime[6][4] /= 10;

	}

	private static void getFirstLine() {
		System.out.println("\t\tRandom1000\tReverse1000\tRandom10000\tReverse10000\tRandom100000\tReverse100000\t");
	}

	private static void getData(int num) {				// ���� ������ �迭���� ���� �޾��ش�.
		// 0�� ������, 1�� �����Լ� �ʱ�ȭ.
		switch(num) {

		case 0 :
		{
			for(int i = 0 ; i < k ; i++) 
				reverseData1K[i] = ( k - i );

			for(int i = 0 ; i < kk ; i++) 
				reverseData10K[i] = ( kk - i );

			for(int i = 0 ; i < kkk ; i++) 
				reverseData100K[i] = ( kkk - i );		// ������ �迭�� �ʱ�ȭ
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
			System.out.println("�߸��� ���ڸ� �Է��Ͽ����ϴ�.");
			break;
		}
		}
	}
}