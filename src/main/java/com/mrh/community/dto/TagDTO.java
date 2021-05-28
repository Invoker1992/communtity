package com.mrh.community.dto;

import lombok.Data;

import java.util.List;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/3/15 9:54
 **/

@Data
public class TagDTO {
    private String catetoryName;
    private List<String> tags;

    public String getCatetoryName() {
        return catetoryName;
    }

    public void setCatetoryName(String catetoryName) {
        this.catetoryName = catetoryName;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
