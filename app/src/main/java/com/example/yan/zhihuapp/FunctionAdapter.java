package com.example.yan.zhihuapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yan on 2017/4/2.
 */

public class FunctionAdapter extends ArrayAdapter<FunctionMessage> {

    private int resourceId;
    public FunctionAdapter(Context context, int textViewResourceId, List<FunctionMessage> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        FunctionMessage message = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView mImage = (ImageView) view.findViewById(R.id.function_Image);
        TextView mName = (TextView) view.findViewById(R.id.function_name);
        mImage.setImageResource(message.getImageId());
        mName.setText(message.getName());
        return view;
    }

}
