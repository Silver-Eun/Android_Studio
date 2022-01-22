package ddazua.hs.my_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class PopupMenuActivity extends AppCompatActivity {

    Button menu_show_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);

        menu_show_btn = findViewById(R.id.menu_show_btn);
        menu_show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //메뉴호출 버튼 클릭시 팝업메뉴를 생성
                PopupMenu popup = new PopupMenu(PopupMenuActivity.this, v);
                //팝업메뉴에 뿌려줄 메뉴 리소스 파일 참조
                getMenuInflater().inflate(R.menu.my_menu, popup.getMenu());

                //팝업메뉴에 이벤트 감지자 등록
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch(item.getItemId()){
                            case R.id.add :
                                Toast.makeText(PopupMenuActivity.this, "add button click",
                                        Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.edit :
                                break;

                            case R.id.email :
                                break;
                        }
                        //팝업메뉴는 리턴값에 관계없이 동작
                        return false;
                    }
                });

                //팝업메뉴를 화면에 출력
                popup.show();
            }
        });
    }
}