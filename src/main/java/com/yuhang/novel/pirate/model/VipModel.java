package com.yuhang.novel.pirate.model;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

@ApiModel(value = "是否VIP")
public class VipModel implements Serializable {

    private boolean isVip;

    public boolean isVip() {
        return isVip;
    }

    public VipModel setVip(boolean vip) {
        isVip = vip;
        return this;
    }
}
