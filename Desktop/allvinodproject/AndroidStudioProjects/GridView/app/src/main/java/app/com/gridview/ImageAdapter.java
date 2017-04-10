package app.com.gridview;



import android.content.Context;
import android.widget.BaseAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null)
        {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.jadeja, R.drawable.abd,
            R.drawable.abd2, R.drawable.baz,
            R.drawable.binni, R.drawable.davan,
            R.drawable.dhoni1, R.drawable.dhoni2,
            R.drawable.gauti, R.drawable.irfan,
            R.drawable.jsprit, R.drawable.klr,
            R.drawable.kohli, R.drawable.pandya,
            R.drawable.pujara, R.drawable.rohit,
            R.drawable.sachin, R.drawable.shami,
            R.drawable.vijay, R.drawable.vinay,
            R.drawable.viru, R.drawable.viruu
    };
}