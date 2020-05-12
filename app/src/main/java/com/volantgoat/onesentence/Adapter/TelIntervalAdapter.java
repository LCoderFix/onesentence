package com.volantgoat.onesentence.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.volantgoat.onesentence.Base.BaseController;
import com.volantgoat.onesentence.Bean.TelInterval;
import com.volantgoat.onesentence.R;

import java.util.List;

/**
 * Create by dong
 * Date on 2020/5/12  19:22
 */
public class TelIntervalAdapter extends BaseAdapter {
    private Context mContext;
    private List<TelInterval> list;
    private LayoutInflater inflater;
    public TelIntervalAdapter(Context context, List<TelInterval> list){
        this.mContext=context;
        this.list=list;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public TelInterval getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
             view= inflater.inflate(R.layout.item_tel_interval,null);
             new ViewHoler(view);
        }
        ViewHoler holer= (ViewHoler) view.getTag();
        holer.tvTelIntervalNum.setText(getItem(i).getTelIntervalNum());
        holer.tvIntervalName.setText(getItem(i).getGetTelIntervalName());
        return view;
    }

    class ViewHoler{
        TextView tvTelIntervalNum;
        TextView tvIntervalName;

        public ViewHoler(View view) {
            tvTelIntervalNum=view.findViewById(R.id.tv_interval_num);
            tvIntervalName=view.findViewById(R.id.tv_interval_name);
            view.setTag(this);
        }
    }
}
