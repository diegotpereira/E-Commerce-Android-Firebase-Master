package br.java.e_commerce_android_firebase_master.view;

import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import br.java.e_commerce_android_firebase_master.R;
import br.java.e_commerce_android_firebase_master.adapter.buscar_resultado;
import br.java.e_commerce_android_firebase_master.adapter.slider_adapter;
import br.java.e_commerce_android_firebase_master.databinding.HomeBinding;
import br.java.e_commerce_android_firebase_master.items.SliderItem;


public class Home extends Fragment {

    //HomeViewModel mViewModel;
    SearchView searchView;
    ImageView carrinho;

    SliderView sliderView;
    private slider_adapter adapter;
    HomeBinding homeBinding;
    DrawerLayout drawerLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        // View view = inflater.inflate(R.layout.home,container,false);

        homeBinding = DataBindingUtil.inflate(inflater, R.layout.home, container, false);
        View view = homeBinding.getRoot();

        carrinho = homeBinding.carrinho;
        searchView = homeBinding.searchView;
        sliderView = homeBinding.imageSlider;



        getActivity().getWindow().setStatusBarColor(getActivity().getColor(R.color.purple));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                if(query.equals("shoes"))
                {
                    Intent intent = new Intent(getContext(), buscar_resultado.class);
                    startActivity(intent);
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                return false;
            }
        });

        carrinho.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getContext(), CarrinhoActivity.class);
                startActivity(intent);
            }
        });



        adapter = new slider_adapter(getContext());

        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using IndicatorAnimationType. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener()
        {
            @Override
            public void onIndicatorClicked(int position)
            {
                Log.i("GGG", "onIndicatorClicked: " + sliderView.getCurrentPagePosition());
            }
        });

        adicionarNovoItem(view);
        renovarItens(view);
        removerUltimoItem(view);

        return view;
    }

    public void renovarItens(View view)
    {
        List<SliderItem> sliderItemList = new ArrayList<>();
        //dummy data
        for (int i = 0; i < 5; i++)
        {
            SliderItem sliderItem = new SliderItem();
            sliderItem.setDescricao("Slider Item " + i);
            if (i % 2 == 0)
            {
                sliderItem.setImagemUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
            }
            else
            {
                sliderItem.setImagemUrl("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260");
            }
            sliderItemList.add(sliderItem);
        }
        adapter.renovarItens(sliderItemList);
    }

    public void removerUltimoItem(View view)
    {
        if (adapter.getCount() - 1 >= 0)
            adapter.deletarItem(adapter.getCount() - 1);
    }

    public void adicionarNovoItem(View view)
    {
        SliderItem sliderItem = new SliderItem();
        sliderItem.setDescricao("Slider Item Added Manually");
        sliderItem.setImagemUrl("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260");
        adapter.adicionarItem(sliderItem);
    }

}