
public class SelectionSort extends DataSet {

	public void doSelection() {
		getData(0);
		sortName[1] = "Selection";
		sortTime[1][1] = selectionSort(reverseData1K, k);
		sortTime[1][3] = selectionSort(reverseData10K, kk);
		sortTime[1][5] = selectionSort(reverseData100K, kkk);

		for(int i = 0; i < 10; i++) {
			getData(1);
			sortTime[1][0] += selectionSort(randomData1K, k);
			sortTime[1][2] += selectionSort(randomData10K, kk);
			sortTime[1][4] += selectionSort(randomData100K, kkk);
		}
		sortTime[1][0] /= 10; sortTime[1][2] /= 10; sortTime[1][4] /= 10;

	}
	
	public double selectionSort(int data[], int n)
	{
		long startTime = System.currentTimeMillis();
		for ( int i = n -1 ; i > 1 ; i-- ) {
			for( int j = 0; j < i; j++){
				if( data[i] < data[j] ) 
					swap(data,i,j);
			}
		}
		long endTime = System.currentTimeMillis();

		return Double.parseDouble(String.format("%.5f",(endTime - startTime)/1000.0));
	}

}
