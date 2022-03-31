package com.acme.remote;

import javax.ejb.Remote;
import javax.ejb.Singleton;

@Singleton(name = "RemoteBean")
@Remote
public class DefaultRemoteBean implements RemoteBean {

	@Override
	public String hello (String s) {
		return "Hello " + s;
	}
}
