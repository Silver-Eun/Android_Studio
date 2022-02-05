package ddazua.hs.my_openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.BufferedInputStream;
import java.net.URL;
import java.util.ArrayList;

public class ViewModelAdapter extends ArrayAdapter<BookModel> {

    Context context;
    ArrayList<BookModel> list;
    BookModel vo;
    int resource;

    public ViewModelAdapter(@NonNull Context context, int resource, ArrayList<BookModel> list) {
        super(context, resource, list);

        this.list = list;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater linf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = linf.inflate(resource, null);

        //리스트뷰에 표현할 책 정보 객체
        vo = list.get(position);

        TextView title = convertView.findViewById(R.id.book_title);
        TextView author = convertView.findViewById(R.id.book_author);
        TextView price = convertView.findViewById(R.id.book_price);
        ImageView img = convertView.findViewById(R.id.book_img);

        title.setText("title : " + vo.getB_title());
        author.setText("author : " + vo.getB_author());
        price.setText("price : " + vo.getB_price());

        //이미지 로드
        new ImgAsync(img, vo).execute();
        return convertView;
    }//getView()

    //통신을 통해서 이미지를 로드할 Async클래스
    class ImgAsync extends AsyncTask<String, String, Bitmap>{

        Bitmap bm;
        ImageView mlmg;
        BookModel model;

        public ImgAsync(ImageView mlmg, BookModel model) {
            this.mlmg = mlmg;
            this.model = model;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            try{

                URL img_url = new URL(model.getB_img());
                //얻어온 경로를 통해 로드작업을 수행(스트림 사용)
                BufferedInputStream bis = new BufferedInputStream(img_url.openStream());
                bm = BitmapFactory.decodeStream(bis);

                bis.close();
            }catch(Exception e){

            }
            return bm;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            mlmg.setImageBitmap(bitmap);
        }
    }
}