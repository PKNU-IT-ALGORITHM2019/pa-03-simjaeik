
public class InsertionSort extends DataSet {

	public void doInsertion( ) {
		getData(0);
		sortName[2] = "Insertion";
		sortTime[2][1] = insertionSort(reverseData1K, k);
		sortTime[2][3] = insertionSort(reverseData10K, kk);
		sortTime[2][5] = insertionSort(reverseData100K, kkk);

		for(int i = 0; i < 10; i++) {
			getData(1);
			sortTime[2][0] += insertionSort(randomData1K, k);
			sortTime[2][2] += insertionSort(randomData10K, kk);
			sortTime[2][4] += insertionSort(randomData100K, kkk);
		}
		sortTime[2][0] /= 10; sortTime[2][2] /= 10; sortTime[2][4] /= 10;
	}
	
	public double insertionSort(int data[], int n)
	{
		long startTime = System.currentTimeMillis();

		for ( int i = 1; i < n ; i++) {
			int tmp = data[i];
			int j = i-1;

			while( j>=0 && tmp < data[j]) {
				data[j+1] = data[j];
				j--;
			}
			data[j+1] = tmp;
		}

		long endTime = System.currentTimeMillis();

		return Double.parseDouble(String.format("%.5f",(endTime - startTime)/1000.0));
	}

}
