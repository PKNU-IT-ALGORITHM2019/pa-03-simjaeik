
public class Main {

	public static BubbleSort bubble = new BubbleSort();
	public static SelectionSort selection = new SelectionSort();
	public static InsertionSort insertion = new InsertionSort();
	public static MergeSort merge = new MergeSort();
	public static QuickSort quick = new QuickSort();
	
	// ������ Ŭ������ �Ҵ����ش�.
	
	public static void main(String[] args) {
		getFirstLine();		//ù�� ���
		
		bubble.doBubble();				// ������ ���Ĺ������ 6���� �����͸� ���Ľ�Ŵ
		selection.doSelection();
		insertion.doInsertion();
		merge.doMerge();
		quick.doQuick();
		
		handlePrint();
	}

	private static void getFirstLine() {		// ù°�� ���
		System.out.println("\t\tRandom1000\tReverse1000\tRandom10000\tReverse10000\tRandom100000\tReverse100000\t");
	}
	
	private static void handlePrint() {		// ����� ����Ѵ�
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