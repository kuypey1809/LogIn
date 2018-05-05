//package com.khoidut.login;
//
//import android.graphics.Color;
//import android.os.Build;
//import android.os.Bundle;
//import android.support.annotation.RequiresApi;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import com.miguelcatalan.materialsearchview.MaterialSearchView;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class BorrowBook extends AppCompatActivity {
//    MaterialSearchView searchView;
//    ListView lstView;
//    ListView lvBook;
//    ArrayList<ListBook> arrayList;
//    ListBookAdapter adapter;
//
////    String[] lstSource = {
////
////            "Coders At Work",
////            "Code Complete",
////            "The Mythical Man-Month",
////            "Dont Make Me Think",
////            "The Pragmatic Programer",
////            "Clean Code",
////            "Programming Pearls",
////            "C++ Programming",
////            "Four",
////            "Five",
////            "Six",
////            "Seven",
////            "Eight",
////            "Nine",
////            "Ten"
////    };
//    private String[] anhXa() {
//        lvBook = (ListView) findViewById(R.id.lstView);
//        arrayList = new ArrayList<>();
//
//        arrayList.add(new ListBook("Book 1", "Coders At Work", R.drawable.capture));
//        arrayList.add(new ListBook("Book 2", "Code Complete", R.drawable.capture1));
//        arrayList.add(new ListBook("Book 3", "The Mythical Man-Month", R.drawable.capture2));
//        arrayList.add(new ListBook("Book 4", "Dont Make Me Think", R.drawable.capture3));
//        arrayList.add(new ListBook("Book 5", "The Pragmatic Programer", R.drawable.capture4));
//        arrayList.add(new ListBook("Book 6", "Clean Code", R.drawable.capture5));
//        arrayList.add(new ListBook("Book 7", "Programming Pearls", R.drawable.capture7));
//        return this.getDescription(arrayList);
//    }
//
//    private String[] getDescription(ArrayList list) {
//        String lstSource[] = new String[7];
//        int index = 0;
//        for (Object item : list) {
//            ListBook book = (ListBook) item;
//            lstSource[index] = book.getDescription();
//            index++;
//        }
//
//        return lstSource;
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.book_borrow);
//
//        anhXa();
//
//        adapter = new ListBookAdapter(this, R.layout.flow_list_book, arrayList);
//        lvBook.setAdapter(adapter);
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        Objects.requireNonNull(getSupportActionBar()).setTitle("Search");
//
//        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
//
//        lvBook = (ListView) findViewById(R.id.lstView);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, this.anhXa());
//        lvBook.setAdapter(adapter);
//
//
//        searchView = (MaterialSearchView) findViewById(R.id.search_view);
//
//        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
//
//
//            @Override
//            public void onSearchViewShown() {
//
//            }
//
//            @Override
//            public void onSearchViewClosed() {
//
//                //If closed Search View , lstView will return default
//                lvBook = (ListView) findViewById(R.id.lstView);
//
//
//                ArrayAdapter<String> adapter = new ArrayAdapter<>(BorrowBook.this, android.R.layout.simple_list_item_1, anhXa());
//                lvBook.setAdapter(adapter);
//
//            }
//        });
//
//        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                if (newText != null && !newText.isEmpty()) {
//                    List<String> lstFound = new ArrayList<String>();
//                    for (String item : anhXa()) {
//                        if (item.contains(newText))
//                            lstFound.add(item);
//                    }
//
//                    ArrayAdapter<String> adapter = new ArrayAdapter<>(BorrowBook.this, android.R.layout.simple_list_item_1, lstFound);
//                    lvBook.setAdapter(adapter);
//                } else {
//                    //if search text is null
//                    //return default
//                    ArrayAdapter<String> adapter = new ArrayAdapter<>(BorrowBook.this, android.R.layout.simple_list_item_1, anhXa());
//                    lvBook.setAdapter(adapter);
//                }
//                return true;
//            }
//
//        });
//    }
//
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_item, menu);
//        MenuItem item = menu.findItem(R.id.action_search);
//        searchView.setMenuItem(item);
//        return true;
//
//    }
//
//
//}
//
//
