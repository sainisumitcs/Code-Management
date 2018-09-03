package com.action.http;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.action.beans.UserRequest;
import com.action.beans.UserResponse;
import com.action.config.Config;
import com.google.gson.Gson;

public class Service {
    
    private static Logger logger = LogManager.getLogger(Service.class);


    public String getService(String getJsonRequest) {

        String status = null;
        Gson gson = new Gson();
        String response = null;

        UserRequest request = null;
        try {
            String jsonReq = getJsonRequest.trim();
            try {
                request = gson.fromJson(jsonReq, UserRequest.class);
                if (request.getMsisdn() == null )
                    throw new Exception("MSISDN NOT FOUND");
            } catch (Exception e) {
            }
            response = sendAndRecive(request);

        } catch (Exception e) {
            logger.error("Exception while process Get Request ",e);
        }

        return response;

    }
    
    private String sendAndRecive(UserRequest request) throws Exception {
        DatagramSocket clientSocket = null;
        UserResponse response = null;
        String jsonResponse   = null;
        try {
            clientSocket = new DatagramSocket();
            clientSocket.setSoTimeout(Config.getReciveTimeOut() * 1000 ); 
  
            long startTime = System.nanoTime();
            sendRequest(request,clientSocket);  // send hashtoken request to Adapter
            
            //Start receiving...
            byte[] buffer = new byte[4096];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            clientSocket.receive(packet);
            String modifiedSentence = new String(packet.getData());
              
            long timeDiff = System.nanoTime() - startTime;
           
            logger.info("Response, Total time=" + timeDiff / 1000000 + "ms , MSISDN=" + request.getMsisdn() + ", tid="+request.getAppTid());
            jsonResponse = getUserResponse(modifiedSentence,request);
 
        } catch (Exception e) {
        	jsonResponse = getUserResponse("timeout",request);
        	logger.info("Excpetion while requesting, msisdn: " + request.getMsisdn());   
        } finally {
            if (clientSocket != null)
                clientSocket.close();
        }
     
        return jsonResponse;
    }

    private void sendRequest(UserRequest request, DatagramSocket clientSocket){
    	try{
    		int localport = clientSocket.getLocalPort();
    		//String sendpacket = "8800544347^8800544321^"+Config.getProcessIp()+"^"+localport+"^<BPARTY>,<BCIRCLE>,<BSTATUS>,<BDB>,BPARTY>#<APARTY>,<ACIRCLE>,<ASTATUS>,<ADB>,APARTY>";
    		String sendpacket = "00075#2011135##^"+request.getMsisdn()+"^"+Config.getProcessIp()+"^"+localport+"^<LEN>#2011135#<ASTATUS>#<APARTY>#<ACIRCLE>#^";
    		InetAddress IPAddress = InetAddress.getByName(Config.getMnpProcessIP()); 
    		DatagramPacket sendPacket = new DatagramPacket(sendpacket.getBytes(), sendpacket.length(), IPAddress, Config.getMnpProcessPort());
    		clientSocket.send(sendPacket);
    		logger.info("Reqest send, MSISDN=" + request.getMsisdn() + ", ip="+Config.getMnpProcessIP()+ ", port="+Config.getMnpProcessPort()+", packet="+sendpacket);
    	}catch (Exception Ex){
    		logger.error("Exception while sending reqest ",Ex);
    	}
    }
    private String getUserResponse(String mnpResponse, UserRequest request) {
    	//8800544347,DL,OFFNET,0,NA#8800544321,DL,OFFNET,0,NA
    	logger.info("Recived:"+mnpResponse);
    	UserResponse response = null;
		String reply = null;
		Gson gson = new Gson();
    	try{
    		response = new UserResponse();
    		if (mnpResponse == null || "timeout".equals(mnpResponse)){	
    	    	response.setStatus("FAIL");
    	    	response.setCircle("UNKNOWN");
    			response.setAppTid(request.getAppTid());
    		}else{	
    			String mnpResAr [] = mnpResponse.split("#");
    			response.setStatus(mnpResAr[2]);
    			response.setCircle(mnpResAr[4]);
    			response.setAppTid(request.getAppTid());
    		}
    		
    }catch (Exception E){
    	logger.info("Excpetion while getUserResponse , msisdn: " + request.getMsisdn(),E);
    }
    reply = gson.toJson(response);
    return reply;
 }
   
}
