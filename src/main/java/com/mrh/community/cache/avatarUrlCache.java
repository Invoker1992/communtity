package com.mrh.community.cache;

import org.springframework.stereotype.Component;

@Component
public class avatarUrlCache {

    public String getAvatarUrl(){
        int index = (int) (Math.random() * (AvaCache.length - 1));
        return AvaCache[index];
    }

    private static String[] AvaCache = new String[]{"https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201702%2F06%2F20170206134245_zeQx2.jpeg&refer=http%3A%2F%2Fb-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624763475&t=773674ece66c9b5384b7", "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.banbaowang.com%2Fuploads%2Fallimg%2F200605%2F32-200605143G4-50.jpg&refer=http%3A%2F%2Fwww.banbaowang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624792634&t=77a9cd8e996ac8ef485408660f549df4",
    "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fup.enterdesk.com%2Fedpic%2F24%2Fbb%2F36%2F24bb36bcba8e72f4620a1c503fd54ad6.jpg&refer=http%3A%2F%2Fup.enterdesk.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624792701&t=3552d76dbb35e2066a646ff0efbb15ab",
    "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg7.iqiyipic.com%2Fpassport%2F20180711%2F87%2F62%2Fpassport_1444568771_153128342374669_130_130.jpg&refer=http%3A%2F%2Fimg7.iqiyipic.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624792725&t=af862cefc3f11bd71817939e7409db83",
    "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.yunkucn.com%2Ffiles%2Fallimg%2Fi_5_4251151720D3814180427_26.jpg&refer=http%3A%2F%2Fwww.yunkucn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624792747&t=fdb6e0ccdec410e01c1fa7dcbe51e7ae",
    "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fgdp.alicdn.com%2Fimgextra%2Fba%2F8e%2FTB1qCLszpGWBuNjy0FbSuv4sXXa.jpg&refer=http%3A%2F%2Fgdp.alicdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624792772&t=e4ec973cfed621dbedd5cbb14d5cf137",
    "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Finews.gtimg.com%2Fnewsapp_bt%2F0%2F12138243761%2F641.jpg&refer=http%3A%2F%2Finews.gtimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624792796&t=7d8e7eb094db0ceba52709b58f7451ec",
    "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fi1.w.hjfile.cn%2Fslide%2F201101%2Ffalali_3649.jpg&refer=http%3A%2F%2Fi1.w.hjfile.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1624792824&t=9a99b7716304ae7e96f8d77266bb815c"};

}
