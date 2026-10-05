package vn.edu.ueh.thanhdnh.firebase_example;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    ImageView ivDetailImage;
    TextView txtDetailTitle, txtDetailContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ivDetailImage = findViewById(R.id.iv_detail_image);
        txtDetailTitle = findViewById(R.id.txt_detail_title);
        txtDetailContent = findViewById(R.id.txt_detail_content);

        Article article = (Article) getIntent().getSerializableExtra("article");
        if (article != null) {
            txtDetailTitle.setText(article.getTitle());
            txtDetailContent.setText(article.getContent());
            Glide.with(this).load(article.getUrl()).into(ivDetailImage);
        }
    }
}
