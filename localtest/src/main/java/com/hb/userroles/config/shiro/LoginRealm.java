package com.hb.userroles.config.shiro;

import com.hb.userroles.model.PermissionInfo;
import com.hb.userroles.model.RoleInfo;
import com.hb.userroles.model.UserInfo;
import com.hb.userroles.service.PermissionInfoService;
import com.hb.userroles.service.RoleInfoService;
import com.hb.userroles.service.UserInfoService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class LoginRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RoleInfoService roleInfoService;

    @Autowired
    private PermissionInfoService permissionInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        List<RoleInfo> roles = roleInfoService.findByUsername(username);

        info.setRoles(roleCodes(roles));
        info.setStringPermissions(permissionCodes(roles));

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        UserInfo userInfo = userInfoService.getByName(username);
        if(userInfo == null){
            throw new AuthenticationException("用户名错误");
        }
        return new SimpleAuthenticationInfo(userInfo.getUsername(), userInfo.getPassword(), ByteSource.Util.bytes(password), getName());
    }

    private Set<String> permissionCodes(List<RoleInfo> roles){
        List<String> rst = new ArrayList<>();
        roles.forEach(item -> {
            if(!item.getAvailable()){
                return;
            }
            List<PermissionInfo> permissions = permissionInfoService.findByRoleCode(item.getCode());
            if(CollectionUtils.isNotEmpty(permissions)){
                permissions.forEach(code -> {
                    rst.add(code.getCode());
                });
            }
        });
        return new HashSet<>(rst);
    }

    private Set<String> roleCodes(List<RoleInfo> roles){
        List<String> rst = new ArrayList<>();
        roles.forEach(item -> {
            if(!item.getAvailable()){
                return;
            }
            rst.add(item.getCode());
        });
        return new HashSet<>(rst);
    }
}
