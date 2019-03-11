package com.nerdlogs.simplemvp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nerdlogs.simplemvp.R;
import com.nerdlogs.simplemvp.listener.OnLongPressListener;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> userNames;
    private int EMPTY_HOLDER = 0;
    private int USER_HOLDER = 1;
    private OnLongPressListener onLongPressListener;

    public UserAdapter(List<String> userNames) {
        this.userNames = userNames;
    }

    public void setOnLongPressListener(OnLongPressListener onLongPressListener) {
        this.onLongPressListener = onLongPressListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (getItemViewType(i) == EMPTY_HOLDER){
            View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_empty, viewGroup, false);
            return new EmptyHolder(rootView);
        } else {
            View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user, viewGroup, false);
            return new UserHolder(rootView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        if (getItemViewType(i) == USER_HOLDER){
            String name = userNames.get(i);
            UserHolder userHolder = (UserHolder) holder;
            if (name != null){
                userHolder.itemName.setText(name);
            }
        }
    }

    @Override
    public int getItemCount() {
        return userNames.size() > 0 ? userNames.size() : 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (userNames.size() == 0){
            return EMPTY_HOLDER;
        }
        return USER_HOLDER;
    }

    public void addUser(String name){
        userNames.add(name);
        notifyDataSetChanged();
    }

    public void removeUser(String name){
        userNames.remove(name);
        notifyDataSetChanged();
    }

    class UserHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        private TextView itemName;
        UserHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_name);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View v) {
            onLongPressListener.onLongPress(v, userNames.get(getAdapterPosition()));
            return true;
        }
    }

    class EmptyHolder extends RecyclerView.ViewHolder {
        EmptyHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
