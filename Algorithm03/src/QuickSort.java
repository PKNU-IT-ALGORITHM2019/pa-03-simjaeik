
public class QuickSort extends DataSet{

	public void doQuick( ) {

		// quick1 : �� ������ ���� pivot���� �ϴ� ����
		getData(0);
		sortName[4] = "Quick1";
		sortTime[4][1] = quickSort(reverseData1K, 0, k-1, reverseData1K[k-1] );
		sortTime[4][3] = quickSort(reverseData10K, 0, kk-1, reverseData10K[k-1]);
		//		sortTime[4][5] = quickSort1(reverseData100K, 0, kkk-1, reverseData100K[k-1]);		//stackoverflow

		for(int i = 0; i < 10; i++) {
			getData(1);
			sortTime[4][0] += quickSort(randomData1K, 0, k-1, randomData1K[k-1]);
			sortTime[4][2] += quickSort(randomData10K, 0, kk-1, randomData10K[k-1]);
			//			sortTime[4][4] += quickSort1(randomData100K, 0, kkk-1, randomData100K[k-1]);
		}
		sortTime[4][0] /= 10; sortTime[4][2] /= 10; sortTime[4][4] /= 10;

		//quick2 : ó��,�߰�,������ �߰����� pivot���� �ϴ� ����
		getData(0);
		sortName[5] = "Quick2";
		sortTime[5][1] = quickSort(reverseData1K, 0, k-1, reverseData1K[getMiddle(reverseData1K, 0, (k-1)/2, k-1)]);
		sortTime[5][3] = quickSort(reverseData10K, 0, kk-1, reverseData10K[getMiddle(reverseData10K, 0, (k-1)/2, k-1)]);
		//		sortTime[5][5] = quickSort(reverseData100K, 0, kkk-1, reverseData100K[getMiddle(reverseData100K, 0, (k-1)/2, k-1)]);		//stackoverflow

		for(int i = 0; i < 10; i++) {
			getData(1);
			sortTime[5][0] += quickSort(randomData1K, 0, k-1, randomData1K[getMiddle(randomData1K, 0, (k-1)/2, k-1)]);
			sortTime[5][2] += quickSort(randomData10K, 0, kk-1, randomData10K[getMiddle(randomData10K, 0, (k-1)/2, k-1)]);
			//			sortTime[5][4] += quickSort(randomData100K, 0, kkk-1, randomData100K[getMiddle(randomData100K, 0, (k-1)/2, k-1)]);
		}
		sortTime[5][0] /= 10; sortTime[5][2] /= 10; sortTime[5][4] /= 10;

		//quick3 : ������ ���� pivot���� �ϴ� ����
		getData(0);
		sortName[6] = "Quick3";
		sortTime[6][1] = quickSort(reverseData1K, 0, k-1, reverseData1K[getRandom(k-1)]);
		sortTime[6][3] = quickSort(reverseData10K, 0, kk-1, reverseData10K[getRandom(k-1)]);
		//		sortTime[6][5] = quickSort(reverseData100K, 0, kkk-1, reverseData100K[getRandom(k-1)]);		//stackoverflow

		for(int i = 0; i < 10; i++) {
			getData(1);
			sortTime[6][0] += quickSort(randomData1K, 0, k-1, randomData1K[getRandom(k-1)]);
			sortTime[6][2] += quickSort(randomData10K, 0, kk-1, randomData10K[getRandom(k-1)]);
			//			sortTime[6][4] += quickSort(randomData100K, 0, kkk-1, randomData100K[getRandom(k-1)]);
		}
		sortTime[6][0] /= 10; sortTime[6][2] /= 10; sortTime[6][4] /= 10;
	}

	public double quickSort(int data[], int begin, int end, int pivot)	//pivot�� end
	{
		long startTime = System.currentTimeMillis();

		if( begin < end ) {
			int mid = partition(data, begin, end, pivot);
			quickSort(data, begin, mid-1, pivot);
			quickSort(data, mid + 1, end, pivot);
		}

		long endTime = System.currentTimeMillis();

		return (double)((endTime - startTime)/1000.0);
	}

	public int partition(int[] data, int begin, int end, int pivot) {
		int i = begin - 1;

		for ( int j = begin; j < end-1; j++) {
			if( data[j] <= pivot) {
				i++;
				swap(data, i, j);
			}
		}
		swap(data, i+1, end);
		return i+1;
	}

}