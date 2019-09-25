package com.chaohen.fund.analysis.demo;

import org.jasypt.util.text.BasicTextEncryptor;

public class EncryptionTest{
    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        //自定义加密所需的salt(盐值)
        textEncryptor.setPassword("salt123456");
        //要加密的数据（数据库的用户名或密码，当然你要是想让URL加密，也是可以的）
        String username = textEncryptor.encrypt("root");
        String password = textEncryptor.encrypt("123456");
        System.out.println("username:" + username);
        System.out.println("password:" + password);
    }
}