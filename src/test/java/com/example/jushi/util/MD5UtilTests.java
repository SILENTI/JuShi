package com.example.jushi.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 居無何
 * date: 2022/2/22 21:11
 * Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MD5UtilTests {

    @Test
    public void MD5 () {
        System.out.println(MD5Util.getSalt());
    }

}
