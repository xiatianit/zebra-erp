package com.zebra.zebraerp.api.Interceptor;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.zebra.pony.common.utils.ResultUtils;
import com.zebra.pony.util.JsonUtil;
import com.zebra.zebraerp.common.Exception.ZebraerpException;
import com.zebra.zebraerp.common.constant.ZebraerpConstant;
import com.zebra.zebraerp.common.util.StringUtils;
import com.zebra.zebraerp.dal.dataobject.businessObject.ErpManagerToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;


@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginCheckInterceptor.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        String tokenkey = request.getParameter("token");
        if (StringUtils.isNotEmpty(tokenkey)) {
            String erpTokenValue = stringRedisTemplate.opsForValue().get(ZebraerpConstant.REDIS_PREFIX_ERP_TOKEN + tokenkey);
            if (StringUtils.isEmpty(erpTokenValue)) {
                response.setContentType("text/html; charset=utf-8");
                PrintWriter out = response.getWriter();
                String strJson = JsonUtil.getJsonFromObject(ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, "token失效，请重新登录"));
                out.write(strJson);
                out.flush();
                out.close();
                return false;
            } else {
                //token没有失效刷新token
                ErpManagerToken erpManagerToken = JsonUtil.getObjectFromJson(erpTokenValue, ErpManagerToken.class);
                doRefreshToken(ZebraerpConstant.REDIS_PREFIX_ERP_TOKEN + tokenkey, erpTokenValue);
                //设置相关变量
                RequestLocalInfo.putToken(tokenkey);
                RequestLocalInfo.putManagerRoleType(erpManagerToken.getManagerRoleType());
                RequestLocalInfo.putPhone(erpManagerToken.getPhone());
                RequestLocalInfo.putManagerId(erpManagerToken.getId());
                RequestLocalInfo.putFranchiserName(erpManagerToken.getFranchiserName());
                RequestLocalInfo.putFranchiserCode(erpManagerToken.getFranchiserCode());
            }
        } else {
            if (!HandlerMethod.class.isAssignableFrom(o.getClass())) {
                return true;
            }
            HandlerMethod handlerMethod = (HandlerMethod) o;
            if (!handlerMethod.getMethod().getName().toUpperCase().equals("ERPMANAGERLOGIN") && !handlerMethod.getMethod().getName().toUpperCase().equals("OK")) {
                response.setContentType("text/html; charset=utf-8");
                PrintWriter out = response.getWriter();
                String strJson = JsonUtil.getJsonFromObject(ResultUtils.genResult(ResultUtils.RESULT_STATUS_FAIL, "需要登陆才能访问"));
                out.write(strJson);
                out.flush();
                out.close();
                return false;
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    /**
     * 重新设置token失效时间
     *
     * @param tokenKey
     * @param tokenValue
     */
    private void doRefreshToken(String tokenKey, String tokenValue) {
        stringRedisTemplate.opsForValue().set(tokenKey, tokenValue, ZebraerpConstant.erpTokenEffectiveTime, TimeUnit.SECONDS);
    }
}
