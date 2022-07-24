import java.util.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Main {

    static String filePath = "C:\\Users\\AlanLee\\Desktop\\a";
    static String outputPath = "E:\\ok.txt";

    public static void main(String[] args) {
        readFilePath(filePath, outputPath);
    }

    public static void readFilePath(String filePath, String outputPath) {
        try {
            ArrayList<String> fileNameList = readFiles(filePath, new ArrayList<String>());
            System.out.println(fileNameList.size());
            for (int i = 0; i < fileNameList.size(); i++) {
                System.out.println(i + ": " + fileNameList.get(i));
                outputToTxt(i + ": " + fileNameList.get(i), outputPath);
                readAndWriteToOtherTxt(fileNameList.get(i),outputPath);
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

    public static void readAndWriteToOtherTxt(String pathName, String outputPath) {
        try {
            // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw

            /* 读入TXT文件 */
            File filename = new File(pathName); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            line = br.readLine();
            while (line != null) {
                outputToTxt(line, outputPath);
                line = br.readLine(); // 一次读入一行数据               
            }
            br.close();

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
        FileWriter fw = new FileWriter(outputPath, true);// 追加内容
        PrintWriter pw = new PrintWriter(fw);
        pw.println(content); // RsaUtil.encrypt(algorithm, "input", publicKey, 1024);
        pw.close();
        fw.close();
        pw.flush();
    }

    // 会覆盖
    public static void outputToTxt1(String str, String targetPath) {
        File file = new File(targetPath);
        BufferedWriter bwriter;
        if (str == null) {
            return;
        }
        try {
            bwriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
            bwriter.write(str);
            bwriter.flush();
            bwriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 不能换行
    public static void outputToTxt2(String content, String pathname) throws IOException {
        /* 写入Txt文件 */
        File writename = new File(pathname); // 相对路径，如果没有则要建立一个新的output。txt文件
        // writename.createNewFile(); // 创建新文件
        BufferedWriter out = new BufferedWriter(new FileWriter(writename, true));
        out.write(content); // \r\n即为换行
        out.flush(); // 把缓存区内容压入文件
        out.close(); // 最后记得关闭文件
    }

    public static String readFromTxt(String txtpath) {
        File file = new File(txtpath);
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while ((s = br.readLine()) != null) {
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}

