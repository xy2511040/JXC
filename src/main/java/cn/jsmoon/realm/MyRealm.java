package cn.jsmoon.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.jsmoon.entity.User;
import cn.jsmoon.repository.UserRepository;

/**
 * shiro自定义myrealm
 * @author LTQ
 *
 */
public class MyRealm extends AuthorizingRealm{
	
	@Resource
	private UserRepository userRepository;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 权限认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String userName=(String) token.getPrincipal();
		User user = userRepository.findByUserName(userName);
		if(user!=null) {
			AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), "xxx");
			return authcInfo;
		}else {
			return null;
		}
		
	}

}
