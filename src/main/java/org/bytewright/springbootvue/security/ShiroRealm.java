package org.bytewright.springbootvue.security;

import com.google.common.collect.ImmutableSet;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroRealm extends AuthorizingRealm {
  private static Logger LOGGER = LoggerFactory.getLogger(ShiroRealm.class.getSimpleName());

  public ShiroRealm(CredentialsMatcher matcher) {
    super(matcher);
  }

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    LOGGER.info("need AuthorizationInfo for: {}", principals);
    return new SimpleAuthorizationInfo(ImmutableSet.of("Admin"));
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    LOGGER.info("need AuthenticationInfo for: {}", token);
    return new SimpleAuthenticationInfo("myPrincipal", "mycreds", "myGoRealmName");
  }
}
