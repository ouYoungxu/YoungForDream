package com.ouyang.practical.json;

import java.util.List;

/**
 * @author: ouyangxu
 * @Date: 2020年03月27日 16:55
 */
public class Record {
    private List<JsonObj> RECORDS;

    public List<JsonObj> getRECORDS() {
        return RECORDS;
    }

    public void setRECORDS(List<JsonObj> RECORDS) {
        this.RECORDS = RECORDS;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Record = {");
        sb.append("\"RECORDS\":")
                .append(RECORDS);
        sb.append('}');
        return sb.toString();
    }
}
