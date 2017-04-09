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

public class AnswerAdapter extends ArrayAdapter<AnswerMessage> {
    private int resourceId;


    public AnswerAdapter(Context context, int textViewResourceId, List<AnswerMessage> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        LetterMessage message = getItem(position);
//        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
//        ImageView mImage = (ImageView) view.findViewById(R.id.letter_topic_image);
//        TextView mName = (TextView) view.findViewById(R.id.letter_name);
//        ImageView mLogo = (ImageView) view.findViewById(R.id.letter_name_logo);
//        TextView mMessage = (TextView) view.findViewById(R.id.letter_message);
//        TextView mTime = (TextView) view.findViewById(R.id.letter_time);
//        mImage.setImageResource(message.getImageId());
//        mName.setText(message.getName());
//        mLogo.setImageResource(message.getLogoImageId());
//        mMessage.setText(message.getMessage());
//        mTime.setText(message.getTime());
//        return view;
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
        mAgree.setText(message.getAgree());
        mComment.setText(message.getComment());
        mTime.setText(message.getTime());
        return view;
    }
}
