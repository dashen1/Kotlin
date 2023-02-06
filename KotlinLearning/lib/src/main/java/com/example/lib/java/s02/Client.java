package com.example.lib.java.s02;

import com.example.lib.kt.s02.KtStudentKt;
import com.example.lib.kt.s03.StudentKt;
import com.example.lib.kt.s04.Client04Kt;
import com.example.lib.kt.s05.Client05Kt;

import java.io.File;

import kotlin.io.FilesKt;
import kotlin.text.Charsets;

public class Client {

    public static void main(String[] args) {

        //java 无法调用
        // `showTest()`;

//        StudentKt.main();
//        Client04Kt.main();
        // java 调用  扩展函数
//        File file = new File("XXXX");
//        FilesKt.readText(file, Charsets.UTF_8);

        Client05Kt.main();

    }
}
