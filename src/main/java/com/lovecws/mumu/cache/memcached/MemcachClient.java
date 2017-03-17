package com.lovecws.mumu.cache.memcached;

/**
 * memcached接口
 * @author Administrator
 *
 */
public interface MemcachClient {

	Boolean set(String key, int exp, Object o);

	Object get(String key);

	boolean add(String key, int exp, Object o);

	boolean replace(String key, int exp, Object o);

	boolean delete(String key);

}
