package com.zebra.zebraerp.api.Interceptor;


public class RequestLocalInfo {
    private static final ThreadLocal<String> token = new ThreadLocal<>();
    private static final ThreadLocal<Long> managerId = new ThreadLocal<>();
    private static final ThreadLocal<Integer> managerRoleType = new ThreadLocal<>();
    private static final ThreadLocal<String> phone = new ThreadLocal<>();
    private static final ThreadLocal<String> franchiserCode = new ThreadLocal<>();
    private static final ThreadLocal<String> franchiserName = new ThreadLocal<>();


    public static void putToken(String code) {
        token.remove();
        token.set(code);
    }


    public static String getToken() {
        return token.get();
    }

    public static void putManagerId(Long id) {
        managerId.remove();
        managerId.set(id);
    }

    public static Long getManagerId() {
        return managerId.get();
    }

    public static void putManagerRoleType(Integer type) {
        managerRoleType.remove();
        managerRoleType.set(type);
    }

    public static Integer getManagerRoleType() {
        return managerRoleType.get();
    }

    public static void putPhone(String phoneStr) {
        phone.remove();
        phone.set(phoneStr);
    }

    public static String getPhone() {
        return phone.get();
    }

    public static void putFranchiserCode(String code) {
        franchiserCode.remove();
        franchiserCode.set(code);

    }

    public static String getFranchiserCode() {
        return franchiserCode.get();
    }

    public static void putFranchiserName(String name) {

        franchiserName.remove();
        franchiserName.set(name);
    }

    public static String getFranchiserName() {
        return franchiserName.get();
    }


}
