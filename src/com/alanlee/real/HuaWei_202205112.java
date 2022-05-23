package com.alanlee.real;

import java.util.HashSet;
import java.util.Scanner;

public class HuaWei_202205112 {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int life =  sc.nextInt();
        int n =  sc.nextInt();
        int badNum =  sc.nextInt();
        HashSet<Integer> bad = new HashSet();
        // int[] bad = new int[badNum];
        for(int i=0;i<badNum;i++){
            // bad[i] = sc.nextInt();
            bad.add(sc.nextInt());
        }

        if(life==0){
            System.out.println(0);
            return;
        }
        if(n==1){
            System.out.println(3);
        }
        int now = 0;
        backTrack(life,n,bad,now);
        System.out.println(ans);
    }
    public static void backTrack(int life,int n,HashSet bad,int now) {
        if(life<=0||now > n+1){
            return;
        }
        if(now == n+1 && life>0){
            ans++;
            return;
        }
        for(int i=1;i<=3;i++){
            if(bad.contains(now+i)){
                life--;
            }
            backTrack(life, n, bad,now+i);
            if(bad.contains(now+i)){
                life++;
            }
        }
        return;
    }
}