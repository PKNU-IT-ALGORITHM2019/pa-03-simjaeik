import java.util.Arrays;

public class JavaSort extends DataSet{

	public void doJava() {
		getData(0);
		sortName[8] = "Java";
		sortTime[8][1] = myJavaSort(reverseData1K);
		sortTime[8][3] = myJavaSort(reverseData10K);
		sortTime[8][5] = myJavaSort(reverseData100K);

		for(int i = 0; i < 10; i++) {
			getData(1);
			sortTime[8][0] += myJavaSort(randomData1K);
			sortTime[8][2] += myJavaSort(randomData10K);
			sortTime[8][4] += myJavaSort(randomData100K);
		}
		sortTime[8][0] /= 10; sortTime[8][2] /= 10; sortTime[8][4] /= 10;
	}

	public double myJavaSort(int [] data) {
		
		long startTime = System.currentTimeMillis();

		Arrays.sort(data);

		long endTime = System.currentTimeMillis();

		return Double.parseDouble(String.format("%.5f",(endTime - startTime)/1000.0));
	}
	
}
