import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 13458번 시험 감독 
틀린 이유 : 감독관 수가 감독해야 될 응시자 수 보다 많은 경우를 체크 하지 않음.
총감독관이 감독할 수 있는 총응시수를 빼고 추가적으로 필요한 부감독관 수가 있는 지 확인하는 로직이 필요.
*/
public class boj_13458 {
    
    static int N, B, C;
    static int[] A;
    static long answer;
    
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        B = Integer.parseInt(st.nextToken()); // 총감독관이 감시할 수 있는 응시자 수
        C = Integer.parseInt(st.nextToken()); // 부감독관이 감시할 수 있는 응시자 수(단, 부감독관은 여러명 가능)

        answer = 0;
        for (int i = 0; i < N; i++) {
            answer++; // 총감독관 수 추가
            A[i] -= B; // 총감독관이 감시 할 수 있는 응시자 수를 우선적으로 뺌

            if (A[i] > 0) {
                answer += A[i] / C; // 부감독관 수 추가
                if (A[i] % C != 0) answer++; // 감독해야 될 응시자수가 남아있다면 부감독관 수 추가

            }
        }

        System.out.println(answer);
    }
}
