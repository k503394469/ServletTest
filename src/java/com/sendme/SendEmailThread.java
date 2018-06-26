/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sendme;

/**
 *
 * @author Mr.A
 */
public class SendEmailThread extends Thread {

    @Override
    public void run() {
        int i = 0;
        try {
            while (true) {

                //每休眠一分钟，就扫描SendEmai表，查找�?要发送的邮件
                Thread.sleep(10 * 1000);
                System.out.println("第" + (++i) + "封");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
