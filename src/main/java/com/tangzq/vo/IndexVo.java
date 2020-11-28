package com.tangzq.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author tangzhiqiang
 */
@Getter
@Setter
@ToString
public class IndexVo implements Serializable {
    private int pageSize=30;
    private int pageNO=1;
    private String tab="all";
}
