package com.karimou.hoverfly;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class Fly {

    private String name;
    private String nickName;
    private String age;
}
