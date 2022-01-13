package com.practice.symphony.coreservice.config;

public class TenantContext {

	public static final String TENANT_ID_KEY = "X-Tenant-Id";
	//private static String CONNECTION_STRING = "mongodb://admin:password@localhost:27017/ID?readPreference=primary";
	private String CONNECTION_STRING = "mongodb+srv://sampath:sampath@cluster0.mz62n.mongodb.net/ID?retryWrites=true&w=majority";
	private static final ThreadLocal<TenantContext> context = new ThreadLocal<>();
	public final int tenantId;

	public TenantContext(int tenantID) {

		tenantId = tenantID;
		CONNECTION_STRING="mongodb+srv://sampath:sampath@cluster0.mz62n.mongodb.net/ID?retryWrites=true&w=majority";
		CONNECTION_STRING = CONNECTION_STRING.replace("ID", String.valueOf(tenantId));
		System.out.println("Tenant context constructor - id - " + tenantId+"  connection String : -"+CONNECTION_STRING);
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

	public String getDbConnectionString() {
	    TenantContext internalContext = context.get();
		return internalContext.CONNECTION_STRING;
	}

	public static TenantContext getContext() {
		return context.get();
	}

	public static void clear() {
		context.remove();
		System.out.println("After context clearing up, "+context.get()+ "  ");
	}
}
