package wzc.buyer.base.customenum;

import lombok.Data;

import java.util.Arrays;

/**
 * 自定义枚举异常
 * @author 吴占超
 * @date 2018/10/17 11:53 AM
 */
public enum CustomStatusEnum {
    InCheck("InCheck",40001),
    OutCheck("OutCheck",40002),
    Business("Business",40005);

    private Integer code;
    private String name;
    private CustomStatusEnum(String name,Integer code) {
        this.code = code;
        this.name = name;
    }

    public static String getNameByCode(Integer code) {
        return Arrays.stream(CustomStatusEnum.values()).filter(p -> p.getCode().equals(code)).findFirst().get().getName();
    }

    public static Integer getCodeByName(String name) {
        return Arrays.stream(CustomStatusEnum.values()).filter(p -> p.getName().equals(name)).findFirst().get().getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
