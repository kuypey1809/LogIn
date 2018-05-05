package com.khoidut.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListBookAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<InfoBook> bookList;

    public ListBookAdapter(Context context, int layout, ArrayList<InfoBook> bookList) {
        this.context = context;
        this.layout = layout;
        this.bookList = bookList;
    }

    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{

        TextView txtName,txtDescription;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            holder = new ViewHolder();
            // ánh xạ view
            holder.txtName = (TextView) view.findViewById(R.id.twName);
            holder.txtDescription = (TextView) view.findViewById(R.id.twDescription);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        // gán giá trị
        InfoBook book = bookList.get(i);

        holder.txtName.setText(book.getName());
        holder.txtDescription.setText(book.getDescription());

        return view;
    }
}
