package com.example.apple.scrapperanalysis30;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputStream inputStream = getResources().openRawResource(R.raw.scrapfile);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {

            File temp = File.createTempFile("fsdafdsf ", " ");

            copyInputStreamToFile(inputStream, temp);
            final OpenReadCsv file;
            file = new OpenReadCsv(temp);
            final String contents = file.viewCsv();

            Button view = (Button) findViewById(R.id.button);
            Button retreive = (Button) findViewById(R.id.button1);
            Button scrap = (Button) findViewById(R.id.button2);
            Button clear = (Button) findViewById(R.id.button3);
            Button xml = (Button) findViewById(R.id.button4);
            final TextView data = (TextView) findViewById(R.id.data);
            data.setMovementMethod(new ScrollingMovementMethod());
            view.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    data.setText(contents);
                }
            });

            final ScrapperConnector sc = new ScrapperConnector();

            File result = new File(getFilesDir().getPath()+"/Report.xml");
            sc.setXml(result);



            retreive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    data.setText(file.printUrl());
                }
            });

            scrap.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    //TESTING THE IF
                    //if(data.getText()!=""){
                   String a=sc.printAppScratch(file);
                   data.setText(a);//}
                }
            });

            assert clear != null;
            clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    data.setText("");
                }
            });

            xml.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    data.setText(sc.getXmlContents());
                }
            });
            ;


        } catch (Exception e) {

        }

    }


    private void copyInputStreamToFile(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
