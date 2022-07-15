import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class App {
    static String filePath = "E:\\programDate\\git\\algorithm-diary\\temp\\src\\com\\alanlee\\leetcode";
    static String outputPath = "C:\\Users\\AlanLee\\Desktop\\fileNameList.txt";
    
    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(System.in);
        // while (sc.hasNextInt()) {
        //     // String s = sc.nextLine();
        //     int year = sc.nextInt();
        //     // System.out.println(Integer.parseInt(s.substring(2,s.length()),16));
        //     System.out.println(122 - year);
        // }
        // // System.out.println("Hello, World!");
        // sc.close();

        try {
            ArrayList<String> fileNameList = readFiles(filePath, new ArrayList<String>());
            System.out.println(fileNameList.size());
            for (int i = 0; i < fileNameList.size(); i++) {
                outputToTxt(fileNameList.get(i), outputPath);
                readAndWriteToOtherTxt(fileNameList.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    /**
     * 递归读取文件路径下的所有文件
     *
     * @param path
     * @param fileNameList
     * @return
     */
    public static ArrayList<String> readFiles(String path, ArrayList<String> fileNameList) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    readFiles(files[i].getPath(), fileNameList);
                } else {
                    String path1 = files[i].getPath();
                    // String fileName = path1.substring(path1.lastIndexOf("\\") + 1);
                    fileNameList.add(path1);
                }
            }
        } else {
            String path1 = file.getPath();
            // String fileName = path1.substring(path1.lastIndexOf("\\") + 1);
            fileNameList.add(path1);
        }
        return fileNameList;
    }
    
    public static void readAndWriteToOtherTxt(String pathname) {
        try { 
            // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw

        /* 读入TXT文件 */
            File filename = new File(pathname); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            line = br.readLine();
            while (line != null) {
                line = br.readLine(); // 一次读入一行数据      
                outputToTxt(line, outputPath);
            }
            
        /* 写入Txt文件 */
//        File writename = new File(".\\result\\en\\output.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
//        writename.createNewFile(); // 创建新文件
//        BufferedWriter out = new BufferedWriter(new FileWriter(writename));
//        out.write("我会写入文件啦\r\n"); // \r\n即为换行
//        out.flush(); // 把缓存区内容压入文件
//        out.close(); // 最后记得关闭文件

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将内容输出到（追加）txt文件保存
     *
     * @param content
     * @throws IOException
     */
    public static void outputToTxt(String content, String outputPath) throws IOException {
        FileWriter fw = new FileWriter(outputPath, true);//追加内容
        PrintWriter pw = new PrintWriter(fw);
        pw.println(content);
        pw.close();
        fw.close();
        pw.flush();
    }

}