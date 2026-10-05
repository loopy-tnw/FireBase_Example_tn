package vn.edu.ueh.thanhdnh.firebase_example;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {
    private LayoutInflater mInflater;
    private List<Article> articles;
    private Context context;

    public ArticleAdapter(Context context, List<Article> articles) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.articles = articles;
    }

    public void update(List<Article> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View customView = mInflater.inflate(R.layout.article_item, parent, false);
        return new ArticleViewHolder(customView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article currentArticle = articles.get(position);
        holder.txtTitle.setText(currentArticle.getTitle());
        
        Glide.with(context)
                .load(currentArticle.getUrl())
                .into(holder.ivArticle);
                
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("article", currentArticle);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}
