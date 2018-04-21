package com.ygy.test;

import com.ygy.dao.EssayDao;
import com.ygy.mapper.EssayMapper;
import com.ygy.model.Essay;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.validation.constraints.AssertFalse;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Btest {
    int THREAD_NUM = 1000;
    private CountDownLatch countDownLatch = new CountDownLatch(THREAD_NUM);
    @Autowired
    private EssayDao essay;
    @AssertFalse
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(new MyThread()).start();
            //计数器减一
            countDownLatch.countDown();
        }
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class MyThread implements Runnable {

        @Override
        public void run() {
            try {
                //所有线程等待，当线程创建完后一起并发
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String rand = UUID.randomUUID().toString();
            Essay essay1 = essay.SelectTitle(rand);
            System.out.println(Thread.currentThread().getName() + "===============" + essay1);
        }
    }
}
