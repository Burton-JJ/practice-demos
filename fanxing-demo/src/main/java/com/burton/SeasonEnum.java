package com.burton;

/**
 * @author Burton
 * @title: SeasonEnum
 * @projectName practice-demos
 * @description: 季节枚举
 * @date 2019/7/3111:17
 */
public enum SeasonEnum {
    SPRING("1", "春天"),
    SUMMER("2", "夏天"),
    AUTURM("3", "秋天"),
    WINTER("4", "冬天"),
        ;
    private String code;
    private String desc;
    SeasonEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
