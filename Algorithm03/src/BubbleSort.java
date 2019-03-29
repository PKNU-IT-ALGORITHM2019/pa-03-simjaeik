
public class BubbleSort extends DataSet{

	public void doBubble() {
		getData(0);
		sortName[0] = "Bubble";
		sortTime[0][1] = bubbleSort(reverseData1K, k);
		sortTime[0][3] = bubbleSort(reverseData10K, kk);
		sortTime[0][5] = bubbleSort(reverseData100K, kkk);

		for(int i = 0; i < 10; i++) {
			getData(1);
			sortTime[0][0] += bubbleSort(randomData1K, k);
			sortTime[0][2] += bubbleSort(randomData10K, kk);
			sortTime[0][4] += bubbleSort(randomData100K, kkk);
		}
		sortTime[0][0] /= 10; sortTime[0][2] /= 10; sortTime[0][4] /= 10;
	}
	
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
}
