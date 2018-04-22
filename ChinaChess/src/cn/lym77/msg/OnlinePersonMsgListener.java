package cn.lym77.msg;

/**
 * @author shen
 * @version 1.0.0
 * @since 2018/4/22
 */
public interface OnlinePersonMsgListener {

    void onReceiveOnlinePersonMsg(Msg msg);

    void onReceiveOnlinePersonErr(String data);
}
