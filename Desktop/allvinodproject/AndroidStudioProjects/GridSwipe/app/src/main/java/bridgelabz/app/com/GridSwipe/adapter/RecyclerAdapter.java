package bridgelabz.app.com.GridSwipe.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

import bridgelabz.app.com.GridSwipe.Fragment.Fragmentlist;
import bridgelabz.app.com.listviewswipetest.R;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    Context context;
    List<String> data;
    TextView tv;

    public RecyclerAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.card_textView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addItem(String country) {
        data.add(country);
        notifyItemInserted(data.size());
    }

    public void removeItem(int position) {
        data.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, data.size());
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView card_textView;

        public ViewHolder(final View view) {
            super(view);
            card_textView = (AppCompatTextView) view.findViewById(R.id.card_textView);
            tv = (TextView)itemView.findViewById(R.id.tv_country);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   /* Intent intent = new Intent(itemView.getContext(), NoteActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("text", card_textView.getText().toString());
                    intent.putExtra("name", bundle);
                    itemView.getContext().startActivity(intent);
*/

                    Fragmentlist frag = new Fragmentlist();
                    Bundle bundle = new Bundle();
                    bundle.putString("text", card_textView.getText().toString());
                    frag.setArguments(bundle);
                    ((Activity) context).getFragmentManager().beginTransaction().replace(R.id.frame, frag).addToBackStack(null).commit();
                }
            });
        }
    }
}


