package wzc.buyer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import wzc.buyer.VO.sys_user.SysUserFindInVo;

import javax.validation.Valid;

/**
 * @author 吴占超
 * @date 2018/10/16 4:10 PM
 */
@RestController
public class SysUserController {

    @PostMapping("sys-user/login")
    public SysUserFindInVo login(@Valid @RequestBody SysUserFindInVo sysUserFindInVo) {
        return sysUserFindInVo;
    }
}
