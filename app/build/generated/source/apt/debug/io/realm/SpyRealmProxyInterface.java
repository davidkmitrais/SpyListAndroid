package io.realm;


public interface SpyRealmProxyInterface {
    public int realmGet$id();
    public void realmSet$id(int value);
    public int realmGet$age();
    public void realmSet$age(int value);
    public String realmGet$name();
    public void realmSet$name(String value);
    public String realmGet$gender();
    public void realmSet$gender(String value);
    public String realmGet$password();
    public void realmSet$password(String value);
    public String realmGet$imageName();
    public void realmSet$imageName(String value);
    public boolean realmGet$isIncognito();
    public void realmSet$isIncognito(boolean value);
}
