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
        program.setCatetoryName("生活日常");
        program.setTags(Arrays.asList("求职", "单身交友", "友谊万岁", "家庭聚餐", "吵架", "购物", "美食分享", "野餐", "家具购置", "优惠分享", "健康小窍门", "和谐秘籍", "远亲不如近邻", "琐事", "隔壁老王", "家电维修", "同城交易二手", "其他"));
        tagDTOS.add(program);

        TagDTO love = new TagDTO();
        love.setCatetoryName("情感天地");
        love.setTags(Arrays.asList("相亲","约会","AA制","一起去听演唱会","吵架", "情侣趣事", "情侣衫", "纪念日", "初恋结婚了", "分手", "看对方的手机", "没话题","网络聊天", "其他"));
        tagDTOS.add(love);

        TagDTO devtool = new TagDTO();
        devtool.setCatetoryName("旅游出行");
        devtool.setTags(Arrays.asList("找驴友", "户外探险", "海岛", "雪山", "大草原骑马", "大都市", "海边看日出", "北方滑雪", "呼吸大自然的清新空气", "植物园赏花", "自驾游", "组团", "沙漠看星星", "拍照", "其他"));
        tagDTOS.add(devtool);

        TagDTO database = new TagDTO();
        database.setCatetoryName("职场工作");
        database.setTags(Arrays.asList("行政助理", "机械工程师", "程序员", "司机", "厨师", "老板", "文职", "搬砖", "土木狗","找不到工作好烦","月薪3000","年收入","公积金","伤险","其他"));
        tagDTOS.add(database);

        TagDTO sport = new TagDTO();
        sport.setCatetoryName("体育运动");
        sport.setTags(Arrays.asList("轮滑","跳舞","滑雪","登山","跑步", "篮球", "足球", "乒乓球", "羽毛球", "游泳", "瑜伽", "高尔夫","太极拳", "其他"));
        tagDTOS.add(sport);

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
