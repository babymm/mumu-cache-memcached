package com.lovecws.mumu.cache.memcached;

/**
 * memcached接口
 * @author Administrator
 *
 */
public interface XMemcachClient extends MemcachClient{

	boolean prepend(String key, Object val);

	boolean cas(String key, int exp, Object value, long timeout, long cas);

	boolean append(String key, Object val);

	long decr(String key, int by);

	long incr(String key, int by);

}
