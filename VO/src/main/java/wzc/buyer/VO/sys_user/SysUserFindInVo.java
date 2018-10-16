package wzc.buyer.VO.sys_user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import wzc.buyer.base.BaseVO;


@ApiModel(value = "")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SysUserFindInVo extends BaseVO {

  /**
   * 用户名
   */
  @ApiModelProperty(value = "用户名")
  private String userName;
  /**
   * 密码
   */
  @ApiModelProperty(value = "密码")
  private String passWord;
  /**
   * 备注
   */
  @ApiModelProperty(value = "备注")
  private String notes;
  /**
   * 用户编码
   */
  @ApiModelProperty(value = "用户编码")
  private String userCode;
  /**
   * 最后登录时间
   */
  @ApiModelProperty(value = "最后登录时间")
  private java.time.LocalDateTime lastLoginTime;

}
