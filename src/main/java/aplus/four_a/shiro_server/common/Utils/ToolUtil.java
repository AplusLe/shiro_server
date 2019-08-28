package aplus.four_a.shiro_server.common.Utils;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.math.BigDecimal;
import java.util.*;

/**
 * 工具类(方法描述)
 *
 * @author Illusion
 * @create 2019-02-13 17:29
 */

public class ToolUtil {

    /**
     * 替换中文空格
     * @return
     */
    public static String replaceCnSpace(String len) {
        return  len.replaceAll("　", "").replaceAll(" ","");
    }


    /**
     * 对象是否不为空(新增)
     *
     * @param o
     * @return
     */
    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }

    /**
     *
     * @param o
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        }
        if (o instanceof String) {
            if (o.toString().trim().equals("")) {
                return true;
            }
        } else if (o instanceof List) {
            if (((List) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Map) {
            if (((Map) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Set) {
            if (((Set) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Object[]) {
            if (((Object[]) o).length == 0) {
                return true;
            }
        } else if (o instanceof int[]) {
            if (((int[]) o).length == 0) {
                return true;
            }
        } else if (o instanceof long[]) {
            if (((long[]) o).length == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取临时目录
     *
     * @author
     * @Date 2017/5/24 22:35
     */
    public static String getTempPath() {
        return System.getProperty("java.io.tmpdir");
    }



    /**
     * 获取随机位数的字符串
     *
     * @author
     * @Date 2017/8/24 14:09
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取指定长度的数字
     * @param length
     * @return
     */
    public static String getRandomInt(int length) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 去后缀
     * @param str
     * @param suffix
     * @return
     */
    public static Object removeSuffix(String str, String suffix) {
        if (isEmpty(str) || isEmpty(suffix)) {
            return str;
        }

        if (str.endsWith(suffix)) {
            return str.substring(0, str.length() - suffix.length());
        }
        return str;
    }

    /**
     * 判断参数列表是否为空
     * @param os
     * @return
     */
    public static boolean isOneEmpty(Object... os) {
        for (Object o : os) {
            if (isEmpty(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     *  获取唯一识别码 大写
     * @param code 唯一标识符
     * @return
     */
    public static String getHashCodeUpChar (String code) {
        return new Md5Hash(code).toString().toUpperCase();
    }

    /**
     *  获取唯一识别码 小写
     * @param code 唯一标识符
     * @return
     */
    public static String getHashCodeLowChar (String code) {
        return new Md5Hash(code).toString().toLowerCase();
    }

    /**
     *  对象转数字
     * @param o 传入的对象
     * @return
     */
    public static Integer objToInteger(Object o) {
        if (o instanceof Double){
            Integer returnVal = null;
            try {
                BigDecimal bigDecimal = new BigDecimal(String.valueOf(o));
                returnVal =  bigDecimal.intValue();
            }catch (Exception e){
                System.out.println("ToolUtil.objToInteger() 转换异常");
                e.printStackTrace();
            }
            return  returnVal;
        }else {
            Integer returnVal = null;
            if(isNotEmpty(o)) {
                try {
                    returnVal = Integer.valueOf(o.toString());
                } catch (Exception e) {
                    System.out.println("ToolUtil.objToInteger() 转换异常");
                    e.printStackTrace();
                }
            }
            return returnVal;
        }
    }

    /**
     * 获取唯一时间轴和数字组合
     * @return
     */
    public static String uniqueTimeMillis() {
        Long time = System.currentTimeMillis();
        return String.valueOf(time);
    }
    /**
     *
     * @param str 字符串
     * @param regepx1  分隔符1
     * @param regepx2  分隔符2
     * @return
     */
    public static Map<String, String> splitToMap(String str, String regepx1, String regepx2) {
        if (isEmpty(str)){
            return null;
        }
        Map<String, String> stringMap = new HashMap<>();
        if (isNotEmpty(regepx1) && isNotEmpty(regepx2)){

            if (str.contains(regepx1)) {
                String[] oneStr = str.split(regepx1);
                for (int i = 0; i < oneStr.length; i++) {
                    if (oneStr[i].contains(regepx2)){
                        stringMap.put(oneStr[i].split(regepx2)[0], oneStr[i].split(regepx2)[1]);
                    }else {
                        stringMap.put( String.valueOf(++i),str);
                    }
                }
            }else {
                stringMap.put("1",str);
            }
        }else {
            stringMap.put("1",str);

        }
        return stringMap;
    }


    /**
     * 强转->string,并去掉多余空格
     *
     * @param str
     * @return
     */
    public static String toStr(Object str) {
        return toStr(str, "");
    }

    /**
     * 强转->string,并去掉多余空格
     *
     * @param str
     * @param defaultValue
     * @return
     */
    public static String toStr(Object str, String defaultValue) {
        if (null == str) {
            return defaultValue;
        }
        return str.toString().trim();
    }

    /**
     * 把一个数转化为int
     * @author
     */
    public static Integer toInt(Object val) {
        if (val instanceof Double) {
            BigDecimal bigDecimal = new BigDecimal((Double) val);
            return bigDecimal.intValue();
        } else {
            Integer returnVal = null;
            if(isNotEmpty(val)) {
                try {
                    returnVal = Integer.valueOf(val.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return returnVal;
        }

    }

    /**
     * 防止病毒后缀名   只列出常见后缀名
     * @param fileName
     * @return
     */
    public static Boolean inspectVirusFileSuffix(String fileName){
        // 因为 DOC为后缀的也有可能有病毒，所以只支持 docx
        String suffix = getFileSuffix(fileName,true);
        if (".exe".equals(suffix)
                || ".dll".equals(suffix)
                || ".com".equals(suffix)
                || ".ocx".equals(suffix)
                || ".vxd".equals(suffix)
                || ".sys".equals(suffix)
                || ".vbs".equals(suffix)
                || ".js".equals(suffix)
                || ".php".equals(suffix)
                || ".asp".equals(suffix)
                || ".jsp".equals(suffix)
                || ".html".equals(suffix)
                || ".hta".equals(suffix)
                || ".htm".equals(suffix)
                || ".apk".equals(suffix)
                || ".jar".equals(suffix)
                || ".java".equals(suffix)
                ){
            return  false;
        }
        return true;
    }


    /**
     * 获取文件后缀名
     * @param fileName  文件名
     * @param isContainSpot 是否含有点
     * @return
     */
    public static String getFileSuffix(String fileName, Boolean isContainSpot){
        int lastIndexOfSuffix = fileName.lastIndexOf(".");

        if (isContainSpot) {
            String suffix = fileName.substring(lastIndexOfSuffix, fileName.length()).toLowerCase();
            return suffix;
        }else {
            String suffix = fileName.substring(lastIndexOfSuffix + 1, fileName.length()).toLowerCase();
            if (isEmpty(suffix)){
                return "";
            }
            return suffix;
        }
    }


    public static String[] splitStr(String string, String split){
        if (isEmpty(string)){
            return new String[]{};
        }
        if (!string.contains(split)){
            return new String[]{string};
        }

        String[] strs = string.split(split);

        ArrayList<String> listStr = new ArrayList<>();
        for (String s : strs){
            if (isNotEmpty(s)){
                listStr.add(s);
            }
        }
        if (isNotEmpty(listStr)){
            strs = new String[listStr.size()];
            for (int i = 0;i< listStr.size();i++){
                strs[i] = listStr.get(i);
            }
        }else {
            strs = new String[]{};
        }

        return strs;
    }

    /**
     * 获指定长度的字符串
     */
    public static String toSpecifiedStr(String str, Integer length){
        Integer si = str.length();
        if (length > si){
            return str;
        }
        return str.substring(0,length);
    }

}
