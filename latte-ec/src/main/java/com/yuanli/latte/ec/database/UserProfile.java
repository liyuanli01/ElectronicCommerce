package com.yuanli.latte.ec.database;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * ElectronicCommerce
 *
 * @author liyuanli
 * @data 2018/6/12
 */

@Entity(nameInDb = "user_profile")
public class UserProfile {

    /**
     * userId必须是long,@Id标明主键，(autoincrement = true)括号里代表自增
     */
    @Id
    private long userId = 0;
    private String name = null;
    private String avatar = null;
    private String gender = null;
    private String address = null;

    @Generated(hash = 1202698052)
    public UserProfile(long userId, String name, String avatar, String gender,
            String address) {
        this.userId = userId;
        this.name = name;
        this.avatar = avatar;
        this.gender = gender;
        this.address = address;
    }

    @Generated(hash = 968487393)
    public UserProfile() {
    }

    /**
     * Generated 这个是build后greendao自动生成的，这个注解理解为防止重复，
     * 每一块代码生成后会加个hash作为标记。 官方不建议你去碰这些代码，
     * 改动会导致里面代码与hash值不符。
     */

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
