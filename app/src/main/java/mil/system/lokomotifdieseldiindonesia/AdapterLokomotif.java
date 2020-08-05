package mil.system.lokomotifdieseldiindonesia;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AdapterLokomotif extends ArrayAdapter<String> {

    Context context;
    private List<String> data;
    private LayoutInflater mInflater;
    private int lastPosition = -1;
    private AssetManager assetManager = getContext().getAssets();
    private String Paths = "";
    private InputStream is = null;

    public DatabaseAccess databaseAccess;



    public AdapterLokomotif(Context context, List<String> data) {
        super(context, 0, data);
        this.context = context;
        this.data = data;
        this.mInflater = LayoutInflater.from(context);
        databaseAccess = DatabaseAccess.getInstance(context);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // TODO Auto-generated method stub

        View vi = convertView;
        if (vi == null)
            vi = LayoutInflater.from(getContext()).inflate(R.layout.adapter_lokomotif, parent, false);
        String item = data.get(position);
        System.out.println("lokoitem: " + item);


        TextView namaLokomotif = (TextView) vi.findViewById(R.id.namalokomotif);
        TextView produsenLokomotif = (TextView) vi.findViewById(R.id.produsenlokomotif);
        ImageView gambarLokomotif = (ImageView) vi.findViewById(R.id.gambarlokomotif);

        databaseAccess.open();
        String idLoko= item.toString();
        String namaLoko = databaseAccess.getNamaLokomotif(idLoko);
        String produsenLoko = databaseAccess.getProdusenLokomotif(idLoko);
        databaseAccess.close();

        try {
            is = assetManager.open("img/n"+idLoko+".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(is);
        gambarLokomotif.setImageBitmap(bitmap);

        namaLokomotif.setText(namaLoko + "");
        produsenLokomotif.setText(produsenLoko + "");

        Animation animation = AnimationUtils.loadAnimation(getContext(), (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        vi.startAnimation(animation);
        lastPosition = position;

        return vi;
    }

}
