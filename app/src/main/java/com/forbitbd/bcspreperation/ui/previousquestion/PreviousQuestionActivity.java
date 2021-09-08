package com.forbitbd.bcspreperation.ui.previousquestion;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.forbitbd.bcspreperation.R;
import com.forbitbd.bcspreperation.model.Order;
import com.forbitbd.bcspreperation.model.PreviousQuestion;
import com.forbitbd.bcspreperation.utils.BaseActivity;
import com.forbitbd.bcspreperation.utils.Constant;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class PreviousQuestionActivity extends BaseActivity implements PreviousQuestionContract.View{

    private PreviousQuestionPresenter mPresenter;
    private PreviousQuestionsAdapter adapter;
    private Order order;
    private Toolbar toolbar;
    private Bitmap bitmap;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previousquestion);

        this.order = (Order) getIntent().getSerializableExtra(Constant.ORDER);
        mPresenter = new PreviousQuestionPresenter(this);


        setupToolbar(R.id.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(order.getBangla_name());

        PreviousQuestion previousQuestion = new PreviousQuestion();
        previousQuestion.setType(order.getType());
        previousQuestion.setOrder(order.getOrder());

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new PreviousQuestionsAdapter();
        recyclerView.setAdapter(adapter);

        mPresenter.getPreviousQuestions(previousQuestion);

        linearLayout = findViewById(R.id.layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.download_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.download){
            bitmap = LoadBitmap(linearLayout,linearLayout.getWidth(),linearLayout.getHeight());
            createPdf();

        }
        return super.onOptionsItemSelected(item);
    }

    private Bitmap LoadBitmap(View view, int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.draw(canvas);

        Log.d("JJJJJJ", "LoadBitmap");
        return bitmap;
    }

    private void createPdf() {
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float width = displayMetrics.widthPixels;
        float height = displayMetrics.heightPixels;
        int convertWidth = (int) width,convertHeight = (int) height;

        PdfDocument pdfDocument = new PdfDocument();
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(convertWidth,convertHeight,1).create();
        PdfDocument.Page page = pdfDocument.startPage(pageInfo);
        Canvas canvas = page.getCanvas();

        Paint paint = new Paint();
        canvas.drawPaint(paint);

        bitmap = Bitmap.createScaledBitmap(bitmap,convertWidth,convertHeight,false);

        canvas.drawBitmap(bitmap,0,0,null);
        pdfDocument.finishPage(page);

        String targetPdf = "/bcs/page.pdf";
        File file;
        file = new File(targetPdf);

        Log.d("JJJJJ", "Pdf Created Successfully");
        try {
            pdfDocument.writeTo(new FileOutputStream(file));
        }catch (Exception e){
            pdfDocument.close();
            openPdf();
        }
    }

    private void openPdf() {
        File file = new File("/bcs/page.pdf");
        if (file.exists()){
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri uri = Uri.fromFile(file);
            intent.setDataAndType(uri,"application/pdf");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            try {
                startActivity(intent);
            }catch (Exception e){
                showToast("No Application For Pdf View!");
            }
        }
    }

    @Override
    public void renderQuestions(List<PreviousQuestion> previousQuestions) {
        for (PreviousQuestion x : previousQuestions) {
            adapter.AddQuestion(x);
        }
    }

    @Override
    public void showToast(String toastMessage) {
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void afterAdClose() {
//        createAd();
    }
}
