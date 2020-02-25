package com.ouyang.study.array;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: ganjiang-ouyangxu
 * @Date: 2018年08月14日 11:24
 **/
public class ArraySort {
    @Test
    public void test () {
        ContractUser contractUser1 = new ContractUser();
        contractUser1.setId(1L);
        contractUser1.setSignName("111111");
        contractUser1.setSignOrder(1);

        ContractUser contractUser11 = new ContractUser();
        contractUser11.setId(1L);
        contractUser11.setSignName("111111");
        contractUser11.setSignOrder(1);

        ContractUser contractUser2 = new ContractUser();
        contractUser2.setId(2L);
        contractUser2.setSignName("222222");
        contractUser2.setSignOrder(2);

        ContractUser contractUser3 = new ContractUser();
        contractUser3.setId(2L);
        contractUser3.setSignName("333333");
        contractUser3.setSignOrder(3);

        List<ContractUser> contractUserList = new ArrayList<>();
        contractUserList.add(contractUser3);
        contractUserList.add(contractUser1);
        contractUserList.add(contractUser2);
        contractUserList.add(contractUser11);
        System.out.println(JSON.toJSONString(contractUserList));

        Collections.sort(contractUserList, Comparator.comparingInt(ContractUser::getSignOrder));

        System.out.println(JSON.toJSONString(contractUserList));
    }
}
