package com.example.yan.zhihuapp.MessageAndAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yan.zhihuapp.AnswerActivity;
import com.example.yan.zhihuapp.R;

import java.util.List;

/**
 * Created by yan on 2017/4/4.
 */

public class AnswerAdapter extends ArrayAdapter<AnswerMessage> implements View.OnClickListener {
    private int resourceId;


    public AnswerAdapter(Context context, int textViewResourceId, List<AnswerMessage> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        AnswerMessage message = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView mImage = (ImageView) view.findViewById(R.id.answer_image);
        TextView mName = (TextView) view.findViewById(R.id.answer_name);
        TextView mText = (TextView) view.findViewById(R.id.answer_text);
        TextView mAgree = (TextView) view.findViewById(R.id.answer_agree);
        TextView mComment = (TextView) view.findViewById(R.id.answer_comment);
        TextView mTime = (TextView) view.findViewById(R.id.answer_time);
        mImage.setImageResource(message.getImageId());
        mName.setText(message.getName());
        mText.setText(message.getText());
        mText.setTag(message.getAnswerId());
        mAgree.setText(message.getAgree());
        mComment.setText(message.getComment());
        mTime.setText(message.getTime());
        mText.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.answer_text:
                TextView mt = (TextView)v.findViewById(R.id.answer_text);
                Intent intent = new Intent(getContext(), AnswerActivity.class);
                intent.putExtra("to_answer", mt.getTag().toString());
                getContext().startActivity(intent);
                break;
        }
    }
}
