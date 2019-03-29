
public class Main {

	public static BubbleSort bubble = new BubbleSort();
	public static SelectionSort selection = new SelectionSort();
	public static InsertionSort insertion = new InsertionSort();
	public static MergeSort merge = new MergeSort();
	public static QuickSort quick = new QuickSort();
	
	// 각각의 클래스를 할당해준다.
	
	public static void main(String[] args) {
		getFirstLine();		//첫줄 출력
		
		bubble.doBubble();				// 각각의 정렬방법으로 6개의 데이터를 정렬시킴
		selection.doSelection();
		insertion.doInsertion();
		merge.doMerge();
		quick.doQuick();
		
		handlePrint();
	}

	private static void getFirstLine() {		// 첫째줄 출력
		System.out.println("\t\tRandom1000\tReverse1000\tRandom10000\tReverse10000\tRandom100000\tReverse100000\t");
	}
	
	private static void handlePrint() {		// 출력을 담당한다
		for(int i=0; i < 7; i++) {
			System.out.print(DataSet.sortName[i]+" :  \t");
			for(int j=0; j < 6; j++) {
				System.out.printf(" %.5f ", DataSet.sortTime[i][j]);
				System.out.print("\t ");
			}
			System.out.println(" ");
		}
	}
	
}