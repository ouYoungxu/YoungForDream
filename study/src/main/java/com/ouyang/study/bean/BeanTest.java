package com.ouyang.study.bean;

import org.junit.Test;

/**
 * @author: ouyangxu
 * @Date: 2019年05月17日 15:31
 */
public class BeanTest {
    @Test
    public void test () {
        NoticePushDTO dto = NoticePushDTO.build().addModule("123").addUserId(123L);
        System.out.println(dto);
    }
}
