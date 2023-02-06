package com.example.lib.generic;

import com.example.lib.generic.object.FuClass;
import com.example.lib.generic.object.ZiClass;

import java.util.ArrayList;
import java.util.List;

// 限制 super String, extends String
public class TestOutIn<T extends String> {

    FuClass fuClass = new FuClass();
    ZiClass ziClass = new ZiClass();

    // 泛型读取模式
    void test01() {
        List<? extends FuClass> list = new ArrayList<ZiClass>();
        // 不能修改
//        list.add(parentClass);
        // null 特殊，可以修改
        list.add(null);
        // 能获取
        FuClass fuClass = list.get(0);
        // ? super SonClass === 只能修改，不能获取
        ArrayList<? super ZiClass> list2 = new ArrayList<FuClass>();

        list2.add(ziClass);
    }

    private void forShow(List<FuClass> lists) {

    }

    // 能获取，不能修改
    private void forShow2(List<? extends FuClass> lists) {

    }

    // 能修改，不能获取
    private void forShow3(List<? super ZiClass> lists) {

    }

    void test02() {
        List<ZiClass> sonList = new ArrayList<ZiClass>();
//        forShow(sonList); // 此时传不进去
        forShow2(sonList); // 此时传不进去
    }

    void test03() {
        List<FuClass> parentList = new ArrayList<FuClass>();
        forShow3(parentList);
    }


}
