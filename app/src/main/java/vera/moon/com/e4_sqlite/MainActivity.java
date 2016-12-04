package vera.moon.com.e4_sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = (WebView)findViewById(R.id.webView);
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());
        //web.loadUrl("http://www.google.com");

        web.loadData("<html><body><h1> Hi there!</h1><p>This is my ws</p></body></html>","text/html","UTF-8");

        try{

            //Create DB
            SQLiteDatabase database = this.openOrCreateDatabase("Prueba",MODE_PRIVATE,null);

            //Add primary key
            /*database.execSQL("CREATE table if not exists usuario (name varchar, age integer(3), id integer primary key)");
            database.execSQL("insert into usuario(name,age) values('Vera',24)");
            database.execSQL("insert into usuario(name,age) values('John',16)");
            database.execSQL("insert into usuario(name,age) values('Alex',25)");
            database.execSQL("insert into usuario(name,age) values('Viejo',32)");*/

            //put table into DB
            /*database.execSQL("create table if not exists users (name varchar(50), age int(3))");

            //execute insert data
            database.execSQL("insert into users(name,age) values('Vera',24)");
            database.execSQL("insert into users(name,age) values('John',16)");
            database.execSQL("insert into users(name,age) values('Alex',25)");
            database.execSQL("insert into users(name,age) values('Viejo',32)");*/

            //delte items
            //database.execSQL("delete from usuario where id = 1");

            //get out the data from the db --- Cursor
            Cursor obj = database.rawQuery("select * from usuario",null);
            int namesIndex = obj.getColumnIndex("name");
            int ageIndex = obj.getColumnIndex("age");
            int index = obj.getColumnIndex("id");

            obj.moveToFirst();
            while(obj != null){

                Log.w("Name",obj.getString(namesIndex));
                Log.w("Age",obj.getInt(ageIndex)+"");
                Log.w("Id",obj.getInt(index)+"");

                obj.moveToNext();
            }

        }
        catch(Exception r){

        }
    }
}
