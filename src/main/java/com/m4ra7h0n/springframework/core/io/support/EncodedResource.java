package com.m4ra7h0n.springframework.core.io.support;

import com.m4ra7h0n.springframework.core.io.Resource;

import java.nio.charset.Charset;

public class EncodedResource {

	public EncodedResource(Resource resource) {
		this.resource = resource;
	}

	private final Resource resource;

	private String encoding;

	private Charset charset;

	public Resource getResource() {
		return null;
	}

	public String getEncoding() {
		return null;
	}
}