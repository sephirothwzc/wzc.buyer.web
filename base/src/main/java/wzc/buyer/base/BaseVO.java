package wzc.buyer.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 吴占超
 * @date 2018/10/8 10:46 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseVO implements Serializable {
    /**
     * 数据校验编码
     */
    @ApiModelProperty(value = "数据校验编码")
    private String rules;

    /**
     * 有效性 （有效：1，失效：0；删除：-1）
     */
    @ApiModelProperty(value = "有效性 （有效：1，失效：0；删除：-1）")
    public Integer enableFlag;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间 ")
    public LocalDateTime createDate;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人 ")
    public String createBy;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间 ")
    public LocalDateTime updateDate;
    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人 ")
    public String updateBy;

    @ApiModelProperty("主键")
    public String id;
}
