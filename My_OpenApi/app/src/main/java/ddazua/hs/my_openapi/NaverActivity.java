package ddazua.hs.my_openapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.text.ParseException;
import java.util.ArrayList;

public class NaverActivity extends AppCompatActivity {

    static EditText search;
    ListView myListView;
    Button search_btn;
    Parser parser;
    ArrayList<BookModel> list;
    ViewModelAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naver);

        search = findViewById(R.id.search);
        myListView = findViewById(R.id.myListView);
        search_btn = findViewById(R.id.search_btn);
        parser = new Parser();

        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                list = new ArrayList<>();
                adapter = null;

                new NaverAsync().execute("홍", "길");//doInBackground 메소드 호출
            }
        });
    }

    /*
    AsyncTask클래스는 생성시에 세계의 제너릭타입을 갖는다.
    1. doInBackground()의 파라미터로 전달될 타입
    2. UI의 진행상황을 관리하는 onProgressUpdate()가 오버라이딩 되어 있다면, 이 메소드에서
        사용할 타입
    3. 작업 굘과를 반영하는 onPostExecute의 파라미터로 전달될 타입
    */
    class NaverAsync extends AsyncTask<String, String, ArrayList<BookModel>> {

        @Override
        protected ArrayList<BookModel> doInBackground(String... strings) {
            //필수!1 각종 반복이나 제어 등 주된 처리 로직을 담당
            return parser.connectNaver(list);
        }

        @Override
        protected void onPostExecute(ArrayList<BookModel> bookModels) {

            if(adapter == null){
                adapter = new ViewModelAdapter(NaverActivity.this,
                        R.layout.book_item, bookModels);

                //리스트 뷰에 어댑터 세팅
                myListView.setAdapter(adapter);

            }
        }
    }
}