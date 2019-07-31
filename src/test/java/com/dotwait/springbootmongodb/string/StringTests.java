package com.dotwait.springbootmongodb.string;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringTests {
    @Test
    public void stringTest() {
        String A_DATA =
                "\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800" +
                        "\u100F\u4800\u100F\u4800\u100F\u5800\u400F\u5000\u400F\u5800\u400F\u6000\u400F" +
                        "\u5000\u400F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800" +
                        "\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F" +
                        "\u4800\u100F\u4800\u100F\u5000\u400F\u5000\u400F\u5000\u400F\u5800\u400F\u6000" +
                        "\u400C\u6800\030\u6800\030\u2800\030\u2800\u601A\u2800\030\u6800\030\u6800" +
                        "\030\uE800\025\uE800\026\u6800\030\u2000\031\u3800\030\u2000\024\u3800\030" +
                        "\u3800\030\u1800\u3609\u1800\u3609\u1800\u3609\u1800\u3609\u1800\u3609\u1800" +
                        "\u3609\u1800\u3609\u1800\u3609\u1800\u3609\u1800\u3609\u3800\030\u6800\030" +
                        "\uE800\031\u6800\031\uE800\031\u6800\030\u6800\030\202\u7FE1\202\u7FE1\202" +
                        "\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1" +
                        "\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202" +
                        "\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1\202\u7FE1" +
                        "\202\u7FE1\uE800\025\u6800\030\uE800\026\u6800\033\u6800\u5017\u6800\033\201" +
                        "\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2" +
                        "\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201" +
                        "\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2\201\u7FE2" +
                        "\201\u7FE2\201\u7FE2\201\u7FE2\uE800\025\u6800\031\uE800\026\u6800\031\u4800" +
                        "\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u5000\u100F" +
                        "\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800" +
                        "\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F" +
                        "\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800" +
                        "\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F\u4800\u100F" +
                        "\u3800\014\u6800\030\u2800\u601A\u2800\u601A\u2800\u601A\u2800\u601A\u6800" +
                        "\034\u6800\030\u6800\033\u6800\034\000\u7005\uE800\035\u6800\031\u4800\u1010" +
                        "\u6800\034\u6800\033\u2800\034\u2800\031\u1800\u060B\u1800\u060B\u6800\033" +
                        "\u07FD\u7002\u6800\030\u6800\030\u6800\033\u1800\u050B\000\u7005\uE800\036" +
                        "\u6800\u080B\u6800\u080B\u6800\u080B\u6800\030\202\u7001\202\u7001\202\u7001" +
                        "\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202" +
                        "\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001" +
                        "\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\u6800\031\202\u7001\202" +
                        "\u7001\202\u7001\202\u7001\202\u7001\202\u7001\202\u7001\u07FD\u7002\201\u7002" +
                        "\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201" +
                        "\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002" +
                        "\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\u6800" +
                        "\031\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002\201\u7002" +
                        "\u061D\u7002";
        char B[] = (
                "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
                        "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
                        "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
                        "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
                        "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
                        "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
                        "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
                        "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
                        "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\001"+
                        "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\001\000\000\000"+
                        "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
                        "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
                        "\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000"+
                        "\000\000\000\000\000\000\000\000\000").toCharArray();
        int[] A = new int[256];
        char[] data = A_DATA.toCharArray();
        assert (data.length == (256 * 2));
        int i = 0, j = 0;
        while (i < (256 * 2)) {
            int entry = data[i++] << 16;
            A[j++] = entry | data[i++];
        }
        for (int k=0;k<A.length;k++){
            System.out.println(A[k]);
        }
    }

    @Test
    public void stringIgnoreCaseTest(){
        String str = "A";
        String s = str.toLowerCase();

        String str1 = " hello world a";
        System.out.println(str1);
        System.out.println(str1.trim());
    }

    @Test
    public void fastJsonTest(){
        String str =  "{storeId:353977,userMac:\"8C-5A-F8-00-00-00\",userType:1,userName:\"8C-5A-F8-00-00-00\",loginTime:1562052428000}";
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println(jsonObject);
    }

    @Test
    public void integerTest(){
        Integer i = 0xffffff;
        int i1 = Integer.lowestOneBit(i);
        System.out.println(i1);

        int i2 = -1;
        System.out.println(Integer.highestOneBit(i2));

        int i3 = 1 >>> -2;
        System.out.println(i3);

        int i4 = -1 >> 31;
        int i5 = -1 >>> 31;
        System.out.println(i4 + "," + i5 + "," + (i4 | i5));

        Integer i6 = 129;
        Integer i7 = 129;
        Integer i8 = 127;
        Integer i9 = 127;
        System.out.println(i6 == i7);
        System.out.println(i8 == i9);
    }

    @Test
    public void longTest(){
        String l = "1231234124123123";
        Long decode = Long.decode(l);
        System.out.println(decode);
        long l1 = Long.parseLong(l);
        System.out.println(l1);
        Long i6 = 129L;
        Long i7 = 129L;
        Long i8 = 127L;
        Long i9 = 127L;
        System.out.println(i6 == i7);
        System.out.println(i8 == i9);
    }
}
