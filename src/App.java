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
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class App {
    static String algorithm = "RSA";
    static String publicKeyString = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjiw4OdIv+pGV7kPjR/Rxm5L3k+1FPu3eGhoggJrdTS4ILPxJnz5ARWaAVxVjfUIIKMN9ieT7tFInl0hyiF/IHxzbP8a488YldbbBD1a7m1Ua0AdJolFxMwKr4Fsr8t+I+Hu/6/H2j4JiiSXxI2e0BU3LlDtSFSsjkNz7Q9DsQF/PtH3ZcDjkbhrv6Wrsr+KVGIHaOh4D+ERWFRfSPyEb2CE2NyLn4VKRFqO8eD70YWtCfkn4v2ZYtUzcQIBWWnDWWwHOJF1Kz/FPzHxR52P347RGiuDc0Fi0bUylmSQQZ9XvjEAQ8LY+6MNM5cXb3jf+YPQy7SCsne3ZpA58IXoNCwIDAQAB";

    static String filePath = "E:\\programDate\\git\\algorithm-diary\\JAVA\\src\\com\\alanlee\\basics\\structure";
    static String outputPath = "C:\\Users\\AlanLee\\Desktop\\ok.txt";
    static String okPath = "C:\\Users\\AlanLee\\Desktop\\ok1.txt";

    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(System.in);
        // while (sc.hasNextInt()) {
        // // String s = sc.nextLine();
        // int year = sc.nextInt();
        // // System.out.println(Integer.parseInt(s.substring(2,s.length()),16));
        // System.out.println(122 - year);
        // }
        // // System.out.println("Hello, World!");
        // sc.close();

        // runWithAES();
        // cancelAes();
        readFilePath(filePath, outputPath);
    }

    public static void readFilePath(String filePath, String outputPath) {
        try {
            ArrayList<String> fileNameList = readFiles(filePath, new ArrayList<String>());
            System.out.println(fileNameList.size());
            for (int i = 0; i < fileNameList.size(); i++) {
                outputToTxt(fileNameList.get(i), outputPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runWithAES() throws Exception {
        try {
            ArrayList<String> fileNameList = readFiles(filePath, new ArrayList<String>());
            System.out.println(fileNameList.size());
            for (int i = 0; i < fileNameList.size(); i++) {
                outputToTxt(AesUtil.encrypt("abcdefg" + i), outputPath);
                outputToTxt(AesUtil.encrypt(fileNameList.get(i)), outputPath);
                // readAndWriteToOtherTxt(fileNameList.get(i));

                // String content = readFromTxt(fileNameList.get(i));
                File filename = new File(fileNameList.get(i)); // 要读取以上路径的input。txt文件
                InputStreamReader reader = new InputStreamReader(new FileInputStream(filename), "utf-8"); // 建立一个输入流对象reader
                BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
                String line = "";
                line = br.readLine();
                while (line != null) {
                    line = br.readLine(); // 一次读入一行数据
                    if (line != null && !line.equals("") && line.length() != 0){
                        outputToTxt(AesUtil.encrypt(line), outputPath);
                    }               
                }
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ok");

    }

    public static void cancelAes() {
        try {
            // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw

            /* 读入TXT文件 */
            File filename = new File(outputPath); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename), "utf-8"); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            line = br.readLine();
            while (line != null) {
                line = br.readLine(); // 一次读入一行数据
                if (line != null && !line.equals("") && line.length() != 0){
                    outputToTxt(AesUtil.decrypt(line), okPath);
                }
                // outputToTxt(RsaUtil.decrypt("RSA", line, privateKey, 1024), outputPath);
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void runWithRSA() throws Exception {
        // String[] keyString = RsaUtil.generateKey(algorithm);
        // System.out.println("publicKeyString: " + keyString[0]);
        // System.out.println("privateKeyString: " + keyString[1]);

        PublicKey publicKey = RsaUtil.loadPublicKeyFromString(algorithm, publicKeyString);
        // String result = RsaUtil.encrypt(algorithm, "input", publicKey, 1024);

        try {
            ArrayList<String> fileNameList = readFiles(filePath, new ArrayList<String>());
            System.out.println(fileNameList.size());
            for (int i = 0; i < fileNameList.size(); i++) {
                outputToTxt(RsaUtil.encrypt(algorithm, fileNameList.get(i), publicKey, 1024), outputPath);
                // readAndWriteToOtherTxt(fileNameList.get(i));

                // String content = readFromTxt(fileNameList.get(i));
                File filename = new File(fileNameList.get(i)); // 要读取以上路径的input。txt文件
                InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader
                BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
                String line = "";
                line = br.readLine();
                while (line != null) {
                    line = br.readLine(); // 一次读入一行数据
                    if (line != null && !line.equals("") && line.length() != 0){
                        String result = RsaUtil.encrypt(algorithm, line, publicKey, 1024);
                        outputToTxt(result, outputPath);
                    }
                    
                }
                br.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       String privateKeyString = "";
        PrivateKey privateKey = RsaUtil.loadPrivateKeyFromString(algorithm, privateKeyString);
        readAndWriteToOtherTxt(outputPath, okPath, privateKey);

        System.out.println("ok");

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

    public static void readAndWriteToOtherTxt(String pathname, String outputPath, PrivateKey privateKey) {
        try {
            // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw

            /* 读入TXT文件 */
            File filename = new File(pathname); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            line = br.readLine();
            while (line != null) {
                line = br.readLine(); // 一次读入一行数据
                if (line != null && !line.equals("") && line.length() != 0){
                    outputToTxt(RsaUtil.decrypt("RSA", line, privateKey, 1024), outputPath);
                }
                // outputToTxt(RsaUtil.decrypt("RSA", line, privateKey, 1024), outputPath);
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


class AesUtil {
 
    public static final String algorithm = "AES";
    // AES/CBC/NOPaddin
    // AES 默认模式
    // 使用CBC模式, 在初始化Cipher对象时, 需要增加参数, 初始化向量IV : IvParameterSpec iv = new
    // IvParameterSpec(key.getBytes());
    // NOPadding: 使用NOPadding模式时, 原文长度必须是8byte的整数倍
    public static final String transformation = "AES/CBC/PKCS5Padding";
    public static final String key = "0123456789123456";
 
    /***
     * 加密
     * @param original 需要加密的参数（注意必须是16位）
     * @return
     * @throws Exception
     */
    public static String encrypt(String original) throws Exception {
        // 获取Cipher
        Cipher cipher = Cipher.getInstance(transformation);
        // 生成密钥
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), algorithm);
        // 指定模式(加密)和密钥
        // 创建初始化向量
        IvParameterSpec iv = new IvParameterSpec(key.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
        // cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        // 加密
        byte[] bytes = cipher.doFinal(original.getBytes());
        return Base64.getEncoder().encodeToString(bytes);
    }
 
    /**
     * 解密
     * @param encrypted 需要解密的参数
     * @return
     * @throws Exception
     */
    public static String decrypt(String encrypted) throws Exception {
        // 获取Cipher
        Cipher cipher = Cipher.getInstance(transformation);
        // 生成密钥
        SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), algorithm);
        // 指定模式(解密)和密钥
        // 创建初始化向量
        IvParameterSpec iv = new IvParameterSpec(key.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
        // cipher.init(Cipher.DECRYPT_MODE, keySpec);
        // 解密
        byte[] bytes = cipher.doFinal(Base64.getDecoder().decode(encrypted));
 
        return new String(bytes);
    }
 
}

class RsaUtil {

    /**
     * 生成密钥对并保存在本地文件中
     *
     * @param algorithm : 算法
     * @param pubPath   : 公钥保存路径
     * @param priPath   : 私钥保存路径
     * @throws Exception
     */
    public static String[] generateKey(String algorithm) throws Exception {
        String[] keyStrings = new String[2];
        // 获取密钥对生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        // 获取密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 获取公钥
        PublicKey publicKey = keyPair.getPublic();
        // 获取私钥
        PrivateKey privateKey = keyPair.getPrivate();
        // 获取byte数组
        byte[] publicKeyEncoded = publicKey.getEncoded();
        byte[] privateKeyEncoded = privateKey.getEncoded();
        // 进行Base64编码
        String publicKeyString = Base64.getEncoder().encodeToString(publicKeyEncoded);
        String privateKeyString = Base64.getEncoder().encodeToString(privateKeyEncoded);
        // 保存文件
        keyStrings[0] = publicKeyString;
        keyStrings[1] = privateKeyString;
        return keyStrings;
    }

    /**
     * 从字符串中加载公钥
     *
     * @param algorithm : 算法
     * @param keyString : 公钥字符串
     * @return : 公钥
     * @throws Exception
     */
    public static PublicKey loadPublicKeyFromString(String algorithm, String keyString) throws Exception {
        // 进行Base64解码
        byte[] decode = Base64.getDecoder().decode(keyString);
        // 获取密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        // 构建密钥规范
        X509EncodedKeySpec keyspec = new X509EncodedKeySpec(decode);
        // 获取公钥
        return keyFactory.generatePublic(keyspec);

    }

    /**
     * 从字符串中加载私钥
     *
     * @param algorithm : 算法
     * @param keyString : 私钥字符串
     * @return : 私钥
     * @throws Exception
     */
    public static PrivateKey loadPrivateKeyFromString(String algorithm, String keyString) throws Exception {
        // 进行Base64解码
        byte[] decode = Base64.getDecoder().decode(keyString);
        // 获取密钥工厂
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        // 构建密钥规范
        PKCS8EncodedKeySpec keyspec = new PKCS8EncodedKeySpec(decode);
        // 生成私钥
        return keyFactory.generatePrivate(keyspec);

    }

    /**
     * 使用密钥加密数据
     *
     * @param algorithm      : 算法
     * @param input          : 原文
     * @param key            : 密钥
     * @param maxEncryptSize : 最大加密长度(需要根据实际情况进行调整)
     * @return : 密文
     * @throws Exception
     */
    public static String encrypt(String algorithm, String input, Key key, int maxEncryptSize) throws Exception {
        // 获取Cipher对象
        Cipher cipher = Cipher.getInstance(algorithm);
        // 初始化模式(加密)和密钥
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // 将原文转为byte数组
        byte[] data = input.getBytes();
        // 总数据长度
        int total = data.length;
        // 输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        decodeByte(maxEncryptSize, cipher, data, total, baos);
        // 对密文进行Base64编码
        return Base64.getEncoder().encodeToString(baos.toByteArray());

    }

    /**
     * 解密数据
     *
     * @param algorithm      : 算法
     * @param encrypted      : 密文
     * @param key            : 密钥
     * @param maxDecryptSize : 最大解密长度(需要根据实际情况进行调整)
     * @return : 原文
     * @throws Exception
     */
    public static String decrypt(String algorithm, String encrypted, Key key, int maxDecryptSize) throws Exception {
        // if (input == null && input.equals("") && input.length() == 0) {
        //     return "";
        // }
        // 获取Cipher对象
        Cipher cipher = Cipher.getInstance(algorithm);
        // 初始化模式(解密)和密钥
        cipher.init(Cipher.DECRYPT_MODE, key);
        // 由于密文进行了Base64编码, 在这里需要进行解码
        byte[] data = Base64.getDecoder().decode(encrypted);
        // 总数据长度
        int total = data.length;
        // 输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        decodeByte(maxDecryptSize, cipher, data, total, baos);
        // 输出原文
        return baos.toString();

    }

    /**
     * 分段处理数据
     *
     * @param maxSize : 最大处理能力
     * @param cipher  : Cipher对象
     * @param data    : 要处理的byte数组
     * @param total   : 总数据长度
     * @param baos    : 输出流
     * @throws Exception
     */
    private static void decodeByte(int maxSize, Cipher cipher, byte[] data, int total, ByteArrayOutputStream baos)
            throws Exception {
        // 偏移量
        int offset = 0;
        // 缓冲区
        byte[] buffer;
        // 如果数据没有处理完, 就一直继续
        while (total - offset > 0) {
            // 如果剩余的数据 >= 最大处理能力, 就按照最大处理能力来加密数据
            if (total - offset >= maxSize) {
                // 加密数据
                buffer = cipher.doFinal(data, offset, maxSize);
                // 偏移量向右侧偏移最大数据能力个
                offset += maxSize;
            } else {
                // 如果剩余的数据 < 最大处理能力, 就按照剩余的个数来加密数据
                buffer = cipher.doFinal(data, offset, total - offset);
                // 偏移量设置为总数据长度, 这样可以跳出循环
                offset = total;
            }
            // 向输出流写入数据
            baos.write(buffer);
        }
    }
}