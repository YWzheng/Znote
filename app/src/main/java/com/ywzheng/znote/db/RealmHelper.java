package com.ywzheng.znote.db;

import android.content.Context;

import com.ywzheng.znote.http.model.ReadStateBean;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by codeest on 16/8/16.
 */

public class RealmHelper {

    private static final String DB_NAME = "myRealm.realm";

    private Realm mRealm;

    public RealmHelper(Context mContext) {
        mRealm = Realm.getInstance(new RealmConfiguration.Builder(mContext)
                .deleteRealmIfMigrationNeeded()
                .name(DB_NAME)
                .build());
    }

    /**
     * 增加 阅读记录
     * @param id
     */
    public void insertNewsId(int id) {
        mRealm.beginTransaction();
        ReadStateBean bean = mRealm.createObject(ReadStateBean.class);
        bean.setId(id);
        mRealm.commitTransaction();
    }
    /**
     * 删除 收藏记录
     * @param id
     */
    public void deleteLikeBean(String id) {
        ReadStateBean data = mRealm.where(ReadStateBean.class).equalTo("id",id).findFirst();
        mRealm.beginTransaction();
        data.deleteFromRealm();
        mRealm.commitTransaction();
    }

    /**
     * 查询 阅读记录
     * @param id
     * @return
     */
    public boolean queryNewsId(int id) {
        RealmResults<ReadStateBean> results = mRealm.where(ReadStateBean.class).findAll();
        for(ReadStateBean item : results) {
            if(item.getId() == id) {
                return true;
            }
        }
        return false;
    }
    /**
     * 修改
     * @param id
     * @param time
     * @param isPlus
     */
    public void changeLikeTime(String id ,int time, boolean isPlus) {
        ReadStateBean bean = mRealm.where(ReadStateBean.class).equalTo("id", id).findFirst();
        mRealm.beginTransaction();
        if (isPlus) {
            bean.setId(++time);
        } else {
            bean.setId(--time);
        }
        mRealm.commitTransaction();
    }

}
