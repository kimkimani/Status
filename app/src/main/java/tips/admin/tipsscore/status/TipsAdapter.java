package tips.admin.tipsscore.status;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by quocnguyen on 03/08/2016.
 */
public class TipsAdapter extends ArrayAdapter<tips> {

    ArrayList<tips> tips;
    Context context;
    int resource;

    public TipsAdapter(Context context, int resource, ArrayList<tips> tips) {
        super(context, resource, tips);


        this.tips = tips;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater) getContext ()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listtips, null, true);

        }
        tips tips = getItem(position);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);


        if ( tips.getStatus ().contentEquals ( "1" ) ) {

            imageView.setImageResource ( R.drawable.ic_done_black_24dp );
        }
        else if ( tips.getStatus ().contentEquals ( "2" ) ) {
            imageView.setImageResource ( R.drawable.ic_cancel_black_24dp );

        }
        else {
            imageView.setImageResource ( R.drawable.ball1 );
        }

        TextView txtgoals = (TextView) convertView.findViewById(R.id.league);
        txtgoals.setText(tips.getLeague ());

        TextView txtassits = (TextView) convertView.findViewById(R.id.match);
        txtassits.setText(tips.getMatch ());

        TextView txtclean = (TextView) convertView.findViewById(R.id.odd);
        txtclean.setText(tips.getOdd ());

        TextView txtrating = (TextView) convertView.findViewById(R.id.results);
        txtrating.setText(tips.getResults ());

        TextView txtSTAT= (TextView) convertView.findViewById(R.id.tip);
        txtSTAT.setText(tips.getTip ());

        TextView txtyellow = (TextView) convertView.findViewById(R.id.time);
        txtyellow.setText(tips.getTime ());




        return convertView;
    }
}