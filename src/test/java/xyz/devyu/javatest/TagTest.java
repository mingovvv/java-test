package xyz.devyu.javatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import xyz.devyu.javatest.annotations.FastTest;
import xyz.devyu.javatest.annotations.SlowTest;

public class TagTest {

    @Test
    @Tag("fast")
    @DisplayName("태그명에 따른 테스트 분리 : fast - local")
    void tag_test1() {

    }

    @Test
    @Tag("slow")
    @DisplayName("태그명에 따른 테스트 분리 : slow - qa")
    void tag_test2() {

    }

    @FastTest
    @DisplayName("태그명(애노테이션)에 따른 테스트 분리 : fast - local")
    void tag_test3() {

    }

    @SlowTest
    @DisplayName("태그명(애노테이션)에 따른 테스트 분리 : slow - qa")
    void tag_test4() {

    }

}
