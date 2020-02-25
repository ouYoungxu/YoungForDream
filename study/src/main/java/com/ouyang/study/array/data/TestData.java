package com.ouyang.study.array.data;

/**
 * @author: ouyangxu
 * @Date: 2019年09月15日 下午 05:52
 */
public class TestData {
    private Double xPos;

    public TestData (Double xPos) {
        this.xPos = xPos;
    }

    public Double getxPos() {
        return xPos;
    }

    public void setxPos(Double xPos) {
        this.xPos = xPos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"xPos\":")
                .append(xPos);
        sb.append('}');
        return sb.toString();
    }
}
