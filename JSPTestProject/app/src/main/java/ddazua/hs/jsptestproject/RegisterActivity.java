package ddazua.hs.jsptestproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterActivity extends AppCompatActivity {

    EditText edit_id, edit_pwd;
    Button btn_regi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edit_id = findViewById(R.id.edit_id);
        edit_pwd = findViewById(R.id.edit_pwd);
        btn_regi = findViewById(R.id.btn_regi);

        btn_regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = edit_id.getText().toString();
                String pwd = edit_pwd.getText().toString();
                String result = "id="+id+"&pwd"+pwd;//서버로 전달할 파라미터

                new Task().execute(result, "type_regi");
            }
        });
    }//onCreate()

    //회원가입용 Task클래스
    class Task extends AsyncTask<String, Void, String>{

        //서버의 IP번호
        public String ip = "192.168.0.7";
        String sendMsg, receiveMsg;
        String serverip = "http://"+ip+"9090/AndroidJSPTest/list.jsp";//연결할 jsp주소

        @Override
        protected String doInBackground(String... strings) {
            try {

                String str;
                URL url = new URL(serverip);

                //서버연결
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
                conn.setRequestMethod("POST");
                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());

                //list.jsp?id=hong&pwd=1111&type=type_regi
                sendMsg = strings[0] + "&type=" + strings[1];

                //서버로 값 전송
                osw.write(sendMsg);
                osw.flush();

                //전송이 완료되면 서버(JSP)에서 처라한 결과값을 받는다
                if(conn.getResponseCode() == conn.HTTP_OK){
                    InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                    BufferedReader reader = new BufferedReader(tmp);

                    StringBuffer buffer = new StringBuffer();
                    while((str = reader.readLine())!=null){
                            buffer.append(str);
                    }//while

                    //서버에서 넘겨준 JSON타입의 결과값
                    receiveMsg = buffer.toString();

                    JSONArray jarray = new JSONObject(receiveMsg).getJSONArray("res");

                    JSONObject jobject = jarray.getJSONObject(0);
                    String result = jobject.optString("result");

                    if(result.equalsIgnoreCase("success")){
                        receiveMsg = "regi success";
                    }else{
                        receiveMsg = "regi failed";
                    }
                }

            }catch (Exception e){

            }
            return receiveMsg;
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(RegisterActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }
}