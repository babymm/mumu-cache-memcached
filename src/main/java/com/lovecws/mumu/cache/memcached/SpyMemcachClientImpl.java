package com.lovecws.mumu.cache.memcached;

import net.spy.memcached.CASResponse;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.GetFuture;
import net.spy.memcached.internal.OperationFuture;

/**
 * spymemcached
 * @author lovecws
 */
public class SpyMemcachClientImpl implements SpyMemcachClient{

	private MemcachedClient memcachedClient;
	public void setMemcachedClient(MemcachedClient memcachedClient) {
		this.memcachedClient = memcachedClient;
	}

	@Override
	public Boolean set(String key,int exp,Object o) {
		OperationFuture<Boolean> future = memcachedClient.set(key, exp, o);
		try {
			return future.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Object get(String key) {
		return memcachedClient.get(key);
	}
	
	@Override
	public Object asyncGet(String key) {
		GetFuture<Object> asyncGet = memcachedClient.asyncGet(key);
		try {
			return asyncGet.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean add(String key,int exp,Object o) {
		try {
			OperationFuture<Boolean> future = memcachedClient.add(key, exp, o);
			return future.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean replace(String key,int exp,Object o) {
		try {
			OperationFuture<Boolean> future = memcachedClient.replace(key, exp, o);
			return future.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean delete(String key) {
		try {
			OperationFuture<Boolean> future = memcachedClient.delete(key);
			return future.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean append(long cas,String key,Object val) {
		try {
			OperationFuture<Boolean> future = memcachedClient.append(cas, key, val);
			return future.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean prepend(long cas,String key,Object val) {
		try {
			OperationFuture<Boolean> future = memcachedClient.prepend(cas, key, val);
			return future.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public String cas(String key,long casId,Object value) {
		CASResponse cas = memcachedClient.cas(key, casId, value);
		return cas.name();
	}
	
	@Override
	public void asyncCAS(String key,long casId,Object value) {
		memcachedClient.asyncCAS(key, casId, value);
	}
	
	@Override
	public long decr(String key,long casId,int by) {
		return memcachedClient.decr(key, by);
	}
	
	@Override
	public void asyncDecr(String key,long casId,int by) {
		memcachedClient.asyncDecr(key, by);
	}
	
	@Override
	public long incr(String key,long casId,int by) {
		return memcachedClient.incr(key, by);
	}
	
	@Override
	public void asyncIncr(String key,long casId,int by) {
		memcachedClient.asyncIncr(key, by);
	}
	
	@Override
	public void close(){
		memcachedClient.shutdown();
	}
}
