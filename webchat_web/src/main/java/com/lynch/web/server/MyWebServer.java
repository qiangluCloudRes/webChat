package com.lynch.web.server;


import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.lynch.biz.bo.BizResult;
import com.lynch.biz.bo.ProtocolInfo;
import com.lynch.biz.bo.UserInfo;
import com.lynch.biz.service.UserService;
import com.lynch.web.config.ApplicationContextRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by LuQiang on 2017/7/1.
 */
@ServerEndpoint("/websocket")
@Component
public class MyWebServer {

    private static final Gson gson = new Gson();

    @Autowired
    private UserService userService;

    private static int onLineCount = 0;
    private static CopyOnWriteArrayList<MyWebServer> webSocketConnection = new CopyOnWriteArrayList();
    private static Map<String,MyWebServer> connectSession = new ConcurrentHashMap<String, MyWebServer>();
    private Session session;

    private ApplicationContext applicationContext = ApplicationContextRegister.getApplicationContext();

    @OnOpen
    public void onOpen(Session session){
        if (null == userService){
            userService = applicationContext.getBean(UserService.class);
        }
        this.session = session;
//        webSocketConnection.add(this);
        connectSession.put(session.getId(),this);
        addOnlineCount();

    }
    @OnClose
    public void onClose(){
//        webSocketConnection.remove(this);
        connectSession.remove(this.session.getId());
        subOnlineCount();
        System.out.println("有新链接加入!当前在线人数为" + getOnlineCount());

    }

    @OnMessage
    public void onMessage(String message,Session session) throws IOException{
        ProtocolInfo protocolInfo = gson.fromJson(message,ProtocolInfo.class);
        BizResult result;
        if (protocolInfo.getType() == 0){
            result = userService.login(protocolInfo.getUserInfo().getUid(),protocolInfo.getUserInfo().getPassWord());
            if (result.isResult()){
                protocolInfo.getUserInfo().setLogin(1);
                //todo 遍历channel在线人员，发送上线通知
            }else {
                protocolInfo.getUserInfo().setLogin(0);
            }
            MyWebServer myWebServer = connectSession.get(session.getId());
            myWebServer.sendMessage(JSONObject.toJSONString(protocolInfo));
        }else {
            result = userService.isLogin(protocolInfo.getUserInfo().getUid());
            if (result.isResult()){
                //todo 遍历用户所在的群，并发送消息
            }else {
                MyWebServer myWebServer = connectSession.get(session.getId());
                UserInfo userInfo = new UserInfo();
                userInfo.setLogin(0);
                protocolInfo.setUserInfo(userInfo);
                protocolInfo.setType(0);
                myWebServer.sendMessage(JSONObject.toJSONString(protocolInfo));
            }
        }


//        for (MyWebServer se : webSocketConnection){
//            se.sendMessage(message);
//        }

    }



    public void sendMessage(String message) throws IOException{
        this.session.getBasicRemote().sendText(message);
    }

    public static synchronized  int getOnlineCount (){
        return MyWebServer.onLineCount;
    }

    public static synchronized void addOnlineCount (){
        MyWebServer.onLineCount++;
    }

    public static synchronized void subOnlineCount (){
        MyWebServer.onLineCount--;
    }
}
