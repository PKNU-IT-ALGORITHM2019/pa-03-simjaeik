
public class HeapSort extends DataSet {

	public static int heapSize ;
	
	public void doHeap() {
		getData(0);
		sortName[7] = "Heap";
		sortTime[7][1] = heapSort(reverseData1K);
		sortTime[7][3] = heapSort(reverseData10K);
		sortTime[7][5] = heapSort(reverseData100K);

		for(int i = 0; i < 10; i++) {
			getData(1);
			sortTime[7][0] += heapSort(randomData1K);
			sortTime[7][2] += heapSort(randomData10K);
			sortTime[7][4] += heapSort(randomData100K);
		}
		sortTime[7][0] /= 10; sortTime[7][2] /= 10; sortTime[7][4] /= 10;
	}

	public double heapSort ( int [] data ) {

		long startTime = System.currentTimeMillis();

		buildMaxHeap(data);

		for(int i = heapSize - 1; i > 0 ; i-- ) {
			swap(data, 0, i);
			heapSize--;
			heapify(data, 0);
		}

		long endTime = System.currentTimeMillis();

		return Double.parseDouble(String.format("%.5f",(endTime - startTime)/1000.0));
	}

	public void buildMaxHeap( int [] data ) {
		for( int i = (heapSize/2) - 1 ; i >= 0 ; i--)
			heapify(data, i);
		heapSize = data.length;
	}

	public void heapify( int [] data, int mother ) {		//mother : heapify 하고싶은 인덱스 번호
		int bigChild = 0;				//index보다 큰 자식 힙
		
		while((2*mother)+1 <= heapSize-1){
			
			if((2*mother)+2 <= heapSize-1)
				bigChild = (data[(2*mother)+1] > data[(2*mother)+2] ? 2*mother+1 : (2*mother)+2 );
			else
				bigChild = 2*mother+1;
			
			if( data[mother] >= data[bigChild] )
				return;
			swap(data, mother, bigChild);
			mother = bigChild;
		}
	}
	
}

