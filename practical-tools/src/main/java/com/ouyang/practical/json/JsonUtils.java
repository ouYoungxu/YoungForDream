package com.ouyang.practical.json;

import com.alibaba.fastjson.JSON;

import java.io.*;

/**
 * @author: ouyangxu
 * @Date: 2020年03月27日 16:33
 */
public class JsonUtils {
    private static String tag = "\t";
    private static String block = "\0";

    public static void main(String[] args) {
        StringBuilder json = new StringBuilder();

        try {
            File file = new File("E:\\WorkSpace\\universal-tools\\practical-tools\\src\\main\\resources\\record.json");
            FileReader reader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(reader);

            String s = "";
            while ((s =bReader.readLine()) != null) {
                json.append(s);
            }
            bReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Record record = JSON.parseObject(json.toString(), Record.class);

        for (int id = 102202101; id < 102202143; id++) {
            if (id == 102202123) {
                System.out.println("");
            }

            StringBuilder sb = new StringBuilder();

            for (int hour = 0; hour < 24; hour++) {
                boolean ex = false;
                for (JsonObj obj : record.getRECORDS()) {
                    int h = Integer.parseInt(obj.getTime().split(" +")[1]);
                    if (obj.getRadar_id().equals(String.valueOf(id)) && h == hour) {
                        sb.append(obj.getSum()).append(tag);
                        ex = true;
                        break;
                    }
                }
                if (!ex) {
                    sb.append("0").append(tag);
                }
            }

            System.out.println(sb.toString());
        }
    }
}
