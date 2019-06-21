package baekJoon.Number2747;

import java.io.*;
class Main {
    
    public static int fibo(int num) {
        int res = 1; //1번째가지는 진행했다는 조건
        int prev = 0;
        int index = 1;
        while (num > index++) {
            int temp = res;
            res = res + prev;
            prev = temp;
        }
        return res;
    }
    
    public static void main(String[] args) throws IOException, NumberFormatException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int num = Integer.parseInt(br.readLine());
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
                bw.write(String.valueOf(fibo(num)));
            }
        }
    }
}
