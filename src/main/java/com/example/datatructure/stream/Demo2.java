package com.example.datatructure.stream;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {
}


class Foo {
    String name;
    List<Bar> bars = new ArrayList<>();

    Foo(String name) {
        this.name = name;
    }
}

class Bar {
    String name;

    Bar(String name) {
        this.name = name;
    }
}

