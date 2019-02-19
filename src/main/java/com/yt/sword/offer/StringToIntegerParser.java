package com.yt.sword.offer;

/**
 * @author SUN
 * @create 2019-02-19 下午11:03
 * @desc 第12页, 将字符串转换为数字
 */
public class StringToIntegerParser {

    private static final Integer POSITIVE_SIGN = 1;
    private static final Integer MINUS_FLAG = -1;
    private static final Integer INTEGER_MAX_LENGTH = 10;
    private static final int CHAR_ZERO_TO_INT = '0';
    private static final int CHAR_NINE_TO_INT = '9';

    public static Integer parse(String source) {
        if (null == source || source.length() == 0
                || source.length() > INTEGER_MAX_LENGTH
                || source.equals("-")) {
            return null;
        }

        return methodByCustomer(source);
    }

    private static Integer methodByJAVAUtil(String source) {
        return Integer.parseInt(source);
    }

    private static Integer methodByCustomer(String source) {
        String curSource = source;
        int flag = curSource.charAt(0) == '-' ? MINUS_FLAG : POSITIVE_SIGN;
        if (flag == MINUS_FLAG) {
            curSource = curSource.substring(1);
        }
        int result = 0;
        for(int i = 0 ; i < curSource.length() ; i++) {
            result = result * 10 + parseChar2Int(curSource.charAt(i));
        }
        confirmTransCorrectived(curSource, result, flag);
        return result * flag;
    }

    private static int parseChar2Int(char numberChar) {
        if (numberChar < CHAR_ZERO_TO_INT || numberChar > CHAR_NINE_TO_INT) {// TODO: 19/2/19
            throw new RuntimeException("字符串中含有非数字符号 numberChar:" + numberChar);
        }
        int result = numberChar - CHAR_ZERO_TO_INT;
        return result;
    }

    private static void confirmTransCorrectived(String source, Integer taget, int sign) {
        while (null != source && source.length() > 0 && source.charAt(0) == '0') {
            //这是最后想到的情况
            source = source.substring(1);
        }
        if (!source.equals(taget + "")) {
            throw new RuntimeException("整形转换越界, source:" + source + " sign:" + sign + "taget:" + taget);
        }
    }


    /**
     * TODO 到底 还是 少了 开头是 "+"的情况
     * @param args
     */
    public static void main(String[] args) {


//        System.out.println((Integer.MAX_VALUE+ "").length());
//        System.out.println((int)'9');
        System.out.println(Integer.MAX_VALUE);
        //Integer.MAX_VALUE + 1
        //-9999999。。。
        //00001
        String input ="-000010";//
        System.out.println(StringToIntegerParser.parse(input));
    }

}
