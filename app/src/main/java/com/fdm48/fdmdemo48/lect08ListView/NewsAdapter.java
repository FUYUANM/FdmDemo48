package com.fdm48.fdmdemo48.lect08ListView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fdm48.fdmdemo48.R;

import java.util.List;

public class NewsAdapter extends BaseAdapter {
    private String TAG = NewsAdapter.class.getSimpleName();
    private List<News> mDataList;
    private Context mContext;
    private LayoutInflater mInflater;

    public NewsAdapter(Context context ,List<News> dataList){
        mDataList = dataList;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);

    }

    @Override
    public int getCount(){
        int count = (null == mDataList ? 0 : mDataList.size());
        Log.i(TAG,"--- getCount()" + count);
        return count;
    }

    @Override
    public News getItem(int position){
        Log.i(TAG,"--- getItem()" + position);
        return mDataList.get(position);
    }


    @Override
    public long getItemId(int position){
        Log.i(TAG,"--- getItemId()" + position);
        return position;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        Log.i(TAG,"--- getView()" + position+"convertView"+convertView);
        ViewHolder holder;
        if (null==convertView) {
            convertView = mInflater.inflate(R.layout.item_news, null);
            holder = new ViewHolder();
            holder.iconIv = convertView.findViewById(R.id.iv_icon);
            holder.tltTv = convertView.findViewById(R.id.tv_title);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        News news = mDataList.get(position);
        holder.iconIv.setImageResource(news.getPicId());
        holder.tltTv.setText(news.getTitle());

        holder.iconIv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(mContext, "点了第"+position+"个新闻icon",Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
    private class ViewHolder{
        TextView tltTv;
        ImageView iconIv;
    }
}
