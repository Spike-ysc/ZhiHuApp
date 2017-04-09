package com.example.yan.zhihuapp.MessageAndAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yan.zhihuapp.R;

import java.util.List;

/**
 * Created by yan on 2017/4/4.
 */

public class CommentAdapter extends ArrayAdapter<CommentMessage> {
//    private int resourceId;
//    public FunctionAdapter(Context context, int textViewResourceId, List<FunctionMessage> objects){
//        super(context, textViewResourceId, objects);
//        resourceId = textViewResourceId;
//    }
    private int resourceId;
    public CommentAdapter(Context context, int textViewResourceId, List<CommentMessage> objects){
        super(context,textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        FunctionMessage message = getItem(position);
//        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
//        ImageView mImage = (ImageView) view.findViewById(R.id.function_Image);
//        TextView mName = (TextView) view.findViewById(R.id.function_name);
//        mImage.setImageResource(message.getImageId());
//        mName.setText(message.getName());
//        return view;
//    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        CommentMessage message = getItem(position);
        ImageView mImage = (ImageView) view.findViewById(R.id.comment_head);
        TextView mName = (TextView) view.findViewById(R.id.comment_name);
        TextView mMessage = (TextView) view.findViewById(R.id.comment_message);
        TextView mTime = (TextView) view.findViewById(R.id.comment_time);
        mImage.setImageResource(message.getImageId());
        mName.setText(message.getName());
        mMessage.setText(message.getMessage());
        mTime.setText(message.getTime());
        return view;
    }
}
