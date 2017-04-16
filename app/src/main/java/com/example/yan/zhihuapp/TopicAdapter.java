package com.example.yan.zhihuapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by yan on 2017/4/13.
 */

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.ViewHolder>{
    private List<TopicMessage> mTopic;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View topicView;
        TextView myTopic;

        public ViewHolder(View itemView) {
            super(itemView);
            topicView = itemView;
            myTopic = (TextView) itemView.findViewById(R.id.topic_text);
        }
    }
    public TopicAdapter(List<TopicMessage> message){
        mTopic = message;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.topic_list,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.topicView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                TopicMessage topic = mTopic.get(position);
                Toast.makeText(v.getContext(), "you click"+topic.getTopic(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TopicMessage topic = mTopic.get(position);
        holder.myTopic.setText(topic.getTopic());
    }

    @Override
    public int getItemCount() {
        return mTopic.size();
    }
}
