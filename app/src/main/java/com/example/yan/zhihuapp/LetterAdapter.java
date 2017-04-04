package com.example.yan.zhihuapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yan on 2017/3/26.
 */

public class LetterAdapter extends ArrayAdapter<LetterMessage> {
    private int resourceId;



    //    public LetterAdapter(Context context, int textViewResourceId, List<LetterMessage> objects) {
//        super(context, textViewResourceId, objects);
//        resourceId = textViewResourceId;
//    }
    public LetterAdapter(Context context, int textViewResourceId, List<LetterMessage> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LetterMessage message = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView mImage = (ImageView) view.findViewById(R.id.letter_topic_image);
        TextView mName = (TextView) view.findViewById(R.id.letter_name);
        ImageView mLogo = (ImageView) view.findViewById(R.id.letter_name_logo);
        TextView mMessage = (TextView) view.findViewById(R.id.letter_message);
        TextView mTime = (TextView) view.findViewById(R.id.letter_time);
        mImage.setImageResource(message.getImageId());
        mName.setText(message.getName());
        mLogo.setImageResource(message.getLogoImageId());
        mMessage.setText(message.getMessage());
        mTime.setText(message.getTime());
        return view;
    }
}


