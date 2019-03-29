
public class MergeSort extends DataSet {

	public void doMerge() {
		getData(0);
		sortName[3] = "Merge";
		sortTime[3][1] = mergeSort(reverseData1K, 0, k-1);
		sortTime[3][3] = mergeSort(reverseData10K, 0, kk-1);
		sortTime[3][5] = mergeSort(reverseData100K, 0, kkk-1);

		for(int i = 0; i < 10; i++) {
			getData(1);
			sortTime[3][0] += mergeSort(randomData1K, 0, k-1);
			sortTime[3][2] += mergeSort(randomData10K, 0, kk-1);
			sortTime[3][4] += mergeSort(randomData100K, 0, kkk-1);
		}
		sortTime[3][0] /= 10; sortTime[3][2] /= 10; sortTime[3][4] /= 10;

	}
	
	public double mergeSort(int data[], int begin, int end)
	{
		long startTime = System.currentTimeMillis();

		if( begin < end ) {
			int mid = ( begin + end )/2;
			mergeSort(data, begin, mid);
			mergeSort(data, mid+1, end);
			merge(data, begin, mid, end);
		}
		long endTime = System.currentTimeMillis();

		return (double)((endTime - startTime)/1000.0);
	}

	public void merge(int data[], int begin, int mid, int end)
	{
		int i = begin;
		int j = mid + 1;
		int n = begin;
		int [] tmp = new int [data.length];

		while(i <= mid && j <= end) {
			if(data[i] < data[j])
				tmp[n++] = data[i++];
			else
				tmp[n++] = data[j++];
		}
		while( i <= mid)
			tmp[n++] = data[i++];
		while( j <= end )
			tmp[n++] = data[j++];

		for(int num = begin; num < n ; num++) 
			data[num] = tmp[num];
	}
}
