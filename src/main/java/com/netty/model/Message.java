package com.netty.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Mcl on 2018/3/14.
 */
@Getter
@Setter
public class Message implements Serializable{
    private String id;
    private String content;
}
