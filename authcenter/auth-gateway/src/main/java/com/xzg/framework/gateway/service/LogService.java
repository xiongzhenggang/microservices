package com.xzg.framework.gateway.service;

import com.xzg.framework.gateway.constant.SecurityConstants;
import com.xzg.framework.gateway.feign.MenuService;
import com.xzg.framework.gateway.model.AuditLogDto;
import com.xzg.framework.gateway.model.SysMenu;
import com.xzg.framework.gateway.utils.IPAddrUtil;
import com.xzg.framework.gateway.model.CodeEnum;
import com.xzg.framework.gateway.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class LogService {
    @Value("${application.log.service}")
    private String logService;

    @Autowired
    private WebClient.Builder clientBuilder;

    @Resource
    private MenuService menuService;

    public void sendAuditLog( ServerHttpRequest request){
        String url = request.getURI().getPath();
        if(url.contains(SecurityConstants.PASSWORD_LOGIN_PRO_URL)
                ||url.contains(SecurityConstants.GET_VALIDATE_CODE)){
//            log.info("");
            return ;
        }
        log.info("request path:{}",url);
        Map<String, String> headers = request.getHeaders().toSingleValueMap();
        AuditLogDto dto = new AuditLogDto();
        dto.setIpAddress(IPAddrUtil.getRemoteAddr(request));
        dto.setUserId(Integer.valueOf(headers.get(SecurityConstants.USER_ID_HEADER)));
        dto.setUserName(headers.get(SecurityConstants.USER_HEADER));
        dto.setOrgId(Integer.valueOf(headers.get(SecurityConstants.ORG_ID_HEADER)));
        dto.setMethondType(request.getMethodValue());
        dto.setResourceUrl(url);
        compostMenuInfo(url,dto);
        clientBuilder
                .baseUrl("http://"+logService+"/auditlog")
                .build()
                .method(HttpMethod.POST)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(dto),AuditLogDto.class)
                .retrieve()//请求结果的方法
                .bodyToMono(Result.class)
                .doOnError(e -> {
                    log.error("保存用户审计日志异常：{}",e.getMessage());
                })
                .subscribe(result -> {
                if(!result.getResp_code().equals(CodeEnum.SUCCESS.getCode())) {
                    log.error("保存用户审计日志异常：{}",result.getResp_msg());
                 }
                });
    }


    public List<SysMenu> getAllMenus(){
        return menuService.findAlls();
    }

    public AuditLogDto compostMenuInfo(String uri,AuditLogDto dto){
        List<SysMenu> menus = getAllMenus();
        if(!CollectionUtils.isEmpty(menus)){
            menus.forEach(m->{
                if(m.getUrl().contentEquals(uri)){
                    dto.setDescName(m.getName());
                    return;
                }
            });
        }
        return dto;
    }
}
