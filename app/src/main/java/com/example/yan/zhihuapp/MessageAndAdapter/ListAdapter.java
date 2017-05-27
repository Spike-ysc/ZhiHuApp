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
import android.widget.Toast;

import com.example.yan.zhihuapp.AnswerActivity;
import com.example.yan.zhihuapp.CommentActivity;
import com.example.yan.zhihuapp.QuestionActivity;
import com.example.yan.zhihuapp.R;
import com.example.yan.zhihuapp.TopicActivity;

import java.util.List;

/**
 * Created by yan on 2017/4/1.
 */

public class ListAdapter extends ArrayAdapter<ListMessage> implements View.OnClickListener {
    private int resourceId;
    private Intent intent;
    private ListMessage message;
    private  TextView mquestion;
    private View view;
    public ListAdapter(Context context, int textViewResourceId, List<ListMessage> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        message = getItem(position);
        view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView mtopicImage = (ImageView) view.findViewById(R.id.list_topic_image);
        TextView mtopic = (TextView) view.findViewById(R.id.list_topic);
        mquestion = (TextView) view.findViewById(R.id.list_question);
        TextView manswer = (TextView) view.findViewById(R.id.list_answer);
        TextView magree = (TextView) view.findViewById(R.id.list_agree);
        TextView mcomment = (TextView) view.findViewById(R.id.list_comment);
        TextView mattention = (TextView) view.findViewById(R.id.list_attention);
        mtopicImage.setImageResource(message.getImageId());
        mtopic.setText(message.getTopic());
        mquestion.setText(message.getQuestion());
        mquestion.setTag(message.getQuestionId());
        manswer.setText(message.getAnswer());
        magree.setText(message.getAgree());
        mcomment.setText(message.getComment());
        mattention.setText(message.getAttention());
        mtopic.setOnClickListener(this);
        mtopicImage.setOnClickListener(this);
        mquestion.setOnClickListener(this);
        manswer.setOnClickListener(this);
        mcomment.setOnClickListener(this);
//        view.setTag(message.getQuestionId());
//        mattention.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mattention.getText() == "关注问题"){
//                    mattention.setText("已关注");
//                }else {
//                    mattention.setText("关注问题");
//                }
//            }
//        });
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.list_question:
                intent = new Intent(getContext(), QuestionActivity.class);
                TextView qt =(TextView)v.findViewById(R.id.list_question);
                intent.putExtra("To_question", qt.getText());
                intent.putExtra("To_questionId", qt.getTag().toString());
//                Toast.makeText(getContext(),qt.getTag().toString(), Toast.LENGTH_SHORT).show();
                getContext().startActivity(intent);
                break;
            case R.id.list_answer:
                intent = new Intent(getContext(), AnswerActivity.class);

                getContext().startActivity(intent);
                break;
            case R.id.letter_topic_image:
                intent = new Intent(getContext(),TopicActivity.class);
                getContext().startActivity(intent);
                break;
            case R.id.list_topic:
                intent = new Intent(getContext(),TopicActivity.class);
                getContext().startActivity(intent);
                break;
            case R.id.list_comment:
                intent = new Intent(getContext(),CommentActivity.class);
                getContext().startActivity(intent);
                break;


            default:
                break;
        }
    }
}
