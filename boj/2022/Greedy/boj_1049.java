package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* boj 1049번 기타줄 */
public class boj_1049 {

    static int brandMin = 1_001, pieceMin = 1_001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 끊어진 줄 개수
        int M = Integer.parseInt(st.nextToken()); // 기타줄 브랜드 개수

        while(M --> 0) {
            st = new StringTokenizer(br.readLine());

            int brand = Integer.parseInt(st.nextToken());
            int piece = Integer.parseInt(st.nextToken());

            brandMin = Math.min(brandMin, brand);
            pieceMin = Math.min(pieceMin, piece);
        }

        // 가장 싼 패키지 구매 vs 낱개 구매
        int verse1 = Math.min(brandMin * ((N / 6) + 1), pieceMin * N);

        // (가장 싼 패키지 구매 vs 낱개 구매) vs (패키지 구매 + 낱개 구매)
        int verse2 = Math.min(verse1, (brandMin * ((N / 6))) + (pieceMin * (N % 6)));

        System.out.println(verse2);
    }
}
