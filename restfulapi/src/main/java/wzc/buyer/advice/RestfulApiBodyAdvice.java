package wzc.buyer.advice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对返回对象个性化过滤处理
 *
 * @author 吴占超
 * @date 2018/10/21 10:31 AM
 */
@ControllerAdvice
public class RestfulApiBodyAdvice implements ResponseBodyAdvice {

    /**
     * 包含项目
     */
    private String[] includes;

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        // 自定义判断
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 初始化
        this.includes = new String[] {};
        if(o == null) return null;
        // 判断返回值类型 对象、list、map

        // 通过 ServerHttpRequest 的实现类 ServletServerHttpRequest 获得 HttpServletRequest
        ServletServerHttpRequest sshr = (ServletServerHttpRequest) serverHttpRequest;
        // 获取 request
        HttpServletRequest request = sshr.getServletRequest();

        String includes_str = (String) request.getAttribute("includes");

        if(StringUtils.isBlank(includes_str)) return o;

        this.includes = includes_str.split(",");

        try{
            if(o instanceof List) {
                JSONArray jsonArray = (JSONArray) JSON.toJSON(o);
                return this.converterArrayResponseBody(jsonArray);
            }
            return this.converterResponseBody((JSONObject)JSON.toJSON(o));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return o;
    }

    /**
     * 处理json对象
     * @param expect_json
     */
    private JSONObject converterResponseBody(JSONObject expect_json) {
        expect_json.keySet().stream().filter(p-> !Arrays.asList(this.includes).contains(p)).collect(Collectors.toList())
                .forEach(p-> expect_json.remove(p));
        return expect_json;
    }

    /**
     * 处理对象
     * @param expect_json
     * @return
     */
    private JSONArray converterArrayResponseBody(JSONArray expect_json) {
        expect_json.forEach(p -> this.converterResponseBody((JSONObject)p));
        return expect_json;
    }
}
