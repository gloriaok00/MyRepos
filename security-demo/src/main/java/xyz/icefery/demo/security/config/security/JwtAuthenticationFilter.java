package xyz.icefery.demo.security.config.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import xyz.icefery.demo.security.config.JwtConfig;
import xyz.icefery.demo.security.entity.User;
import xyz.icefery.demo.security.entity.UserDevice;
import xyz.icefery.demo.security.mapper.UserDeviceMapper;
import xyz.icefery.demo.security.mapper.UserMapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Token 过滤器
@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtConfig jwtConfig;
    @Autowired
    private SecurityUserDetailsService securityUserDetailsService;
    @Autowired
    private UserDeviceMapper userDeviceMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 从请求头中拿到 token
        String token = request.getHeader(jwtConfig.getTokenHeader());
        if (token != null && !StringUtils.isBlank(token)) {
            String username = null;
            try {
                username = jwtConfig.extractUsername(token);
            } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {

                log.info("Token 过期或有误");

            }
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // 检验 token
                boolean valid = jwtConfig.validateToken(token, username);
                if (valid) {
                    // 加载登录信息(用户名 | 密码 | 角色)
                    UserDetails userDetails = securityUserDetailsService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    //System.out.println(userDetails.getAuthorities());
                    ArrayList<GrantedAuthority> roles = (ArrayList<GrantedAuthority>) userDetails.getAuthorities();
                    for (GrantedAuthority role : roles) {
                        if (role.getAuthority().equals("deviceManager")) {
                            User u=userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername,username));
                            List<UserDevice> deviceList=userDeviceMapper.selectList(new LambdaQueryWrapper<UserDevice>().eq(UserDevice::getUserId, u.getId()));
                            request.setAttribute("id", deviceList.get(0).getDeviceId());
                        }
                    }
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        chain.doFilter(request, response);
    }
}
