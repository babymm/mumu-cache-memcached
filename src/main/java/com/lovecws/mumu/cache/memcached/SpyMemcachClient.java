package com.lovecws.mumu.cache.memcached;

/**
 * memcached接口
 * @author Administrator
 *
 */
public interface SpyMemcachClient extends MemcachClient{

	Object asyncGet(String key);

	boolean append(long cas, String key, Object val);

	boolean prepend(long cas, String key, Object val);

	String cas(String key, long casId, Object value);

	void asyncCAS(String key, long casId, Object value);

	long decr(String key, long casId, int by);

	void asyncDecr(String key, long casId, int by);

	long incr(String key, long casId, int by);

	void asyncIncr(String key, long casId, int by);

	void close();


}
