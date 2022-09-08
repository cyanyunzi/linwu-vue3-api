package com.linwu.vue3.api.enums;

public interface IRespCode<C extends String,M extends String> {
    C getCode();

    M getMsg();


}
