package wzc.buyer.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * mvc 签名拦截器 fields
 * @author 吴占超
 * @date 2018/10/21 1:42 PM
 */
@Configuration
public class ModuleApiWebInterceptorHandler extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!"GET".equals(request.getMethod()) ||
                StringUtils.isBlank(request.getRequestURI())) return true;
        String fields = request.getParameter("fields");

        if(fields == null || StringUtils.isBlank(fields.toString())) return true;
        request.setAttribute("includes",fields.toString());
        return super.preHandle(request, response, handler);
    }
}
