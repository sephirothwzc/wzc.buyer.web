package wzc.buyer.base.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import wzc.buyer.base.customenum.CustomStatusEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 自定义错误
 * @author 吴占超
 * @date 2018/10/17 11:48 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CustomException extends RuntimeException {

    public CustomException(CustomStatusEnum customStatusEnum,String message) {
        this.customStatus = customStatusEnum;
        this.message = message;
    }
    @ApiModelProperty("自定义错误编码")
    private CustomStatusEnum customStatus;

    @ApiModelProperty("error time")
    private LocalDateTime dateTime = LocalDateTime.now();

    @ApiModelProperty("错误信息")
    private String message;
}
