//注释
import java.util.Scanner;

public class E1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = new int[101][2];
		int cntOFALL = 0;
		cntOFALL = readData(a);
		descData(a, cntOFALL);
		cntOFALL = delZeroRow(a,cntOFALL);
		outputData(a,cntOFALL);
	}
	public static void outputData(int[][] a, int cnt){
		String result = "";
		for ( int i = 0; i < cnt; i++){
			if( a[i][0] >= 2){
				if ( a[i][1] == 1 || a[i][1]== -1){
					if ( a[i][1] == 1){
					}
					else{
						result += "-";
					}
				}
				else{
					result += a[i][1];
				}
				result += "x" + a[i][0];
			}
			else if(a[i][0] == 1){
				if ( a[i][1] == 1 || a[i][1]== -1){
					if ( a[i][1] == 1){
					}
					else{
						result += "-";
					}
				}
				else{
					result += a[i][1];
				}
				result += "x";
			}
			else{
				if ( a[i][1] == 1 || a[i][1]== -1){
					if ( a[i][1] == 1){
						result += "1";
					}
					else{
						result += "-1";
					}
				}
				else{
					result += a[i][1];
				}
			}
			if( i != cnt -1 ){
				if( a[i + 1][1] > 0 ){
					result +="+";
				}
			}
		}
		if( result.equals("")){
			result = "0";
		}
		System.out.println(result);
	}
	public static int readData(int [][] dest1){
		Scanner in = new Scanner(System.in);
		int temp1=0,temp2,index;
		int cntOFALL = 0;
		int cntOFZero = 0;
		do{
			temp1 = in.nextInt();
			temp2 = in.nextInt();
			index = findData(dest1, temp1, cntOFALL);
			if ( index != -1){
				dest1[index][1] += temp2;
			}
			else{
				dest1[cntOFALL][0] = temp1;
				dest1[cntOFALL][1] = temp2;
				cntOFALL++;
			}
			if (temp1 == 0){
				cntOFZero++;
			}
		}while(cntOFZero <2);
		in.close();
		return cntOFALL;
	}
	public static int findData(int[][]a, int num, int cnt){
		int i = 0;
		int index = -1;
		for(i=0; i<cnt; i++){
			if ( a[i][0] == num){
				index = i;
				break;
			}
		}
		return index;
	}
	public static void descData(int [][]a, int cnt){
		for(int i=0; i<cnt; i++){
			for(int j = i + 1; j < cnt; j++){
				if (a[i][0] < a[j][0]){
					swapRow(a,i,j);
				}
			}
		}
		
	}
	public static void swapRow(int [][] a, int i, int j){
		int temp;
		temp = a[i][0];
		a[i][0] = a[j][0];
		a[j][0] = temp;
		temp = a[i][1];
		a[i][1] = a[j][1];
		a[j][1] = temp;
	}
	public static int delZeroRow(int[][] a, int cnt){
		for ( int i = 0; i < cnt; i++ ){
			if ( a[i][1] == 0){
				upShift(a,i,cnt);
				cnt--;
			}
		}
		return cnt;
	}
	public static void upShift(int[][] a, int index, int cnt){
		for ( int i = index + 1; i < cnt; i++){
			a[i - 1][0] = a[i][0];
			a[i - 1][1] = a[i][1];
		}
		a[cnt -1][0] = 0;
		a[cnt -1][1] = 0;
	}


}
