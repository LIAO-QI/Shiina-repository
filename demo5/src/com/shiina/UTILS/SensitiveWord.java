package com.shiina.UTILS;

import java.util.ArrayList;
import java.util.List;

public class SensitiveWord {
    private static List<String> list = new ArrayList<String>();

    static{
        //这里应该从数据库中导入敏感词的，这里直接用词来模拟
        list.add("艹");
        list.add("呕");
    }
    public static List<String> getWords(){
        return list;
    }
    public static void reBuild(){
        //把list中的内容存储到数据库---每一段时间存储一次
    }

}
