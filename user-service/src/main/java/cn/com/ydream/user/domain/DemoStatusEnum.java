package cn.com.ydream.user.domain;

public enum DemoStatusEnum {
    DISABLE, ENABLE;
    public static DemoStatusEnum getDefault(){
        return ENABLE;
    }
}
