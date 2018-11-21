package com.niu.enumtype;

/**
 * Created by ami on 2018/11/20.
 */
public enum ReturnStatus {
    UNKNOWN_CODE(-1, ""),
    OK(0, "成功")

    ;

    ReturnStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final int code;

    public int getCode() {
        return this.code;
    }

    private final String desc;

    public String getDesc() {
        return this.desc;
    }

    public static ReturnStatus fromCode(int code) {
        for (ReturnStatus v : ReturnStatus.values()) {
            if (v.code == code) {
                return v;
            }
        }
        return UNKNOWN_CODE;
    }

    public static ReturnStatus getEnum(String desc) {
        for (ReturnStatus v : ReturnStatus.values()) {
            if (v.getDesc().equalsIgnoreCase(desc)) {
                return v;
            }
        }
        return UNKNOWN_CODE;
    }
}
