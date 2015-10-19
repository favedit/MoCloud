package org.mo.content.core.common.message;

//============================================================
//<T>短信发送接口。</T>
//============================================================
public interface IMessageConsole {
    // ============================================================
    // <T>短信发送</T>
    // @param mobile 手机号
    // @param msgText 短信内容
    // @return 处理结果
    // ============================================================
    public int sendBatchMessage(String mobile, String msgText);

}
