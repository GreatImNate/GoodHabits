package ndseeg.goodhabits.profile;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ndseeg.goodhabits.R;

public class ItemAdapter extends ArrayAdapter<Item> {

    public ItemAdapter(@NonNull Context context, @NonNull ArrayList<Item> items) {
        super(context, 0, items);
    }

    public ItemAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public ItemAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_layout, parent, false);
        }
        Item item = getItem(position);
        TextView itemName = (TextView) convertView.findViewById(R.id.item_name);
        TextView itemDescription = (TextView) convertView.findViewById(R.id.item_description);
        if (item != null) {
            itemName.setText(item.getName());
            itemDescription.setText(item.getDescription());
        }
        return convertView;
    }
}
