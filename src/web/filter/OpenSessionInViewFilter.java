package web.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.ibatis.session.SqlSession;

import util.OpenSessionInViewUtils;

/**
 *  创建SqlSession,保存到ThreadLocal中
 *  
 *  并且在响应的时候, 提交事务,以及关闭SqlSession
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/*" })
public class OpenSessionInViewFilter implements Filter {

	public void destroy() {}

	
	/**
	 * 查询也提交事务
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		SqlSession  sqlSession = OpenSessionInViewUtils.get();
		
		try{
			//放行
			chain.doFilter(request, response);
			//提交
			sqlSession.commit();
		}catch(Exception e){
			//出现异常,回滚事务
			sqlSession.rollback();
		}finally{
			//关闭
			OpenSessionInViewUtils.close();
		}	
	}

	
	public void init(FilterConfig fConfig) throws ServletException {}

}
