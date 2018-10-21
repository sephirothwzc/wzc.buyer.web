package wzc.buyer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wzc.buyer.VO.sys_user.SysUserFindInVo;
import wzc.buyer.base.customenum.CustomStatusEnum;
import wzc.buyer.base.exception.CustomException;

import javax.validation.Valid;
import java.util.*;

/**
 * @author 吴占超
 * @date 2018/10/16 4:10 PM
 */
@RestController
public class SysUserController {

    @PostMapping("sys-user/login")
    public SysUserFindInVo login(@Valid @RequestBody SysUserFindInVo sysUserFindInVo) {
        if(!"admin".equals(sysUserFindInVo.getUserName())) {
            throw new CustomException(CustomStatusEnum.Business,"userName is not find");
        } else if(!"admin".equals(sysUserFindInVo.getPassWord())) {
            throw new CustomException(CustomStatusEnum.Business,"passWord is not find");
        }
        return sysUserFindInVo;
    }

    @GetMapping("sys-user")
    public List<SysUserFindInVo> findSysUser(SysUserFindInVo sysUserFindInVo) {
        return new ArrayList<SysUserFindInVo>() {{
            add(new SysUserFindInVo(){{
                setId("123");
                setUserName("张三");
                setPassWord("1233");
            }});
            add(new SysUserFindInVo(){{
                setId("4");
                setUserName("张三1");
                setPassWord("2");
            }});
        }};
    }
}
