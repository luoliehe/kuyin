package com.llh.musciapp.common.util;

/**
 * Created by Administrator on 2015/3/22.
 */
public class StringUtil {
    /**
     * 判断是否为空白字符，如果是 "" 或者是 null 都是为空白字符
     * @param string
     * @return
     */
    public static boolean isBlank(String string){
        boolean flag = false;
        if(string==null){
            flag = true;
        }
        if("".equals(string)||"".equals(string.trim())){
            flag = true;
        }
        return flag;
    }
}
