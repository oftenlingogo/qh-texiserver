package com.casic.texiserver.handler;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import com.casic.texiserver.msg.server.STTexiMsg;

public class ClientHandler implements IoHandler {

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status)
            throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause)
            throws Exception {
        // TODO Auto-generated method stub
    }

    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
    	 if (message instanceof STTexiMsg) {
    		 STTexiMsg msg = (STTexiMsg) message;
             System.out.println("terminalId:"+msg.getHeader().getMsgId()+",time:"+msg.getHeader().getTimestamp());
         } else {
             System.out.println("获取失败");
         }
    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        // TODO Auto-generated method stub
    }

}