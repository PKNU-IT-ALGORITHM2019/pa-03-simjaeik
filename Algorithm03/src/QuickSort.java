
public class QuickSort extends DataSet{

	public void doQuick( ) {

		// quick1 : 맨 마지막 값을 pivot으로 하는 정렬
		getData(0);
		sortName[4] = "Quick1";
		sortTime[4][1] = quickSort(reverseData1K, 0, k-1);
		//		sortTime[4][3] = quickSort(reverseData10K, 0, kk-1);
		//		sortTime[4][5] = quickSort1(reverseData100K, 0, kkk-1);		//stackoverflow

		for(int i = 0; i < 10; i++) {
			getData(1);
			sortTime[4][0] += quickSort(randomData1K, 0, k-1);
			sortTime[4][2] += quickSort(randomData10K, 0, kk-1);
			//			sortTime[4][4] += quickSort1(randomData100K, 0, kkk-1);
		}
		sortTime[4][0] /= 10; sortTime[4][2] /= 10; sortTime[4][4] /= 10;

		//quick2 : 처음,중간,끝값의 중간값을 pivot으로 하는 정렬
		getData(0);		
		sortName[5] = "Quick2";
		sortTime[5][1] = quickSort2(reverseData1K, 0, k-1);
		sortTime[5][3] = quickSort(reverseData10K, 0, kk-1);
		//		sortTime[5][5] = quickSort(reverseData100K, 0, kkk-1, reverseData100K[getMiddle(reverseData100K, 0, (kkk-1)/2, kkk-1)]);		//stackoverflow

		for(int i = 0; i < 10; i++) {
			getData(1);
			sortTime[5][0] += quickSort(randomData1K, 0, k-1);
			sortTime[5][2] += quickSort(randomData10K, 0, kk-1);
			//						sortTime[5][4] += quickSort(randomData100K, 0, kkk-1);
		}
		sortTime[5][0] /= 10; sortTime[5][2] /= 10; sortTime[5][4] /= 10;

		//quick3 : 랜덤한 값을 pivot으로 하는 정렬
		getData(0);
		sortName[6] = "Quick3";
		sortTime[6][1] = quickSort(reverseData1K, 0, k-1);
		sortTime[6][3] = quickSort(reverseData10K, 0, kk-1);
		//		sortTime[6][5] = quickSort(reverseData100K, 0, kkk-1, reverseData100K[getRandom(kkk-1)]);		//stackoverflow

		for(int i = 0; i < 10; i++) {
			getData(1);
			sortTime[6][0] += quickSort(randomData1K, 0, k-1);
			sortTime[6][2] += quickSort(randomData10K, 0, kk-1);
			//			sortTime[6][4] += quickSort(randomData100K, 0, kkk-1, randomData100K[getRandom(kkk-1)]);
		}
		sortTime[6][0] /= 10; sortTime[6][2] /= 10; sortTime[6][4] /= 10;
	}

	public double quickSort(int data[], int begin, int end)	//pivot이 end
	{
		long startTime = System.currentTimeMillis();

		if( begin < end ) {
			int mid = partition(data, begin, end, end);
			quickSort(data, begin, mid-1);
			quickSort(data, mid + 1, end);
		}

		long endTime = System.currentTimeMillis();

		return (double)((endTime - startTime)/1000.0);
	}

	public double quickSort2(int data[], int begin, int end)	//pivot이 end
	{
		long startTime = System.currentTimeMillis();

		if( begin < end ) {
			int mid = partition(data, begin, end, getMiddle(data, 0, (end)/2, end));
			quickSort(data, begin, mid-1);
			quickSort(data, mid + 1, end);
		}

		long endTime = System.currentTimeMillis();

		return (double)((endTime - startTime)/1000.0);
	}

	public int partition(int[] data, int begin, int end, int pivot) {
		int i = begin - 1;
		int x = data[pivot];
		swap(data, end, pivot);

		for ( int j = begin; j <= end-1; j++) {
			if( data[j] <= x) {
				i++;
				swap(data, i, j);
			}
		}
		swap(data, i+1, end);
		return i+1;
	}

}
