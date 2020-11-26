package com.example.shopee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shopee.shopee_feed.AdapterOfListMenu;
import com.example.shopee.shopee_feed.List_Menu;
import com.example.shopee.toi.fragment.Fragment_dangnhap;

import java.util.ArrayList;

public class Toi_Activity extends AppCompatActivity {

    Button bt_DangNhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toi_);

        bt_DangNhap=(Button) findViewById(R.id.bt_dangNhap);
        bt_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bt_DangNhap.setVisibility(View.GONE);
//                FragmentManager fm = getSupportFragmentManager();
//                Fragmenta fma = new Fragmenta();
//                fm.beginTransaction().replace(R.id.container,fma).commit();
                FragmentManager fm = getFragmentManager();
                Fragment_dangnhap fragment = new Fragment_dangnhap();
                fm.beginTransaction().replace(R.id.container,fragment).commit();
            }
        });

        //add controler
        addControler();
        //go to dang nhập
        fragmentDangNhap();
    }
    //Fragment đăng nhập
    private void fragmentDangNhap(){

    }
    //add controler
    private void addControler(){
        init_ListCaNhan();
    }

    //Hiện thị list
    public  void init_ListCaNhan(){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_CaNhan);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        ArrayList<List_Menu> arrayList =  new ArrayList<>();
        arrayList.add(new List_Menu(R.drawable.donmua,"Đơn mua"));
        arrayList.add(new List_Menu(R.drawable.smartphone,"Đơn nạp thẻ và Dịch vụ"));
        arrayList.add(new List_Menu(R.drawable.like,"Đã thích"));
        arrayList.add(new List_Menu(R.drawable.clock,"Đã xem gần đây"));
        arrayList.add(new List_Menu(R.drawable.vi,"Ví shopee"));
        arrayList.add(new List_Menu(R.drawable.xu,"Shopee xu"));
        arrayList.add(new List_Menu(R.drawable.danhgia,"Đánh gái của tôi"));
        arrayList.add(new List_Menu(R.drawable.voucher,"Ví Voucher"));
        arrayList.add(new List_Menu(R.drawable.taikhoan,"Thiết lập tài khoản"));
        arrayList.add(new List_Menu(R.drawable.trogiup,"Trung tâm trợ giúp"));
        arrayList.add(new List_Menu(R.drawable.trochuyen,"Trò Chuyện Với Shopee"));

        AdapterOfListMenu adapter = new AdapterOfListMenu(arrayList,getApplicationContext(),R.layout.row_canhan);
        recyclerView.setAdapter(adapter);

    }
}