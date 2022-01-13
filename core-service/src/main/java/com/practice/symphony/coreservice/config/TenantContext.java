package com.practice.symphony.coreservice.config;


public class TenantContext  {
    public static final String TENANT_ID_KEY = "X-Tenant-Id";
    private static final ThreadLocal<TenantContext> context = new ThreadLocal();
    public  int tenantId;


    public TenantContext(int tenantId) {
        this.tenantId = tenantId;
    }

    public static void createContext(int tenantId) {
        if(tenantId<=0){
            throw new IllegalArgumentException("invalid tenant id");
        }
        TenantContext internalContext = new TenantContext(tenantId);
        context.set(internalContext);
    }

    public static int getTenantId() {
        TenantContext internalContext = (TenantContext)context.get();
        return internalContext.tenantId;
    }
}
