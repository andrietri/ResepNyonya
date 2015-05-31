package com.example.rn.activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.rn.R;

/**
 * Created by andrie on 21/05/15.
 */
public class DB_Resep extends SQLiteOpenHelper {

    //pembuatan database dengan nama db_resep_makanan
    final static String DB_NAME = "db_resep";


    public DB_Resep(Context context) {
        super(context, DB_NAME, null, 1);
// TODO Auto-generated constructor stub
    }
        @Override
        public void onCreate(SQLiteDatabase db) {
//pada database db_resep membuat tabel baru bernama resep untuk di isi dengan
//            beberapa field diantaranya id (INT) nama (TEXT) bahan (TEXT) cara (TEXT) dan img

            String sql = "CREATE TABLE IF NOT EXISTS resep(_id INTEGER PRIMARY KEY AUTOINCREMENT, nama TEXT, bahan TEXT, cara TEXT, img BLOB)";
            String sql2 = "CREATE TABLE IF NOT EXISTS resepminuman(_id INTEGER PRIMARY KEY AUTOINCREMENT, nama TEXT, bahan TEXT, cara TEXT, img BLOB)";
            db.execSQL(sql);
            db.execSQL(sql2);

//berikut ini adalah beberapa cuplikan content dari database

            ContentValues values = new ContentValues();

            values.put("_id", "1");
            values.put("nama", "Bubur Candil");
            values.put("bahan", "1. Tepung ketan putih 200 gr \n2. Tepung beras putih 50 gr \n3. Air 100 ml \n4. Pewarna makanan (merah,hijau,kuning) secukupnya \n5. Gula jawa / gula merah 200 gr \n6. Air 1 ltr \n7. Santan 500 ml \n8. Garam ½ sdt \n9. Daun pandan 1 lbr");
            values.put("cara", "1. Pertama Masukkan tepung ketan dan tepung beras dalam wadah \n2. Kemudian tuangkan air sedikit demi sedikit hingga kalis (kental dan lengket) \n3. Selanjutnya Basahi tangan dengan air lalu uleni lagi bila terasa adonan masih kurang kalis \n4. Setelah itu pisahkan adonan menjadi 3 bagian \n5. Berikan pewarna pada masing-masing adonan \n6. Setelah itu bentuk bulat-bulat seperti kelereng \n7. Masak gula jawa dan air 1 ltr \n8. Biarkan hingga mendidih dan gula larut lalu saring kemudian didihkan lagi \n9. Cemplungkan bulatan adonan kedalamnya \n10. Biarkan hingga mengapung \n11. Lalu masukkan santan,garam,daun pandan \n12. Aduk rata hingga mendidih \n13. Kini bubur candil siap disajikan");
            values.put("img", R.drawable.buburcandil);
            db.insert("resep", "_id", values);

            values.put("_id", "2");
            values.put("nama", "Donat Mini");
            values.put("bahan", "1. Tepung terigu 140 gram \n2. Tepung maizena 1 sdm \n3. Gula pasir 1 sdm \n4.  Air 120 ml, Ragi instan 1 sdt \n5. Baking powder 1 sdt");
            values.put("cara","1. Siapkan bahan \n2. Masukkan tepung terigu,maizena dan gula,BP ke dalam wadah \n3. Aduk secara meratarata \n4. Kemudian Larutkan ragi ke dalam air dan campur dengan tepung \n5. Tambahkan sedikit air demi sedikit dan uleni sampai kalis \n6. Air tidak harus dipakai semua bergantung pada adonan nya \n7. Diamkan 30 menit lalu bentuk bulat dan biarkan lagi 15 menit \n8. Goreng dgn api kecil sedang sambil siram minyak ke bagian atas donat s/d kecoklatan \n9. Tim DCC hingga leleh, celup donat dan taburi meises/ kacang sesuai selera \n10. Kini donat mini siap dinikmati");
            values.put("img", R.drawable.donatmini);
            db.insert("resep", "_id", values);

            values.put("_id", "3");
            values.put("nama", "Tumis Buncis Telor");
            values.put("bahan", "1. Buncis 1 bungkus \n2. Telur 1 butir \n3. Bawang putih 2 siung \n4. Minyak untuk menumis 2 sendok makan \n5. Merica	secukupnya \n6. Garam secukupnya \n7. Kecap asin secukupnya");
            values.put("cara", "1. Bersihkan buncis dan potong kedua ujung lalu dibagi 3 \n2. Geprek bawang putih dan cincang halus \n3. Siapkan wajan dan diberi minyak lalu tumis bawang putih hingga harum \n4. Setelah itu masukan buncis dan aduk rata selama kurleb 2 menit \n5. Masukan telur yang sudah dikocok dan apinya jangan terlalu besar \n6. Beri merica, garam dan kecap asin lalu aduk rata selama kurleb 2 menit \n7. Angkat dan sajikan");
            values.put("img", R.drawable.tumisbuncistelor);
            db.insert("resep", "_id", values);

            values.put("_id", "4");
            values.put("nama", "Terong Balado");
            values.put("bahan", "1. Terong ungu 3 buah \n2. Cabe merah keriting 100 gram \n3. Bawang merah 10 butir \n4. Tomat	0,5 buah \n5. Jeruk nipis 0,5 buah \n6. Gula secukupnya \n7. Garam secukupnya");
            values.put("cara", "1. Potong-potong terong menjadi 4 bagian \n2. Jangan potong terong terlalu tipis, karena akan sangat berminyak \n3. Goreng terong hingga bagian putih berubah kecoklatan \n4. Haluskan dengan blender hingga benar-benar halus: Cabai merah keriting, bawang merah dan garam \n5. Tomat dipotong dadu kecil \n6. Tiriskan minyak bekas menggoreng terong dan sisakan secukupnya untuk menumis \n7. Iris bawang merah lalu tumis dengan minyak bekas menggoreng terong tadi hingga setengah matang \n8. Masukkan gilingan cabai dan bawang merah lalu masak hingga tidak lagi berbau langu \n9. Lalu tambahkan air perasan jeruk nipis \n10. Kecilkan api, lalu masukkan terong \n11. Aduk hingga semua terong tertutup dengan sambal lado \n12. Angkat dan sajikan \n13. Sangat cocok dimakan dengan nasi putih hangat");
            values.put("img", R.drawable.terongbalado);
            db.insert("resep", "_id", values);

            values.put("_id", "5");
            values.put("nama", "Cumi Tumis Kecap");
            values.put("bahan", "1. Cumi-cumi besar \n2. bersihkan dan potong 2 ekor \n3. Kecap Manis 5 sendok makan \n4. Garam secukupnya \n5. Daun Jeruk 4 lembar \n6. Daun salam 2 lembar \n7. Bawang Bombay \n8. Iris sabit 1/2 siung Bawang Putih \n9. Iris tipis	2 siung \n10. Olive oil secukupnya");
            values.put("cara", "1. Tumis bawang bombay \n2. bawang putih, daun jeruk \n3. dan daun salam dengan olive oil hingga harum \n4. Masukkan cumi, lalu tutup dan masak dengan api kecil hingga cumi berair \n5. Buka dan aduk aduk, masak terus hingga airnya berkurang \n6. Masukkan garam dan kecap manis \n7. Aduk hingga rata \n8. Masak terus sambil diaduk hingga kecap mendidih dan mengental seperti karamel \n9. Angkat dan sajikan");
            values.put("img", R.drawable.cumitumiskecap);
            db.insert("resep", "_id", values);

            values.put("_id", "6");
            values.put("nama", "Nasi Uduk Rempah");
            values.put("bahan", "1. Beras putih 300 gram \n2. Santan dari 1/4 butir kelapa 500 ml \n3. Garam 1 sendok teh \n4. Serai 1 batang \n5. Cengkeh 2 biji \n6. Daun salam 2 lembar \n7. Kayu manis	1,5 cm \n8. Daun pandan 1 lembar \n9. Makanan Pendamping \n10. Ayam goreng 1 potong \n11. Serundeng 1 sendok makan \n12. Telur dadar secukupnya \n13. Sambal kemiri 1 sendok teh");
            values.put("cara", "1. Campur beras dengan semua bahan kecuali daun pandan \n2. Masak sambil sesekali diaduk hingga santan susut \n3. Angkat dan masukkan pandan kedalam air untuk mengukus, pasang sekat \n4. Kemudian masukkan nasi aron \n5. Kukus +/- 20 menit hingga matang \n6. Sajikan bersama makanan pendamping dan siap dinikmati");
            values.put("img", R.drawable.nasiudukrempah);
            db.insert("resep", "_id", values);

            values.put("_id", "7");
            values.put("nama", "Perkedel Jagung");
            values.put("bahan", "1. Jagung 4 buah \n2. Bawang merah 3 butir \n3. Bawang putih 2 siung \n4. Cabai rawit	5 biji \n5. Daun bawang	2 batang \n6. Daun seledri 1 batang \n7. Garam 1 sendok teh \n8. Gula 1 secukupnya \n9. Penyedap secukupnya \n10. Telur kocok 1 butir \n11. Tepung terigu 3 sendok makan \n12. Merica bubuk 1 sendok teh");
            values.put("cara", "1. Pipil jagung lalu haluskan \n2. Haluskan bawang merah,bawang putih,cabai \n3. Masukan dalam adonan jagung \n4. Tambahkan daun bawang,daun seledri yg telah diiris halus \n5. Kocok telur kemudian masukan dalam adonan jagung \n6. Tambah terigu,garam,gula dan merica \n7. Tambahkan penyedap,lalu goreng hingga kuning kecoklatan \n8. Selamat mencoba");
            values.put("img", R.drawable.perkedeljagung);
            db.insert("resep", "_id", values);

            values.put("_id", "8");
            values.put("nama", "Udang Mentega");
            values.put("bahan", "1. Udang jerbung 250 gram \n2. Jeruk nipis 1 buah \n3. Garam 1 sendok teh \n4. Bubuk bawang putih	secukupnya \n5. Mentega	1.5 sendok makan \n6. Minyak goreng	1 sendok makan \n7. Basil kering secukupnya \n8. Oregano kering	secukupnya \n9. Thyme kering secukupnya \n10. Rosemary kering secukupnya");
            values.put("cara", "1. Buang kepala udang jerbung \n2. jangan kupas kulitnya karena memasak udang dengan kulitnya akan mempertahankan rasa manis dari udang itu sendiri \n3. Campur udang dengan air perasan jeruk nipis, garam, bawang putih bubuk dan semua rempah kering \n4. Marinate paling sebentar 5 menit \n5. Panaskan minyak dan mentega hingga mentega meleleh \n6. Masukkan udah dan masak hingga udang berubah warna menjadi merah \n7. Jangan masak udang terlalu lama karena nanti jadi keras \n8. Sajikan dengan saus sambal botolan");
            values.put("img", R.drawable.udangrempahmentega);
            db.insert("resep", "_id", values);

//            -------------------------------------------------------------------------

//berikut ini adalah beberapa cuplikan content dari database

            ContentValues values2 = new ContentValues();

            values2.put("_id", "1");
            values2.put("nama", "Jus Apel Jeruk");
            values2.put("bahan", "1. 2 buah apel greensmith \n2. potong-potong \n3. 1 buah tomat merah \n4. potong-potong \n5. 200 gram yogurt rasa apel \n6. 200 ml air jeruk medan \n7. 100 gram es batu");
            values2.put("cara", "1. Pertama masukkan apel, tomat dan yogurt ke dalam blender \n2. Kemudian Tuang air jeruk \n3. Tambahkan es batu \n4. Blender sampai rata");
            values2.put("img", R.drawable.jusapeljeruk);
            db.insert("resepminuman", "_id", values2);
//
            values2.put("_id", "2");
            values2.put("nama", "Jus Bit dan Anggur");
            values2.put("bahan", "1. 200 gram buah bit \n2. 100 gram anggur merah, buang biji \n3. 1 sendok makan madu \n4. 50 gram gula pasir \n5. 200 ml air \n6. 150 gram es batu");
            values2.put("cara", "1. Pertama masukkan buah bit, anggur, madu dan gula pasir dalam blender \n2. Kemudian tuang air dan tambahkan es batu \n3. Blender sampai rata");
            values2.put("img", R.drawable.jusbitdananggur);
            db.insert("resepminuman", "_id", values2);
////
            values2.put("_id", "3");
            values2.put("nama", "Jus Terong Belanda");
            values2.put("bahan", "1. 200 gram terong belanda \n2. kupas kulitnya, potong-potong \n3. 150 gram daging sirsak \n4. 200 ml air es \n5. 100 ml air jeruk medan \n6. 100 gram es serut");
            values2.put("cara", "1. Pertama campur terong belanda, daging sirsak, air, air jeruk dan es batu \n2. Kemudian blender sampai lembut \n3. Saring.");
            values2.put("img", R.drawable.justerongbelanda);
            db.insert("resepminuman", "_id", values2);
////
            values2.put("_id", "4");
            values2.put("nama", "Orange Yoghurt Shorbet");
            values2.put("bahan", "1. 125 gram gula pasir \n2. 175 ml air \n3. 250 gram jeruk mandarin \n4. 125 gram plain yoghurt");
            values2.put("cara", "1. Rebus gula pasir dan air di atas api kecil sampai larut \n2. Dinginkan \n3. Tambahkan jeruk, yoghurt dan esens jeruk \n4. Blender sampai lembut \n5. Dinginkan 2 jam dalam freezer \n6. Kocok lembut \n7. Keluarkan dari freezer \n8. Kocok kembali \n9. Lakukan sampai 2 kali \n10. Biarkan sampai beku");
            values2.put("img", R.drawable.orangeyoghurtshorbet);
            db.insert("resepminuman", "_id", values2);
////
            values2.put("_id", "5");
            values2.put("nama", "Sorbet Jambu Biji");
            values2.put("bahan", "1. 400 gram jambu buji tanpa biji \n2. kupas kulit, 25 gram gula pasir \n3. 250 ml yogurt rasa jambu biji \n4. 1 sendok makan air jeruk lemon \n5. 200 gram es serut \n6. 1/8 sendok teh garam");
            values2.put("cara", "1. Blender jambu biji, gula, yogurt, air jeruk, es serut hingga halus \n2. Angkat dan bekukan dalam frezer \n3. Sajikan dalam gelas");
            values2.put("img", R.drawable.sorbetjambubiji);
            db.insert("resepminuman", "_id", values2);
////
            values2.put("_id", "6");
            values2.put("nama", "Susu Coklat Jahe");
            values2.put("bahan", "1. 1.000 ml susu non fat \n2. 25 ml cokelat bubuk \n3. 200 gram jahe bakar \n4. 2 buah kapulaga \n5. 75 gram gula pasir \n6. 2 cm kayu manis \n7. 1 buah cengkeh \n8. 1/2 sendok teh kayu manis bubuk untuk taburan");
            values2.put("cara", "1. Rebus susu, cokelat bubuk, jahe, kapulaga, gula, kayumanis dan cengkeh dengan api kecil hingga harum \n2. Sajikan dengan taburan kayumanis bubuk");
            values2.put("img", R.drawable.susucokelatjaherempah);
            db.insert("resepminuman", "_id", values2);
////
            values2.put("_id", "7");
            values2.put("nama", "Wedang Jahe Moka");
            values2.put("bahan", "1. 12.000 ml air \n2. 3.000 gram jahe dibakar, dikupas, dimemarkan \n3. 24 batang serai, dibakar, dimemarkan \n4. 500 ml susu kental manis cokelat \n5. 3.000 gram gula pasir \n6. 4 sendok makan kopi hitam \n7. 40 gram kapulaga, dimemarkan \n8. 10 cm kayumanis \n9. 20 gram cengkih");
            values2.put("cara", "1. Rebus air, jahe, serai, kayu manis, cengkeh, kapulaga, gula pasir, dan kopi \n2. Masak sambil diaduk sampai mendidih dan harum \n3. Angkat wedang jahe \n4. Saring \n5. Tambahkan susu kental manis \n6. Aduk rata");
            values2.put("img", R.drawable.wedangjahemoka);
            db.insert("resepminuman", "_id", values2);
        }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
            {
                db.execSQL("DROP TABLE IF EXISTS resep");
                onCreate(db);

                db.execSQL("DROP TABLE IF EXISTS resepminuman");
                onCreate(db);

            }


}

