package com.ouyang.study.array;

import com.alibaba.fastjson.JSON;
import com.ouyang.study.array.data.TestData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: ouyangxu
 * @Date: 2019年07月12日 下午 01:57
 */
public class ArrayTest {
    @Test
    public void test () {
        List<String> list = Arrays.asList("111", "222", "333", "444");
        System.out.println(list.get(list.size() - 1));
    }

    @Test
    public void test2 () {
        List<Double> dataList = new ArrayList<>();
        dataList.add(17D);
        dataList.add(10D);
        dataList.add(13D);
        dataList.add(20D);
        dataList.add(26D);
        List<Double> xPosList = new ArrayList<>();
        dataList.sort(Comparator.comparing(Double::doubleValue));
        xPosList.add(dataList.get(0));
        for (Double data : dataList) {
            boolean add = true;
            for (Double data2 : dataList) {
                if (data.equals(data2)) {
                    continue;
                }
                double diff = data2 - data;

                if (diff < 0) {
                    diff *= -1;
                }
                if (diff < 5) {
                    add = false;
                    break;
                }
            }
            if (add) {
                xPosList.add(data);
            }
        }

        xPosList.forEach(System.out::println);
    }

    @Test
    public void test3 () {
        List<Double> dataList = new ArrayList<>();
        dataList.add(10D);
        dataList.add(13D);
        dataList.add(17D);
        dataList.add(20D);
        List<Double> xPosList = new ArrayList<>();
        for (Double data : dataList) {
            if (xPosList.size() == 0) {
                xPosList.add(data);
                continue;
            }
            List<Double> tmp = new ArrayList<>(dataList.size());
            boolean add = false;
            for (Double d : xPosList) {
                tmp.add(d);
                if (d > data) {
                    if (d - data > 5) {
                        add = true;
                    } else {
                        tmp.remove(d);
                    }
                } else {
                    if (data - d > 5) {
                        add = true;
                    } else {
                        continue;
                    }
                }
            }
            xPosList = tmp;
            if (add) {
                xPosList.add(data);
            }
        }
    }

    @Test
    public void test4 () {
        for (int index = 1; index < 2 - 1; index++) {
            System.out.println("1111111111");
        }
    }

    @Test
    public void test5 () {
        List<TestData> dataList = new ArrayList<>();
        int i = 0;
        for (;;) {
            if (i > 49) {
                break;
            } else {
                i++;
            }
            TestData testData = new TestData(1 + Math.random() * (100 - 1 + 1));
            dataList.add(testData);
        }

        dataList.forEach(ArrayTest :: print);
        System.out.println(" --------------------------------- ");

        dataList.sort(Comparator.comparing(TestData::getxPos));

        System.out.println(sort(dataList, 55D, true));
    }

    private static TestData sort(List<TestData> dataList, double fix, boolean begin) {
        if (dataList == null || dataList.size() == 0) {
            return null;
        }

        dataList.sort(Comparator.comparing(TestData::getxPos));
        dataList.forEach(ArrayTest :: print);
        System.out.println(" --------------------------------- ");

        TestData result = null;
        double min = fix;

        if (begin) {
            for (int index = 0; index < dataList.size(); index++) {
                TestData testData = dataList.get(index);
                if (testData.getxPos() > fix) {
                    break;
                }
                double diff = testData.getxPos() - fix;
                if (diff < 0) {
                    diff = diff * -1;
                }
                if (min > diff) {
                    min = diff;
                    result = testData;
                }
            }
        } else {
            for (int index = dataList.size() - 1; index > 0; index--) {
                TestData testData = dataList.get(index);
                if (testData.getxPos() < fix) {
                    break;
                }
                double diff = testData.getxPos() - fix;
                if (diff < 0) {
                    diff = diff * -1;
                }
                if (min > diff) {
                    min = diff;
                    result = testData;
                }
            }
        }
        return result;
    }

    private static void print(TestData testData) {
        System.out.println(testData);
    }

    @Test
    public void test6 () {
        List<TestData> dataList = new ArrayList<>();
        dataList.add(new TestData(42.88));
        dataList.add(new TestData(43.93));
        dataList.add(new TestData(45.11));
        dataList.add(new TestData(46.2));
        dataList.add(new TestData(47.34));
        dataList.add(new TestData(48.37));
        dataList.add(new TestData(49.55));
        dataList.add(new TestData(50.64));

        dataList.sort(Comparator.comparing(TestData::getxPos));

        TestData result = dataList.get(dataList.size() - 1);
        double min = result.getxPos();

        for (TestData targetData : dataList) {
            double diff = targetData.getxPos() - 200;
            if (diff < 0) {
                diff = diff * -1;
            }
            if (min > diff) {
                min = diff;
                result = targetData;
            }
        }

        System.out.println(result);
    }

    @Test
    public void test7 () {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("num:" + i);
        }

        int num = list.size() / 200 + 1;
        for (int i = 0; i < num; i++) {
            StringBuilder sb = new StringBuilder();
            int max = 200 * (i + 1);
            if (max > list.size()) {
                max = list.size();
            }
            for (int j = 200 * i; j < max; j++) {
                sb.append(list.get(j)).append(";");
            }
            System.out.println(sb.toString());
            System.out.println("-----------------------------------------");
        }
    }

    @Test
    public void test8 () {
        Response response = new Response();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        response.setList1(list);
        Integer[] is = {0,1,2,3,4,5,6,7,8,9};
        response.setList2(is);
        System.out.println(JSON.toJSONString(response));
    }

    class Response {
        private List<Integer> list1;
        private Integer[] list2;

        public List<Integer> getList1() {
            return list1;
        }

        public void setList1(List<Integer> list1) {
            this.list1 = list1;
        }

        public Integer[] getList2() {
            return list2;
        }

        public void setList2(Integer[] list2) {
            this.list2 = list2;
        }
    }
}
