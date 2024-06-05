package common;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.*;

/**从文件中读入sql，筛选其中的表名
 * Created by wangb on 2020/4/2.
 */
public class txt {
    public static void main(String[] args) throws IOException {
        String path = "C:\\workspaces\\test.txt";
        File file = new File(path);//定义一个file对象，用来初始化FileReader
        FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        String s = "";
        while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
            System.out.println(LineToHump.humpToLine2(s));// f_parent_no_leader
        }
        bReader.close();


    }
    public static String readTxt(String path) throws IOException {
        File file = new File(path);//定义一个file对象，用来初始化FileReader
        FileReader reader = new FileReader(file);//定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
        String s = "";
        while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
            sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
            System.out.println(s);
        }
        bReader.close();
        String str = sb.toString();
        System.out.println(str );
        return str;
    }
        public static void getTableName(String[] args) {
        int distinct = 0, words = 0;
        int minlen = Integer.parseInt(args[0]);
        ST<String, Integer> st = new ST<String, Integer>();
        String out = "";

        // compute frequency counts
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if ("JOIN".equals(key.toUpperCase())) {
                out = StdIn.readString();
                StdOut.println(out);
            } else if ("FROM".equals(key.toUpperCase())) {
                out = StdIn.readString();
                while (!"WHERE".equals(out.toUpperCase()) && !"INNER".equals(out.toUpperCase())) {
                    if (out.length() < minlen) {
                        out = StdIn.readString();
                        continue;
                    }
                    StdOut.println(out);
                    out = StdIn.readString();
                }
            }
            words++;
            //if (st.contains(key)) {
            //st.put(key, st.get(key) + 1);
            //}
            //else {
            //st.put(key, 1);
            //distinct++;
            //   }
        }

        // find a key with the highest frequency count
        //String max = "";
        //st.put(max, 0);
        //for (String word : st.keys()) {
            //if (st.get(word) > st.get(max))
                //max = word;
        //}

        //StdOut.println(max + " " + st.get(max));
        //StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
    }

}
