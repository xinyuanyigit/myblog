package com.wkh.project.aop;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.wkh.project.common.ErrorCode;
import com.wkh.project.exception.BusinessException;
import com.wkh.project.utils.JWTUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author wangkehua
 */
@Component
@Slf4j
public class JWTInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse
            response, Object handler) throws Exception {
        String token = request.getHeader("token");
        try {
        // 1. 检验token的有效性
            return JWTUtils.validateToken(token);
        } catch (SignatureVerificationException e) {
            log.error("无效签名 : {}", e.getMessage());
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR, "无效签名");
        } catch (TokenExpiredException e) {
            log.error("token已经过期: {}", e.getMessage());
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR, "token已经过期");
        } catch (AlgorithmMismatchException e) {
            log.error("算法不一致: {}", e.getMessage());
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR, "算法不一致");
        } catch (Exception e) {
            log.error("token无效: {}", e.getMessage());
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR, "token无效");
        }
    }
}
