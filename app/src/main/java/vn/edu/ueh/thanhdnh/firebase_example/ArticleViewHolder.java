package vn.edu.ueh.thanhdnh.firebase_example;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleViewHolder extends RecyclerView.ViewHolder {
    ImageView ivArticle;
    TextView txtTitle;
    ArticleAdapter adapter;

    public ArticleViewHolder(@NonNull View itemView, ArticleAdapter adapter) {
        super(itemView);
        ivArticle = itemView.findViewById(R.id.iv_article);
        txtTitle = itemView.findViewById(R.id.txt_title);
        this.adapter = adapter;
    }
}
