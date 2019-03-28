
public class MySort {

	public double bubbleSort(int data[], int n)
	{
		long startTime = System.currentTimeMillis();

		for( int i = n -1; i > 0 ; i --)
			for( int j = 0; j < i; j++)
				if(data[j] > data[j+1])
					swap(data,j,j+1);

		long endTime = System.currentTimeMillis();

		return Double.parseDouble(String.format("%.5f",(endTime - startTime)/1000.0));
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

	private int partition(int[] data, int begin, int end, int pivot) {
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

	public double quickSort1(int data[], int begin, int end)	//pivot이 end
	{
		long startTime = System.currentTimeMillis();

		if( begin < end ) {
			int mid = partition(data, begin, end, data[end]);
			quickSort1(data, begin, mid-1);
			quickSort1(data, mid + 1, end);
		}

		long endTime = System.currentTimeMillis();

		return (double)((endTime - startTime)/1000.0);
	}

	public double quickSort2(int data[], int begin, int end)	//pivot이 begin,mid,end의 중앙값 
	{
		long startTime = System.currentTimeMillis();

		if( begin < end ) {
			int mid = partition(data, begin, end, data[getMiddle(data,begin,(begin/end),end)]);
			quickSort1(data, begin, mid-1);
			quickSort1(data, mid + 1, end);
		}

		long endTime = System.currentTimeMillis();

		return (double)((endTime - startTime)/1000.0);
	}


	public double quickSort3(int data[], int begin, int end)	//pivot이 랜덤한 값
	{
		long startTime = System.currentTimeMillis();

		if( begin < end ) {
			int mid = partition(data, begin, end, data[getRandom(end)] );
			quickSort1(data, begin, mid-1);
			quickSort1(data, mid + 1, end);
		}

		long endTime = System.currentTimeMillis();

		return (double)((endTime - startTime)/1000.0);
	}
	
	private int getMiddle(int data[], int begin, int mid, int end) {	//중앙값 받기 (for quick2)
		if( (data[begin]<=data[mid] && data[mid]<=data[end]) || (data[end]<=data[mid] && data[mid]<=data[begin]))
			return mid;
		else if( (data[mid]<=data[begin] && data[begin]<=data[end]) || (data[end]<=data[begin] && data[begin]<=data[mid]))
			return begin;
		else if( (data[begin]<=data[end] && data[end]<=data[mid]) || (data[mid]<=data[end] && data[end]<=data[begin]))
			return end;
		return 0;
	}


	private int getRandom(int end) {		//랜덤한 값을 받는다 (for quick3)
		return (int)(Math.random()*end);
	}

	private void swap(int[] data, int i, int j) {
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

	public double heap()
	{
		// 미구현
		return 0;
	}

	public double libarary()
	{
		// 미구현
		return 0;
	}
}
