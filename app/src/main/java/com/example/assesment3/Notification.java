package com.example.assesment3;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Notification extends Fragment {
    private RecyclerView recyclerView;
    private MessageAdapter messageAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        recyclerView = view.findViewById(R.id.recyclerView );

        // Contoh data pesan
        List<MessageModel> messages = new ArrayList<>();
        messages.add(new MessageModel("Selamat datang di aplikasi restaurant kami anda kencot kami solusinya", R.drawable.avatar, "09:00 AM"));
        messages.add(new MessageModel("Masa berlaku voucher anda mau habis nih. Pakai Sekarang!!!", R.drawable.waktu, "10:30 AM"));
        messages.add(new MessageModel("Makanan anda sedang diantar oleh kurir mohon di tunggu ya", R.drawable.kurir, "12:45 PM"));
        messages.add(new MessageModel("Wah ada yang belum di chekout nih makanan nya padahal sudah awal bulan", R.drawable.keranjang, "16:45 PM"));
        messages.add(new MessageModel("AWAS PENIPUAN !!! Akunmu masuk di perangkat baru. mohon segera pastikan bahwa kamu baik-baik saja", R.drawable.avatar, "00:00 AM"));
        messages.add(new MessageModel("Yah stok snack yang di keranjangmu kosong, lain kali kalo suka langsung chekout karna resiko menunggu adalah kehilangan", R.drawable.keranjang, "20:15 PM"));
        messages.add(new MessageModel("Masa berlaku voucher anda mau habis nih. Pakai Sekarang!!!", R.drawable.waktu, "23:30 PM"));
        messages.add(new MessageModel("Makanan anda sedang diantar oleh kurir mohon di tunggu ya", R.drawable.kurir, "05:45 AM"));
        // Buat adapter dan terapkan ke RecyclerView
        messageAdapter = new MessageAdapter(messages);
        recyclerView.setAdapter(messageAdapter);

        // Atur layout manager (LinearLayoutManager atau GridLayoutManager) sesuai kebutuhan
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
