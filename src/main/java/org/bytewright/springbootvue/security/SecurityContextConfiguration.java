package org.bytewright.springbootvue.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://stackoverflow.com/questions/41410446/springboot-apache-shiro-java-config
 * <p>
 * TODO Shiro is only available for spring boot 1.x
 */
//@Configuration
public class SecurityContextConfiguration {
    private static Logger LOGGER = LoggerFactory.getLogger(SecurityContextConfiguration.class.getSimpleName());
/*
  @Bean
  public CredentialsMatcher credentialsMatcher() {
    return new HashedCredentialsMatcher() {
      @Override
      public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        LOGGER.info("doCredentialsMatch: {} and {}", token, info);
        return super.doCredentialsMatch(token, info);
      }
    };
  }

  @Bean(name = "realm")
  public Realm realm(CredentialsMatcher matcher) {
    ShiroRealm shiroRealm = new ShiroRealm(matcher);
    return shiroRealm;
  }

  @Bean
  public ShiroFilterChainDefinition shiroFilterChainDefinition() {
    DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();

    // logged in users with the 'admin' role
    chainDefinition.addPathDefinition("/admin/**", "authc, roles[admin]");
    chainDefinition.addPathDefinition("/actuator/**", "authc, roles[admin]");

    // logged in users with the 'document:read' permission
//    chainDefinition.addPathDefinition("/actuator/**", "authc, perms[document:read]");

    // all other paths require a logged in user
    chainDefinition.addPathDefinition("/**", "authc");
    LOGGER.info("Adding Shiro security filter");
    return chainDefinition;
  }
*/
}
