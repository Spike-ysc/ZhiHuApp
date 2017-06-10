package com.example.yan.zhihuapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class TalkActivity extends Activity{

    ArrayList<HashMap<String,Object>> chatList=null;
    String[] from={"image","text"};
    int[] to={R.id.chatlist_image_me,R.id.chatlist_text_me,R.id.chatlist_image_other,R.id.chatlist_text_other};
    int[] layout={R.layout.me,R.layout.you};
    String userQQ=null;
    /**
     * 这里两个布局文件使用了同一个id，测试一下是否管用
     * TT事实证明这回产生id的匹配异常！所以还是要分开。。
     *
     * userQQ用于接收Intent传递的qq号，进而用来调用数据库中的相关的联系人信息，这里先不讲
     * 先暂时使用一个头像
     */

    public final static int OTHER=1;
    public final static int ME=0;


    protected ListView chatListView=null;
    protected ImageView chatSendButton=null;
    protected EditText editText=null;
    private ImageView cancelButton;
    private TextView nameText;

    protected MyChatAdapter adapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_talk);
        chatList=new ArrayList<HashMap<String,Object>>();
        addTextToList("不管你是谁", ME);
        addTextToList("群发的我不回\n  ^_^", OTHER);
        addTextToList("哈哈哈哈", ME);
        addTextToList("新年快乐！", OTHER);
        nameText = (TextView) findViewById(R.id.chat_contact_name);

        Intent getIntent = getIntent();
        nameText.setText(getIntent.getStringExtra("name"));

        cancelButton=(ImageView)findViewById(R.id.cancel_button);
        chatSendButton=(ImageView) findViewById(R.id.chat_bottom_sendbutton);
        editText=(EditText)findViewById(R.id.chat_bottom_edittext);
        editText.addTextChangedListener(mTextWatcher);
        chatListView=(ListView)findViewById(R.id.chat_list);

        adapter=new MyChatAdapter(this,chatList,layout,from,to);

        cancelButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        chatSendButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String myWord=null;

                /**
                 * 这是一个发送消息的监听器，注意如果文本框中没有内容，那么getText()的返回值可能为
                 * null，这时调用toString()会有异常！所以这里必须在后面加上一个""隐式转换成String实例
                 * ，并且不能发送空消息。
                 */

                myWord=(editText.getText()+"").toString();
                if(myWord.length()==0)
                    return;
                editText.setText("");
                addTextToList(myWord, ME);
                /**
                 * 更新数据列表，并且通过setSelection方法使ListView始终滚动在最底端
                 */
                adapter.notifyDataSetChanged();
                chatListView.setSelection(chatList.size()-1);

            }
        });
        chatListView.setAdapter(adapter);
    }

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!TextUtils.isEmpty(editText.getText())){
                chatSendButton.setImageResource(R.drawable.ic_send_black_24dp);
            }else {
                chatSendButton.setImageResource(R.drawable.ic_insert_photo_black_24dp);

            }
        }
    };

    protected void addTextToList(String text, int who){
        HashMap<String,Object> map=new HashMap<String,Object>();
        map.put("person",who );
        map.put("image", who==ME?R.drawable.head:R.drawable.zhihulogo);
        map.put("text", text);
        chatList.add(map);
    }

    private class MyChatAdapter extends BaseAdapter {

        Context context=null;
        ArrayList<HashMap<String,Object>> chatList=null;
        int[] layout;
        String[] from;
        int[] to;



        public MyChatAdapter(Context context,
                             ArrayList<HashMap<String, Object>> chatList, int[] layout,
                             String[] from, int[] to) {
            super();
            this.context = context;
            this.chatList = chatList;
            this.layout = layout;
            this.from = from;
            this.to = to;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return chatList.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        class ViewHolder{
            public ImageView imageView=null;
            public TextView textView=null;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            ViewHolder holder=null;
            int who=(Integer)chatList.get(position).get("person");

            convertView= LayoutInflater.from(context).inflate(
                    layout[who==ME?0:1], null);
            holder=new ViewHolder();
            holder.imageView=(ImageView)convertView.findViewById(to[who*2+0]);
            holder.textView=(TextView)convertView.findViewById(to[who*2+1]);


            System.out.println(holder);
            System.out.println("WHYWHYWHYWHYW");
            System.out.println(holder.imageView);
            holder.imageView.setImageResource((Integer)chatList.get(position).get(from[0]));
            holder.textView.setText(chatList.get(position).get(from[1]).toString());
            return convertView;
        }

    }



}