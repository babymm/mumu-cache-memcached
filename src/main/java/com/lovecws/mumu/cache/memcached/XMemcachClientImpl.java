package com.lovecws.mumu.cache.memcached;

import net.rubyeye.xmemcached.MemcachedClient;

/**
 * xmemcached实现
 * @author lovecws
 *
 */
public class XMemcachClientImpl implements XMemcachClient {

	private MemcachedClient memcachedClient;

	public void setMemcachedClient(MemcachedClient memcachedClient) {
		this.memcachedClient = memcachedClient;
	}

	@Override
	public Boolean set(String key, int exp, Object o) {
		try {
			return memcachedClient.set(key, exp, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Object get(String key) {
		try {
			return memcachedClient.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(String key, int exp, Object o) {
		try {
			return memcachedClient.add(key, exp, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean replace(String key, int exp, Object o) {
		try {
			return memcachedClient.replace(key, exp, o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(String key) {
		try {
			return memcachedClient.delete(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean append(String key, Object val) {
		try {
			return memcachedClient.append(key, val);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean prepend(String key, Object val) {
		try {
			return memcachedClient.prepend(key, val);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean cas(String key, int exp, Object value, long timeout, long cas) {
		try {
			return memcachedClient.cas(key, exp, value, timeout, cas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public long decr(String key, int by) {
		try {
			return memcachedClient.decr(key, by);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public long incr(String key, int by) {
		try {
			return memcachedClient.incr(key, by);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
