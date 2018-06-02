package com.kuai.springboot.test.YesOrNo;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc 二进制判断是否
 * @since ${date}
 */
public class YesOrNo {


    public static final int PUBLIC = 1;
    public static final int STATIC = 8;
    public static final int FINAL = 16;

    public static final int PUBLIC_STATIC_FINAL = PUBLIC | STATIC |FINAL;

    public static void main(String[] args){
        System.out.println(isPublicStaticFinal(25));
        System.out.println(Integer.toHexString(15));
        System.out.println(Integer.valueOf("10",16));

    }

    public static boolean isPublicStaticFinal(int mod){
        return (mod & PUBLIC_STATIC_FINAL) == PUBLIC_STATIC_FINAL;
    }

}