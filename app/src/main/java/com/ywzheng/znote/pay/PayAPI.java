package com.ywzheng.znote.pay;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;

import com.ywzheng.znote.pay.alipay.AlipayAPI;
import com.ywzheng.znote.pay.alipay.PayResult;


/**
 */
public class PayAPI {
    private Activity context;
    private final int Ali_PAY_FLAG = 1;

    public PayAPI(Activity context) {
        this.context = context;
    }

    //** 使用支付宝进行支付 */
    public void doAliPay(String subject, String content, String price) {
        new AliPayThread(subject, content, price).start();
    }

    /* =============== 支付宝-微信支付处理支付结果 =============== */
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case Ali_PAY_FLAG: {
                    PayResult payResult = new PayResult((String) msg.obj);
                    /**
                     * 同步返回的结果必须放置到服务端进行验证（验证的规则请看https://doc.open.alipay.com/doc2/
                     * detail.htm?spm=0.0.0.0.xdvAU6&treeId=59&articleId=103665&
                     * docType=1) 建议商户依赖异步通知
                     */
                    // String resultInfo = payResult.getResult();// 同步返回需要验证的信息

                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        Toast.makeText(context, "支付成功", Toast.LENGTH_SHORT).show();
                    } else {
                        // 判断resultStatus 为非"9000"则代表可能支付失败
                        // "8000"代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(context, "支付结果确认中", Toast.LENGTH_SHORT).show();
                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            Toast.makeText(context, "支付失败", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;
                }
            }
        }

        ;
    };

    /**
     * 支付宝支付异步任务
     *
     * @author Kylin
     */
    private class AliPayThread extends Thread {
        String subject;
        String content;
        String price;

        public AliPayThread(String subject, String content, String price) {
            this.subject = subject;
            this.content = content;
            this.price = price;
        }

        @Override
        public void run() {
            String result = AlipayAPI.pay(context, subject, content, price);
            Message msg = new Message();
            msg.what = Ali_PAY_FLAG;
            msg.obj = result;
            mHandler.sendMessage(msg);
        }
    }
}