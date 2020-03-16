package com.mrh.community.cache;

import com.fasterxml.classmate.types.ResolvedInterfaceType;
import com.mrh.community.dto.TagDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Thanks For Watching！
 *
 * @author HuJiaqun
 * @date 2020/3/15 9:53
 **/

public class TagCache {
    public static List<TagDTO> get() {
        List<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO program = new TagDTO();
        program.setCatetoryName("开发语言");
        program.setTags(Arrays.asList("java", "c", "php", "perl", "python", "javascript", "c#", "ruby", "go", "lua", "node.js", "erlang", "scala", "bash", "actionscript", "golang", "typescript", "flutter"));
        tagDTOS.add(program);

        TagDTO devtool = new TagDTO();
        devtool.setCatetoryName("开发工具");
        devtool.setTags(Arrays.asList("vim", "emacs", "ide", "eclipse", "xcode", "intellij-idea", "textmate", "sublime-text", "visual-studio", "git", "github", "svn", "hg", "docker", "ci"));
        tagDTOS.add(devtool);

        TagDTO database = new TagDTO();
        database.setCatetoryName("数据库");
        database.setTags(Arrays.asList("mysql", "sqlite", "oracle", "sql", "nosql", "redis", "mongodb", "memcached", "postgresql"));
        tagDTOS.add(database);

        return tagDTOS;
    }


    public static String filterInvalid(String tags) {
        String[] split = StringUtils.split(tags, ".");
        List<TagDTO> tagDTOS = get();
        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String invalid = Arrays.stream(split).filter(t -> !tagList.contains(t)).collect(Collectors.joining(","));
        return invalid;
    }


}
