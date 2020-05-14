package com.it.zy.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.it.zy.gateway.Utils.EncryptUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;

import java.util.*;

/**
 * @author zouyu
 * @description
 * @date 2020/5/13
 */
public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //1 获取令牌内容
        RequestContext ctx = RequestContext.getCurrentContext();
        //从安全上下文拿到用户信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof OAuth2Authentication)){
            return null;
        }
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication)authentication;
        Authentication userAuthentication = oAuth2Authentication.getUserAuthentication();

        OAuth2Request oAuth2Request = oAuth2Authentication.getOAuth2Request();
        Map<String, String> requestParameters = oAuth2Request.getRequestParameters();
        Map<String,Object> jsonToken = new HashMap<>(requestParameters);
        if(authentication !=null){
            //取用户身份
            String principal = userAuthentication.getName();
            //取权限
            List<String> authorities = new ArrayList<>();
            userAuthentication.getAuthorities().stream().forEach(x->authorities.add(((GrantedAuthority)x).getAuthority()));
            jsonToken.put("principal",principal);
            jsonToken.put("authorities",authorities);
        }
       ctx.addZuulRequestHeader("json_token", EncryptUtil.encodeUTF8StringBase64(JSON.toJSONString(jsonToken)));
        return null;
    }
}
