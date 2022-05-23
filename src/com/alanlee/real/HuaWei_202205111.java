package com.alanlee.real;

import java.util.HashMap;

public class HuaWei_202205111 {
    public static void main(String[] args) {

    }

}

/*
void SCAN(int *a, int n, int now)
{
    int flag=0,k=0;
    int start = now;
    int next[MAX], length[MAX];
    int b[MAX] = {0}; //替代a数组，否则下面的sort()会改变数组a
    for(int i=0;i<n;i++)
        b[i] = a[i];
    sort(b,b+n); //数组内部排序

    for(int i=0;i<n;i++)
    {
        if(b[i]>now)
        {
            flag = i;
            break;
        }
    }
    //往递增方向
    for(int i = flag; i<n;i++)
    {
        next[k] = b[i];
        length[k++] = abs(b[i] - now);
        now = b[i];
    }
    //返回往递减方向
    for(int i=flag-1;i>=0;i--)
    {
        next[k] = b[i];
        length[k++] = abs(b[i] - now);
        now = b[i];
    }

    for(int i=0;i<n;i++)
        cout<<next[i]<<" ";
}

main(){
    
}
void SSTF(int *a, int n, int now)
{
    
    int k = 0;
    int t = n;
    int start = now;
    int flag = 0; //最短路径下标
    int next[MAX], length[MAX], visit[MAX]={0};

    while(t--)
    {
        int min=999999; //最短路径
        for(int i=0;i<n;i++)
        {
            if(visit[i])
                continue;
            if(abs(a[i]-now)<min)
            {
                min = abs(a[i]-now);
                flag = i;
            }
        }
        length[k]=min;
        next[k++] = a[flag];
        visit[flag]=1;
        now = a[flag];
    }
    for(int i=0;i<n;i++)
       cout<<next[i]<<" ";
}

*/