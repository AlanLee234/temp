import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*   
Comparator:compare
Comparable:compareTo
*/

//构造树需要的结点类
class TreeNode {
    TreeNode left, right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class App {
    public static void main(String[] args) {    
        /*
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            String s = sc.nextLine();
            System.out.println(Integer.parseInt(s.substring(2,s.length()),16));
        }
        sc.close();
        */

        // testMath();
        // testArrays();
        testString();
        // testIO();   
    }

    public static int[][] inputMatrix(Scanner sc, int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    //先构建一个节点类，用于链表构建
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    // 常用包
    /*
    Math
    sqrt()//计算平方根
    cbrt()//计算立方根
    pow(a, b)//计算a的b次方
    max( , );//计算最大值
    min( , );//计算最小值
    abs(-10.4)
    ceil(-10.1)
    floor(-10.1)
    random()
    */
    private static void testMath(){
        double a = Math.sqrt(8.0);
        double b = Math.pow(a, 3);
        double c = Math.random();
        System.out.println(b);
    }

    /*
    Arrays
    fill()
    sort(T[] a, Comparator<? super T> c)
    equals()
    binarySearch()
    copyOfRange()
    */
    private static void testArrays(){       
        Integer[] nums = new Integer[]{3,5,1,6};
        Integer[] nums1 = new Integer[]{3,5,1,6};

        // Comparator:compare
        System.out.println(Arrays.equals(nums, nums1));//true
        System.out.println(nums.equals(nums1)); //false
        
        Arrays.sort(nums,new Comparator<Integer>(){//倒序
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        Arrays.sort(nums,(a,b)->a-b);
       
        System.out.println(Arrays.binarySearch(nums,1));// 数组必须是升序排列的

        Arrays.fill(nums,1);
        Integer[] nums2 = Arrays.copyOfRange(nums1,0,2);
        for(int i:nums2){
            System.out.print(i);
        }
    }

    // 常用类型
    /*
    Integer
    MAX_VALUE
    Integer.parseInt(String s, int radix）
    Integer.valueOf(String s)
    */

    /*
    String
    substring(int beginIndex, int endIndex)
    concat(String str)
    trim()
    Long.parseLong(String s)
    valueOf(char data[])
    toCharArray()
    split(String regex)

    Long.toBinaryString(long l) //10 to 2
    Long.toString(long l, int p)//p作为任意进制
    

    compareTo(String anotherString)
    equalsIgnoreCase(String anotherString)

    public int indexOf(int ch/String str)
    public int lastIndexOf(int ch/String str, int fromIndex)

    toLowerCase()
    toUpperCase()

    replace(char oldChar, char newChar)
    replaceFirst(String regex, String replacement)


    StringBuilder
    append()
    reverse()
    delete(int start,int end) 
     */
    private static void testString(){
        // int - String
        int a = Integer.valueOf("1");
        int b = Integer.valueOf("2").intValue();
        int c = Integer.parseInt("3");

        String s1 = ""+a;
        String s2 = String.valueOf(b);
        String s3 = Integer.toString(c);

        // String - char
        String str = "abc";   
        char[] kk = str.toCharArray();
        
        char[] cs = new char[]{'a','b'};
        String csx = cs.toString();//返回的是地址
        String cs1 = String.valueOf(cs);

        String cs2 =Character.toString('a');    
        String cs3 = String.valueOf('o');  
        // String cs4 = new Character('c').toString(); The constructor Character(char) is deprecated since version 9
        System.out.println("实际上char[]转String只有1种");
    }

    /*
    https://blog.csdn.net/yjlhz/article/details/115586630
    https://www.cnblogs.com/XBWer/archive/2012/06/24/2560532.html
    */
    private static void testIO() throws IOException{
        // Java IO
        // 回车结束，读取速度快
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);//需要转换

        //! 先读int，再读line，int后有回车
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(); 
        int b = in.nextInt();
        // String ab=in.nextLine();
        System.out.println(a+b);

        while(in.hasNextLine()){
            String s = in.nextLine();
            System.out.println("--"+s);
            // System.out.println(Integer.parseInt(s.substring(2,s.length()),16));
        }
        
        // 空格键，Tab键，Enter键结束
        Scanner sc = new Scanner(System.in);
        int a1; double b1; BigInteger c1; String d1;
        a1 = sc.nextInt(); 
        b1 = sc.nextDouble(); 
        c1 = sc.nextBigInteger(); 
        d1 = sc.nextLine(); // 每种类型都有相应的输入函数.
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            System.out.println(Integer.parseInt(s.substring(2,s.length()),16));
        }
    }

    /*
    List
        get(int index)
        add(int index, E element)
        remove(int index)
        set(int index, E element)
        addAll(int index, Collection<? extends E> c)

    Map 
        size()
        clear()
        containsKey()
    LinkedHashMap
        put(K key, V value)
        get(Object key) 
        remove(Object key)  
        containsValue(Object value) 

    Stack
        empty()	判断栈是否为空
        peek()	查看栈顶部的对象，但不从堆栈中移除它
        pop()	移除栈顶部的对象，并作为此函数的值返回该对象。
        push(Object obj)  把元素压入栈顶部
        search(Object obj) 返回对象在堆栈中的位置，从栈顶往下开始查找。      
    */
    
    /*
    Queue
    PriorityQueue
    add()异常、offer()
    element()、peek()
    remove()、poll()
    put、take 阻塞
    contain(Object o)
    isEmpty()
    */
    private static void testQueue(){
        // queue只能传入一种元素，或者自定义类，不去重
        PriorityQueue<Integer> queue =new PriorityQueue<Integer>();
        //? add 和offer交叉使用时，不排序
        queue.offer(2);
        queue.add(1);   
        queue.offer(1);
        // queue.offer(2);
        // queue.offer(3);
        queue.add(2);
        // queue.add(2);
        // queue.add(1);
        queue.add(3);
        System.out.println(queue.peek());
        // queue遍历的两种方式
        for(int i:queue){
            System.out.print(i);
        }
        Iterator<Integer> iterator=queue.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
        }
    }

    /*
    ？：问题
    ！：注意
    A1：方案
    */
    public static void template (){
        // init

        // 特殊情况处理：边界值

        // step1
        // aaa
        // step2
    }
}