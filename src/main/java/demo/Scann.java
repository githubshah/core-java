package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.StringTokenizer;

public class Scann {

    public static void main(String args[]) throws Exception {
        for (int i = 1; i <= 100000; i++) {
            System.out.println(i);
        }
    }

    public static void main1(String args[]) throws Exception {

        long time = new Date().getTime();

        File file = new File("/Users/shaid/Documents/sf.txt");

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());


        int arr[] = new int[S];

//        for (int i = 0; i < T; i++) {
//            arr[sc.nextInt() - 1] = 1;
//        }

        long time1 = new Date().getTime();
        System.out.println(">>>" + (time1 - time));
        for (int i = 0; i < Q; i++) {
            //System.out.println(1 == arr[sc.nextInt() - 1] ? "N" : "Y");
        }
        System.out.println(new Date().getTime() - time1);
    }
}

