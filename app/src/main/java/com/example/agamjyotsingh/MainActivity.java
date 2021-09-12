package com.example.agamjyotsingh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.agamjyotsingh.cv.CVFragment;
import com.example.agamjyotsingh.home.HomeFragment;
import com.example.agamjyotsingh.portfolio.PortfolioFragment;
import com.example.agamjyotsingh.sidemenu.Callback;
import com.example.agamjyotsingh.sidemenu.MenuAdapter;
import com.example.agamjyotsingh.sidemenu.MenuItems;
import com.example.agamjyotsingh.sidemenu.MenuUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Callback {

    RecyclerView menuRv;
    List<MenuItems> menuItems;
    MenuAdapter adapter;
    int selectedMenuPos = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        // setup side menu
        setupSideMenu();

        // set the default fragment when activity launch
        setHomeFragment();



    }

    private void setupSideMenu() {

        menuRv = findViewById(R.id.rv_side_menu);

        // get menu list item  will get data from a static data class

        menuItems = MenuUtil.getMenuList();
        adapter = new MenuAdapter(menuItems,this);
        menuRv.setLayoutManager(new LinearLayoutManager(this));
        menuRv.setAdapter(adapter);

    }

    void setPortfolioFragment() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new PortfolioFragment()).commit();

    }

    void setCVFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new CVFragment()).commit();
    }


    void setHomeFragment() {

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragment()).commit();

    }


    @Override
    public void onSideMenuItemClick(int i) {

        switch (menuItems.get(i).getCode()) {

            case MenuUtil.HOME_FRAGMENT_CODE : setHomeFragment();
                break;
            case MenuUtil.CV_FRAGMENT_CODE : setCVFragment();
                break;
            case MenuUtil.PORTFOLIO_FRAGMENT_CODE:setPortfolioFragment();
                break;
            default: setHomeFragment();
        }

        // highlight the selected menu item

        menuItems.get(selectedMenuPos).setSelected(false);
        menuItems.get(i).setSelected(true);
        selectedMenuPos = i ;
        adapter.notifyDataSetChanged();

    }
}
