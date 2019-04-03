package com.android.dwealthapp.model;

public class GetAccessToken {

    /**
     * access_token : eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJOL0EiXSwiZXhwIjoxNTQ5Mjk3ODYxLCJhdXRob3JpdGllcyI6WyJST0xFX1NVUEVSX0FETUlOIl0sImp0aSI6IjE5ZTM5ZjRlLWI5MDMtNDc3My04Mzc0LWM1N2VmNzNiNzU5MCIsImNsaWVudF9pZCI6ImxiYjJuNDF4M3RhZHh3NmZoZDh0NHZncnN2IiwiYXBwcyI6Im51Y2xldXMscHJvdG9uLGVsZWN0cm9uLGh5ZHJvIn0.Bl7c1ZQ87M8gLthZPjPYrmzjhxiqiaAnykdSruLe0lMv8n3ofoHSmOiZM-yOGhCHJtgP-_yFCCRmK2Tm4zqxz58wligRIH82nWLMbouOjncjO41l4bNJzP3mNV6ATfE0zP5-TBL4VrC0Ac18AVXDWu2Ha_xaR3NgRWqG9-Or91E_hzuFUyEvhrpEHfAxdW6UJpDflpNY61i_J6qQBJsGxaG2uA18MsUYfG4yDunnriBMvpP2-4wNkjBq72Qpoq5AMaSlKZmrWsKjJ7Wqd5sN5QDtVoNsJrN9xt7qRH-ORQesOEkbr4MIWzw5OCNpnEstRYt0LVDKI685DXUAnIHYVQ
     * token_type : bearer
     * expires_in : 86399
     * scope : N/A
     * apps : nucleus,proton,electron,hydro
     * jti : 19e39f4e-b903-4773-8374-c57ef73b7590
     */

    private String access_token;
    private String token_type;
    private int expires_in;
    private String scope;
    private String apps;
    private String jti;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getApps() {
        return apps;
    }

    public void setApps(String apps) {
        this.apps = apps;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }
}
