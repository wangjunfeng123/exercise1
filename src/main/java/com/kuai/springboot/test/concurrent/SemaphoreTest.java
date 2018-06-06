package com.kuai.springboot.test.concurrent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class SemaphoreTest {
    public static final Semaphore MAX_SEMA_PHONE = new Semaphore(5);
    private final static SimpleDateFormat DEFAULT_DATE_FORMAT
            = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getDateTime() {
        Date dateTime = Calendar.getInstance().getTime();
        return DEFAULT_DATE_FORMAT.format(dateTime);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            final int num = i;
            final Random random = new Random();
            new Thread(() -> {
                boolean acquired = false;
                try {
                    MAX_SEMA_PHONE.acquire();

                    acquired = true;
                    System.out.println("我是线程" + num + "我活得了使用权" + getDateTime());
                    Thread.sleep(1000 + (random.nextInt() & 5000));
                    System.out.println("我是线程" + num + "我执行完了");
                } catch (InterruptedException e) {

                } finally {
                    if (acquired) {
                        MAX_SEMA_PHONE.release();
                    }
                }

            }).start();
        }
    }

}