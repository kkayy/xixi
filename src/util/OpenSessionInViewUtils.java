package util;

import org.apache.ibatis.session.SqlSession;

public class OpenSessionInViewUtils {
	private static  ThreadLocal<SqlSession>  tl = new ThreadLocal<>();
	
	public static SqlSession  get(){
		if(tl.get() == null){
			SqlSession sqlSession = MybatisUtils.getSqlSessionFactory().openSession();
			tl.set(sqlSession);
		}
		return tl.get();
	}
	
	
	public static  void close(){
		SqlSession sqlSession = tl.get();
		if(sqlSession != null){
			//关闭sqlSession
			sqlSession.close();
			//移除ThreadLocal中存放的SqlSessions
			tl.remove();
		}
	}
	
	
}
