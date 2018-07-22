package cn.com.ydream.user.domain;

public enum Gender {
    MAEL, FEMALE;

    public static Gender getDefault(){
        return FEMALE;
    }
}
