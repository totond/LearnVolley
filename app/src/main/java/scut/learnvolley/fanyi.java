package scut.learnvolley;
import java.util.List;

public class fanyi {
    public String[] translation;
    public basic basic;
    public  static class basic{
        public String phonetic;
        public String[] explains;
    }
    public String query;
    public int errorCode;
    public List<wb> web;
    public static class wb{
        public String[] value;
        public String key;
    }

    public void show(){
        for (int i = 0;i<translation.length;i++)
        {
            System.out.println(translation[i]);}
        System.out.println(basic.phonetic);
        for (int i = 0;i<basic.explains.length;i++){
            System.out.println(basic.explains[i]);
        }
        System.out.println(query);
        System.out.println(errorCode);
        for (int i = 0;i<web.size();i++){
            for(int j = 0; j<web.get(i).value.length;j++)
            {
                System.out.println(web.get(i).value[j]);
            }
            System.out.println(web.get(i).key);
        }
    }
}



