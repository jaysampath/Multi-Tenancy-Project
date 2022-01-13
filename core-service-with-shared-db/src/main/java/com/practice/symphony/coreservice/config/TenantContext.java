package com.practice.symphony.coreservice.config;

public class TenantContext {

	public static final String TENANT_ID_KEY = "X-Tenant-Id";

	private static final ThreadLocal<TenantContext> context = new ThreadLocal<>();
	public final int tenantId;

	public TenantContext(int tenantID) {

		tenantId = tenantID;

		System.out.println("Tenant context constructor - id - " + tenantId);
	}

	public static void createContext(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("invalid tenant id");
		}
		TenantContext internalContext = new TenantContext(id);
		context.set(internalContext);
	}

	public static int getTenantId() {
		TenantContext internalContext = context.get();
		return internalContext.tenantId;
	}

	public static TenantContext getContext() {
		return context.get();
	}

	public static void clear() {
		context.remove();
		System.out.println("After context clearing up, " + context.get() + "  ");
	}
}
