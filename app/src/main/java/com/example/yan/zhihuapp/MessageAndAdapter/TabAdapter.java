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
 * Created by yan on 2017/4/6.
 */

public class TabAdapter extends ArrayAdapter<TabMessage> {
    private int resourceId;
    public TabAdapter(Context context, int textViewResourceId, List<TabMessage> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        TabMessage message = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView tabimageView = (ImageView) view.findViewById(R.id.tab_img);
        TextView tabname = (TextView) view.findViewById(R.id.tab_name);
        TextView tabmessage = (TextView) view.findViewById(R.id.tab_message);
        tabimageView.setImageResource(message.getImageId());
        tabname.setText(message.getName());
        tabmessage.setText(message.getMessage());
        return view;
    }

}
