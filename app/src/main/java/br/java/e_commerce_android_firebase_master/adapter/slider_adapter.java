package br.java.e_commerce_android_firebase_master.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;

import br.java.e_commerce_android_firebase_master.items.SliderItem;

public class slider_adapter extends SliderViewAdapter {

    private Context context;

    private List<SliderItem> mSliderItems = new ArrayList<>();

    public slider_adapter(Context context) {
        this.context = context;
    }

    public void adicionarItem(SliderItem sliderItem) {
        this.mSliderItems.add(sliderItem);
        notifyDataSetChanged();
    }

    public void renovarItens(List<SliderItem> sliderItems) {

    }

    public void deletarItem(int position) {
        this.mSliderItems.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }
}
