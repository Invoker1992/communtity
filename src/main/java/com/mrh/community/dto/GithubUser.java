package com.mrh.community.dto;

import lombok.Data;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/2/13 14:13
 **/

@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
