package com.ouyang.practical.json;

/**
 * @author: ouyangxu
 * @Date: 2020年03月27日 16:56
 */
public class JsonObj {
    private String radar_id;
    private String time;
    private String sum;

    public String getRadar_id() {
        return radar_id;
    }

    public void setRadar_id(String radar_id) {
        this.radar_id = radar_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("JsonObj = {");
        sb.append("\"radar_id\":\"")
                .append(radar_id).append('\"');
        sb.append(",\"time\":\"")
                .append(time).append('\"');
        sb.append(",\"sum\":\"")
                .append(sum).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
