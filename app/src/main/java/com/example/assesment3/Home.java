package com.example.assesment3;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Home extends Fragment {

    private ViewPager viewPager;
    private ImagePagerAdapter imageAdapter;
    private GridView gridView;
    private MenuGridAdapter menuAdapter;
    private Handler handler;
    private final int delay = 3000; // Delay dalam milidetik
    private Runnable runnable;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Inisialisasi ViewPager dan adapter untuk slideshow
        viewPager = view.findViewById(R.id.viewPager);
        List<Integer> imageList = Arrays.asList(
                R.drawable.iklan,
                R.drawable.iklan_1,
                R.drawable.iklan_2
        );
        imageAdapter = new ImagePagerAdapter(requireContext(), imageList);
        viewPager.setAdapter(imageAdapter);

        // Inisialisasi GridView dan adapter untuk menu grid
        gridView = view.findViewById(R.id.gridView);
        List<MenuItem> menuItems = createMenuItems();
        menuAdapter = new MenuGridAdapter(requireContext(), menuItems);
        gridView.setAdapter(menuAdapter);

        // Mulai autoplay untuk slideshow
        startAutoPlay();

        return view;
    }

    private List<MenuItem> createMenuItems() {
        // Buat dan kembalikan daftar item menu grid
        // Sesuaikan dengan kebutuhan Anda
        // Contoh:
        List<MenuItem> items = new ArrayList<>();
        items.add(new MenuItem("Minuman", R.drawable.haus));
        items.add(new MenuItem("Makanan", R.drawable.makanan));
        items.add(new MenuItem("Cemilan", R.drawable.snack));
        items.add(new MenuItem("Voucher", R.drawable.voucher));
        items.add(new MenuItem("Lokasi", R.drawable.lokasi));
        items.add(new MenuItem("Food Deliveri", R.drawable.deliveri));
        // ...

        return items;
    }

    private void startAutoPlay() {
        handler = new Handler();
        runnable = () -> {
            int currentItem = viewPager.getCurrentItem();
            int nextItem = (currentItem + 1) % imageAdapter.getCount();
            viewPager.setCurrentItem(nextItem);
            handler.postDelayed(runnable, delay);
        };
        handler.postDelayed(runnable, delay);
    }

    private void stopAutoPlay() {
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onPause() {
        super.onPause();
        stopAutoPlay();
    }

    @Override
    public void onResume() {
        super.onResume();
        startAutoPlay();
    }
}
