package com.casic.texiserver.handler;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import com.casic.texiserver.msg.server.STTexiBody0x08;
import com.casic.texiserver.msg.server.STTexiHeader;
import com.casic.texiserver.msg.server.STTexiMsg;
import com.casic.texiserver.msg.texi.TexiMsg;


public class ServerHandler implements IoHandler {

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

    }

    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
    	 if (message instanceof TexiMsg) {
    		 TexiMsg msg = (TexiMsg) message;
             System.out.println("terminalId:"+msg.getHeader().getMsgId()+",time:"+msg.getHeader().getTimestamp());
         } else {
             System.out.println("获取失败");
         }
    	 
    	 STTexiMsg stmsg = new STTexiMsg();
    	 STTexiHeader stHeader = new STTexiHeader();
    	 
    	 stHeader.setMsgId((short)0x08);
    	 stHeader.setTerminalId("123456654321");
    	 stHeader.setTimestamp("160716141600");
    	
    	 STTexiBody0x08 body = new STTexiBody0x08();
    	 body.setSoftwareVersionId((short)0x05);
    	 body.setUrl("http://123.254.0.105:8080/obu-interface/aa.zip");
    	 
    	 stmsg.setHeader(stHeader);
    	 stmsg.setBody(body);
    	 
    	 session.write(stmsg);

    }

    @Override
    public void messageSent(IoSession session, Object message) throws Exception {

    }

}