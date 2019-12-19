package com.example.bash_listwiew.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.bash_listwiew.R;
import com.example.bash_listwiew.models.Users;

import java.util.List;

    public class UsersAdapters extends ArrayAdapter<Users> {
        Context context;
        ImageLoader queue;
        private class ViewHolder {
            NetworkImageView image;
            TextView nickname;
            TextView name;
            TextView apellidos;
            TextView phone;

            private ViewHolder() {
            }
        }
        public UsersAdapters(Context context, List<Users> items, ImageLoader _queue) {
            super(context, 0, items);
            this.context = context;
            this.queue =_queue;
        }
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            final Users rowItem = (Users) getItem(position);
            LayoutInflater mInflater = (LayoutInflater) this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.user_item, null);
                holder = new ViewHolder();
                holder.nickname = (TextView) convertView.findViewById(R.id.nickname);
                holder.name = (TextView) convertView.findViewById(R.id.name);
                holder.apellidos=(TextView) convertView.findViewById(R.id.apellidos);
                holder.phone = (TextView) convertView.findViewById(R.id.phone);
                holder.image = (NetworkImageView)convertView.findViewById(R.id.image);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.nickname.setText(rowItem.nickname);
            holder.name.setText(rowItem.name);
            holder.apellidos.setText(rowItem.apellidos);
            holder.phone.setText(rowItem.phone);

            if ( rowItem.getSmallImage() != null ) {
                holder.image.setImageUrl(rowItem.getSmallImage(), queue);
            }
            return convertView;
        }
    }

