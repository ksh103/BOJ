import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1476번 날짜 계산 */
public class boj_1476 {

	static int E, S, M, Ecnt, Scnt, Mcnt, result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		E = Integer.parseInt(st.nextToken()); // 지구 
		S = Integer.parseInt(st.nextToken()); // 태양
		M = Integer.parseInt(st.nextToken()); // 달
		
		Ecnt = Scnt = Mcnt = result = 1;
		
		while(true) {
			if(Ecnt > 15) Ecnt = 1;
			if(Scnt > 28) Scnt = 1;
			if(Mcnt > 19) Mcnt = 1;
			if(Ecnt == E && Scnt == S && Mcnt == M) break;
			
			Ecnt++; Scnt++; Mcnt++; result++;
			
		}
		System.out.println(result);
	}

}
