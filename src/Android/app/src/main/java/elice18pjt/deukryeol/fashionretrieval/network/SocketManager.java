package elice18pjt.deukryeol.fashionretrieval.network;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketManager {
    private final String ip = "";
    private final int port = 1234;
    private Socket socket = null;
    private BufferedReader networkReader = null;
    private BufferedWriter networkWriter = null;
    private String inputBuffer;

    public SocketManager(){
        setSocket();
    }

    public void setSocket(){
        // 소켓을 열고 BufferedWriter와 reader를 생성합니다. Reader는 곧바로 서버로부터의 응답을
        // 듣기 시작합니다.
        try{
            socket = new Socket(ip, port);
            networkWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            networkReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }catch(IOException e){
            e.printStackTrace();
            //Todo: Socket 연결에 실패했을 경우 처리
        }
        listenSocket.start();
    }

    public void closeSocket(){
        //listen을 중지하고 Socket을 닫습니다.
        listenSocket.interrupt();
        if(socket != null){
            try {
                socket.close();
            } catch (IOException e) {
                Log.e("SocketManager", "Failed to close Socket");
                e.printStackTrace();
            }
        }
    }

    private Thread listenSocket = new Thread() {
        //서버로부터의 입력을 계속 듣습니다.

        public void run() {
            try{
                String line;
                while (true) {
                    line = networkReader.readLine();
                    inputBuffer = line;
                    //Log.e("SocketManager", inputBuffer);
                }
            } catch (Exception e){

            }
        }
    };

    public void sendJSON(JSONObject obj){
        //보내기전에 inputBuffer를 초기화하고 보냄으로서 응답을 받습니다.
        inputBuffer = "";

        if(networkWriter != null){
            PrintWriter out = new PrintWriter(networkWriter, true);
            out.println(obj.toString());
            Log.e("SocketManager", obj.toString());
        }
        else{
            Log.e("SocketManager", "NetworkWrite NULL");
        }
    }

    public JSONObject getJSON(){
        //서버로부터 받은 정보를 inputBuffer에서 꺼내서 파싱
        if(networkReader != null){
            String line = "";
            JSONObject obj = null;
            while(inputBuffer.equalsIgnoreCase(""));
            line = inputBuffer;

            try {
                obj = new JSONObject(line);
            } catch (JSONException e) {
                Log.e("SocketManager", "Failed to convert JSON");
                e.printStackTrace();
            }

            return obj;
        }
        else{
            Log.e("SocketManager", "NetworkReader NULL");
            return null;
        }
    }

    public JSONArray getJSONArray(){
        //서버로부터 받은 정보를 inputBuffer에서 꺼내서 파싱
        if(networkReader != null){
            String line = "";
            JSONArray obj = null;
            while(inputBuffer.equalsIgnoreCase(""));
            line = inputBuffer;

            Log.e("SocketManager", "line : " + line);

            try {
                obj = new JSONArray(line);
            } catch (JSONException e) {
                Log.e("SocketManager", "Failed to convert JSON");
                e.printStackTrace();
            }

            return obj;
        }
        else{
            Log.e("SocketManager", "NetworkReader NULL");
            return null;
        }
    }


}
