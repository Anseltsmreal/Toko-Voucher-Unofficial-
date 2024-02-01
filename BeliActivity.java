package com.anseltsm.viadigital;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.*;
import com.google.android.material.textfield.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

public class BeliActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private double saldo = 0;
	private String harga = "";
	private double hargaa = 0;
	private HashMap<String, Object> map = new HashMap<>();
	private String n1 = "";
	private String n2 = "";
	private String n3 = "";
	private HashMap<String, Object> Map = new HashMap<>();
	private String data = "";
	private String n4 = "";
	private String n5 = "";
	private HashMap<String, Object> Map2 = new HashMap<>();
	private double harga2 = 0;
	private String serverKey = "";
	private String token = "";
	private String s1 = "";
	private String s2 = "";
	private String s3 = "";
	private String s4 = "";
	private String s5 = "";
	private String s6 = "";
	private String s7 = "";
	private String s8 = "";
	private double trx = 0;
	private String id1 = "";
	private String id2 = "";
	private String id3 = "";
	private String ig1 = "";
	private String ig2 = "";
	private String gg = "";
	private String st1 = "";
	private String st2 = "";
	private String st3 = "";
	private String st4 = "";
	private String hasill = "";
	private double profit = 0;
	private String profilee = "";
	private double poinn = 0;
	private double kuota = 0;
	private String poinnn = "";
	private String target = "";
	private String message = "";
	private String str_1 = "";
	private String str_2 = "";
	private String judul_header = "";
	private String str_3 = "";
	private String str_4 = "";
	private String str_5 = "";
	private String targett = "";
	private String str6 = "";
	private String str7 = "";
	private HashMap<String, Object> map3 = new HashMap<>();
	private String target1 = "";
	private String pesan = "";
	private String footer = "";
	private String blast = "";
	private String wa = "";
	
	private ArrayList<HashMap<String, Object>> listMap = new ArrayList<>();
	private ArrayList<String> str = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout layar_rincian;
	private LinearLayout linear11;
	private TextView textview1;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private LinearLayout linear13;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private TextInputLayout textinputlayout1;
	private LinearLayout linear14;
	private LinearLayout linear12;
	private TextView textview2;
	private TextView textview3;
	private TextView kode_produk;
	private TextView textview5;
	private TextView nama_produk;
	private TextView textview17;
	private TextView trxid;
	private TextView textview7;
	private TextView deskripsi;
	private TextView textview9;
	private TextView harga_produk;
	private TextView textview11;
	private TextView poin;
	private TextView textview13;
	private TextView tujuan;
	private EditText edittext1;
	private TextView textview19;
	private ImageView imageview2;
	private ImageView imageview1;
	private TextView textview15;
	private TextView textview16;
	private TextView textview18;
	private TextView total;
	private MaterialButton materialbutton1;
	
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	
	private DatabaseReference order = _firebase.getReference("order/list");
	private ChildEventListener _order_child_listener;
	private DatabaseReference member = _firebase.getReference("member");
	private ChildEventListener _member_child_listener;
	private RequestNetwork beli;
	private RequestNetwork.RequestListener _beli_request_listener;
	private SharedPreferences sp;
	private AlertDialog.Builder d;
	private DatabaseReference history = _firebase.getReference("history/list");
	private ChildEventListener _history_child_listener;
	private DatabaseReference transaksi = _firebase.getReference("transaksi");
	private ChildEventListener _transaksi_child_listener;
	private Calendar c = Calendar.getInstance();
	private ProgressDialog pg;
	private RequestNetwork webhook;
	private RequestNetwork.RequestListener _webhook_request_listener;
	
	private OnCompleteListener cm_onCompleteListener;
	private RequestNetwork requestNetwork;
	private RequestNetwork.RequestListener _requestNetwork_request_listener;
	private DatabaseReference notif = _firebase.getReference("notif");
	private ChildEventListener _notif_child_listener;
	private DatabaseReference pengaturan = _firebase.getReference("pengaturan/koneksi");
	private ChildEventListener _pengaturan_child_listener;
	private DatabaseReference hasil = _firebase.getReference("hasil");
	private ChildEventListener _hasil_child_listener;
	private RequestNetwork cektransaksi;
	private RequestNetwork.RequestListener _cektransaksi_request_listener;
	private AlertDialog.Builder dd;
	private AlertDialog.Builder ddd;
	private AlertDialog.Builder dddd;
	private TimerTask wait;
	private DatabaseReference deposit = _firebase.getReference("deposit");
	private ChildEventListener _deposit_child_listener;
	private Intent i = new Intent();
	private RequestNetwork wagateway;
	private RequestNetwork.RequestListener _wagateway_request_listener;
	private TimerTask run;
	private ProgressDialog pgg;
	private RequestNetwork kirim_ke_customer;
	private RequestNetwork.RequestListener _kirim_ke_customer_request_listener;
	private SharedPreferences tes;
	private RequestNetwork tg;
	private RequestNetwork.RequestListener _tg_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.beli);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		layar_rincian = findViewById(R.id.layar_rincian);
		linear11 = findViewById(R.id.linear11);
		textview1 = findViewById(R.id.textview1);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		linear6 = findViewById(R.id.linear6);
		linear13 = findViewById(R.id.linear13);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		textinputlayout1 = findViewById(R.id.textinputlayout1);
		linear14 = findViewById(R.id.linear14);
		linear12 = findViewById(R.id.linear12);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		kode_produk = findViewById(R.id.kode_produk);
		textview5 = findViewById(R.id.textview5);
		nama_produk = findViewById(R.id.nama_produk);
		textview17 = findViewById(R.id.textview17);
		trxid = findViewById(R.id.trxid);
		textview7 = findViewById(R.id.textview7);
		deskripsi = findViewById(R.id.deskripsi);
		textview9 = findViewById(R.id.textview9);
		harga_produk = findViewById(R.id.harga_produk);
		textview11 = findViewById(R.id.textview11);
		poin = findViewById(R.id.poin);
		textview13 = findViewById(R.id.textview13);
		tujuan = findViewById(R.id.tujuan);
		edittext1 = findViewById(R.id.edittext1);
		textview19 = findViewById(R.id.textview19);
		imageview2 = findViewById(R.id.imageview2);
		imageview1 = findViewById(R.id.imageview1);
		textview15 = findViewById(R.id.textview15);
		textview16 = findViewById(R.id.textview16);
		textview18 = findViewById(R.id.textview18);
		total = findViewById(R.id.total);
		materialbutton1 = findViewById(R.id.materialbutton1);
		auth = FirebaseAuth.getInstance();
		beli = new RequestNetwork(this);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		d = new AlertDialog.Builder(this);
		webhook = new RequestNetwork(this);
		requestNetwork = new RequestNetwork(this);
		cektransaksi = new RequestNetwork(this);
		dd = new AlertDialog.Builder(this);
		ddd = new AlertDialog.Builder(this);
		dddd = new AlertDialog.Builder(this);
		wagateway = new RequestNetwork(this);
		kirim_ke_customer = new RequestNetwork(this);
		tes = getSharedPreferences("tes", Activity.MODE_PRIVATE);
		tg = new RequestNetwork(this);
		
		linear14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), KontakActivity.class);
				startActivity(i);
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				tujuan.setText(_charSeq);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), KontakActivity.class);
				startActivity(i);
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (tujuan.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Silahkan Masukan No Tujuan !");
				}
				else {
					if (saldo < Double.parseDouble(total.getText().toString())) {
						SketchwareUtil.showMessage(getApplicationContext(), "Saldo Tidak Cukup");
					}
					else {
						if (sp.getString("kuota", "").equals("0")) {
							SketchwareUtil.showMessage(getApplicationContext(), "Kesalahan Tidak Diketahui, Silahkan Hubungi Customer Service");
						}
						else {
							beli.startRequestNetwork(RequestNetworkController.GET, "http://trx-ip.tokovoucher.id/trx?ref_id=".concat(trxid.getText().toString().concat("&produk=".concat(kode_produk.getText().toString().concat("&tujuan=".concat(tujuan.getText().toString().concat("&secret=".concat(sp.getString("secret", "").concat("&member_code=".concat(sp.getString("merchant", "").concat("&server_id=".concat(""))))))))))), "", _beli_request_listener);
							pg = new ProgressDialog(BeliActivity.this);
							pg.setMessage("SILAHKAN TUNGGU");
							pg.setMax((int)100);
							pg.setCancelable(false);
							pg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
							pg.show();
						}
					}
				}
			}
		});
		
		_order_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					if (_childValue.containsKey("kode")) {
						kode_produk.setText(_childValue.get("kode").toString());
					}
					if (_childValue.containsKey("nama_produk")) {
						nama_produk.setText(_childValue.get("nama_produk").toString());
					}
					if (_childValue.containsKey("deskripsi")) {
						deskripsi.setText(_childValue.get("deskripsi").toString());
					}
					if (_childValue.containsKey("harga")) {
						harga_produk.setText(_childValue.get("harga").toString());
					}
					if (_childValue.containsKey("poin")) {
						poin.setText(_childValue.get("poin").toString());
					}
					if (_childValue.containsKey("refid")) {
						trxid.setText(_childValue.get("refid").toString());
					}
					if (_childValue.containsKey("harga2")) {
						harga2 = Double.parseDouble(_childValue.get("harga2").toString());
						total.setText(_childValue.get("harga2").toString());
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					if (_childValue.containsKey("kode")) {
						kode_produk.setText(_childValue.get("kode").toString());
					}
					if (_childValue.containsKey("nama_produk")) {
						nama_produk.setText(_childValue.get("nama_produk").toString());
					}
					if (_childValue.containsKey("deskripsi")) {
						deskripsi.setText(_childValue.get("deskripsi").toString());
					}
					if (_childValue.containsKey("harga")) {
						harga_produk.setText(_childValue.get("harga").toString());
						total.setText(_childValue.get("harga").toString());
					}
					if (_childValue.containsKey("poin")) {
						poin.setText(_childValue.get("poin").toString());
					}
					if (_childValue.containsKey("refid")) {
						trxid.setText(_childValue.get("refid").toString());
					}
					if (_childValue.containsKey("harga2")) {
						harga2 = Double.parseDouble(_childValue.get("harga2").toString());
						total.setText(_childValue.get("harga2").toString());
					}
				}
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		order.addChildEventListener(_order_child_listener);
		
		_member_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					if (_childValue.containsKey("saldo")) {
						sp.edit().putString("saldo", new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("saldo").toString()))).commit();
						saldo = Double.parseDouble(_childValue.get("saldo").toString());
						textview18.setText(sp.getString("saldo", ""));
					}
					if (_childValue.containsKey("uid")) {
						sp.edit().putString("uid", _childValue.get("uid").toString()).commit();
					}
					if (_childValue.containsKey("trx")) {
						trx = Double.parseDouble(_childValue.get("trx").toString());
					}
					if (_childValue.containsKey("trx")) {
						poinn = Double.parseDouble(_childValue.get("poin").toString());
					}
					if (_childValue.containsKey("no_wa")) {
						target = _childValue.get("no_wa").toString();
						sp.edit().putString("target", _childValue.get("no_wa").toString()).commit();
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					if (_childValue.containsKey("saldo")) {
						sp.edit().putString("saldo", new DecimalFormat("#,###").format(Double.parseDouble(_childValue.get("saldo").toString()))).commit();
						saldo = Double.parseDouble(_childValue.get("saldo").toString());
					}
					if (_childValue.containsKey("trx")) {
						trx = Double.parseDouble(_childValue.get("trx").toString());
					}
					if (_childValue.containsKey("poin")) {
						poinn = Double.parseDouble(_childValue.get("poin").toString());
					}
					if (_childValue.containsKey("no_wa")) {
						target = _childValue.get("no_wa").toString();
						sp.edit().putString("target", _childValue.get("no_wa").toString()).commit();
					}
				}
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		member.addChildEventListener(_member_child_listener);
		
		_beli_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				kuota = Double.parseDouble(sp.getString("kuota", ""));
				pg.dismiss();
				c = Calendar.getInstance();
				n1 = _response.replace("Saldo member tidak cukup, Sisa Saldo", "C");
				n2 = n1.replace("Sisa Saldo", "G");
				n3 = n2.replace(". HRG:", "");
				n4 = n3.replace(harga_produk.getText().toString(), "");
				n5 = n4.replace(". SALDO:", "H");
				d.setTitle("INFO TRANSAKSI");
				d.setMessage(n5);
				d.create().show();
				map = new HashMap<>();
				map.put("kode", kode_produk.getText().toString());
				map.put("nama_produk", nama_produk.getText().toString());
				map.put("deskripsi", deskripsi.getText().toString());
				map.put("harga", harga_produk.getText().toString());
				map.put("poin", poin.getText().toString());
				map.put("tujuan", tujuan.getText().toString());
				map.put("trxid", trxid.getText().toString());
				map.put("respon", n5);
				map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
				map.put("tgl", new SimpleDateFormat("dd/MM/yyyy").format(c.getTime()));
				map.put("jam", new SimpleDateFormat("HH:mm:ss").format(c.getTime()));
				transaksi.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat(trxid.getText().toString())).updateChildren(map);
				map.clear();
				if (n5.contains("GAGAL")) {
							{final Activity activity = BeliActivity.this;
								final Context context = activity.getApplicationContext();
								final int notificationId = 1;
								final String channelId = "1";
								final String channelName = "beli";
								
								new androidx.core.app.NotificationCompat.Builder(context, channelId){
										
										
										NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
										Intent intent335 = new Intent();
																   public void create(){
								
																		   intent335.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); 
																		   PendingIntent pendingIntent = PendingIntent.getActivity(activity, 0, intent335, 0);
																		   
																		   if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
																				   NotificationChannel mChannel = new NotificationChannel(
																					   channelId, channelName, NotificationManager.IMPORTANCE_HIGH);
																				   notificationManager.createNotificationChannel(mChannel);
																			   }
																	
								
								setSmallIcon(R.drawable.toa);
								setContentTitle("Info Transaksi ");
								setContentText(n5);
								setColor(0xFFFFFFFF);
								setTitleColor(0xFF000000);
								setPriority(androidx.core.app.NotificationCompat.PRIORITY_DEFAULT);
								notificationManager.notify(notificationId, this.build());
								
																	   }
							
															   }.create();}
							
					target1 = targett;
					message = n5;
					map = new HashMap<>();
					map.put("Authorization", "CV!9Ktc4pNZy4QqR#Fam");
					map.put("target", sp.getString("target", ""));
					map.put("message", n5);
					wagateway.setParams(map, RequestNetworkController.REQUEST_PARAM);
					wagateway.setHeaders(map);
					wagateway.startRequestNetwork(RequestNetworkController.POST, "https://api.fonnte.com/send", "", _wagateway_request_listener);
				}
				else {
					if (sp.getString("poin", "").equals("true")) {
						map = new HashMap<>();
						map.put("poin", String.valueOf((long)(poinn + 1)));
						member.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
						map.clear();
						map = new HashMap<>();
						map.put("saldo", String.valueOf((long)(saldo - Double.parseDouble(total.getText().toString()))));
						member.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
						map.clear();
						s1 = "data:text/html,<html><body><marquee> ";
						s2 = "USER ID: ";
						s3 = sp.getString("uid", "");
						s4 = "PRODUK:  ";
						s5 = nama_produk.getText().toString();
						s6 = "STATUS:  ";
						s7 = "SUKSES";
						s8 = " </marquee></body><html>";
						map = new HashMap<>();
						map.put("notif", s1.concat(s2.concat(s3.concat(s4.concat(s5.concat(s6.concat(s7.concat(s8))))))));
						notif.child("key").updateChildren(map);
						map.clear();
						map = new HashMap<>();
						map.put("trx", String.valueOf((long)(trx + 1)));
						member.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
						map.clear();
						map = new HashMap<>();
						map.put("kuota", String.valueOf((long)(kuota - 1)));
						pengaturan.child("key").updateChildren(map);
						map.clear();
						pgg = new ProgressDialog(BeliActivity.this);
						pgg.setMessage("SILAHKAN TUNGGU...");
						pgg.setMax((int)100);
						pgg.setCancelable(false);
						pgg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
						pgg.show();
						wait = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										id1 = sp.getString("merchant", "");
										id2 = sp.getString("secret", "");
										id3 = trxid.getText().toString();
										ig1 = ":";
										ig2 = ":";
										// Dapatkan referensi ke komponen EditText dan TextView
										//TextView mcc = findViewById(R.id.mc); // Gantilah dengan ID komponen EditText Anda
										//TextView scc = findViewById(R.id.sc); // Gantilah dengan ID komponen TextView Anda
										//TextView txt = findViewById(R.id.hs);
										
										String inputText = id1.concat(ig1.concat(id2.concat(ig2.concat(id3))));
										
										try {
											    // Buat objek MessageDigest dengan algoritma MD5
											    MessageDigest md = MessageDigest.getInstance("MD5");
											
											    // Update nilai hash dengan byte dari string
											    md.update(inputText.getBytes());
											
											    // Dapatkan nilai hash dalam bentuk byte
											    byte[] digest = md.digest();
											
											    // Ubah byte menjadi nilai heksadesimal
											    BigInteger bigInt = new BigInteger(1, digest);
											    String md5Value = bigInt.toString(16);
											
											    // Pastikan panjangnya 32 karakter
											    while (md5Value.length() < 32) {
												        md5Value = "0" + md5Value;
												    }
											
											    // Tampilkan nilai MD5 di 
											gg = md5Value;
										} catch (NoSuchAlgorithmException e) {
											    e.printStackTrace();
										}
										
										cektransaksi.startRequestNetwork(RequestNetworkController.GET, "https://api.tokovoucher.id/v1/transaksi/status?ref_id=".concat(trxid.getText().toString().concat("&member_code=".concat(sp.getString("merchant", "").concat("&signature=".concat(gg))))), "", _cektransaksi_request_listener);
									}
								});
							}
						};
						_timer.schedule(wait, (int)(10000));
					}
					else {
						map = new HashMap<>();
						map.put("saldo", String.valueOf((long)(saldo - Double.parseDouble(total.getText().toString()))));
						member.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
						map.clear();
						s1 = "data:text/html,<html><body><marquee> ";
						s2 = "USER ID: ";
						s3 = sp.getString("uid", "");
						s4 = "PRODUK:  ";
						s5 = nama_produk.getText().toString();
						s6 = "STATUS:  ";
						s7 = "SUKSES";
						s8 = " </marquee></body><html>";
						map = new HashMap<>();
						map.put("notif", s1.concat(s2.concat(s3.concat(s4.concat(s5.concat(s6.concat(s7.concat(s8))))))));
						notif.child("key").updateChildren(map);
						map.clear();
						map = new HashMap<>();
						map.put("trx", String.valueOf((long)(trx + 1)));
						member.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
						map.clear();
						map = new HashMap<>();
						map.put("kuota", String.valueOf((long)(kuota - 1)));
						pengaturan.child("key").updateChildren(map);
						map.clear();
						pgg = new ProgressDialog(BeliActivity.this);
						pgg.setMessage("SILAHKAN TUNGGU...");
						pgg.setMax((int)100);
						pgg.setCancelable(false);
						pgg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
						pgg.show();
						wait = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										id1 = sp.getString("merchant", "");
										id2 = sp.getString("secret", "");
										id3 = trxid.getText().toString();
										ig1 = ":";
										ig2 = ":";
										// Dapatkan referensi ke komponen EditText dan TextView
										//TextView mcc = findViewById(R.id.mc); // Gantilah dengan ID komponen EditText Anda
										//TextView scc = findViewById(R.id.sc); // Gantilah dengan ID komponen TextView Anda
										//TextView txt = findViewById(R.id.hs);
										
										String inputText = id1.concat(ig1.concat(id2.concat(ig2.concat(id3))));
										
										try {
											    // Buat objek MessageDigest dengan algoritma MD5
											    MessageDigest md = MessageDigest.getInstance("MD5");
											
											    // Update nilai hash dengan byte dari string
											    md.update(inputText.getBytes());
											
											    // Dapatkan nilai hash dalam bentuk byte
											    byte[] digest = md.digest();
											
											    // Ubah byte menjadi nilai heksadesimal
											    BigInteger bigInt = new BigInteger(1, digest);
											    String md5Value = bigInt.toString(16);
											
											    // Pastikan panjangnya 32 karakter
											    while (md5Value.length() < 32) {
												        md5Value = "0" + md5Value;
												    }
											
											    // Tampilkan nilai MD5 di 
											gg = md5Value;
										} catch (NoSuchAlgorithmException e) {
											    e.printStackTrace();
										}
										
										cektransaksi.startRequestNetwork(RequestNetworkController.GET, "https://api.tokovoucher.id/v1/transaksi/status?ref_id=".concat(trxid.getText().toString().concat("&member_code=".concat(sp.getString("merchant", "").concat("&signature=".concat(gg))))), "", _cektransaksi_request_listener);
									}
								});
							}
						};
						_timer.schedule(wait, (int)(10000));
					}
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				pg.dismiss();
				SketchwareUtil.showMessage(getApplicationContext(), _message);
			}
		};
		
		_history_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		history.addChildEventListener(_history_child_listener);
		
		_transaksi_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		transaksi.addChildEventListener(_transaksi_child_listener);
		
		_webhook_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_requestNetwork_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_notif_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		notif.addChildEventListener(_notif_child_listener);
		
		_pengaturan_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("key")) {
					if (_childValue.containsKey("gm")) {
						sp.edit().putString("gm", _childValue.get("gm").toString()).commit();
					}
					if (_childValue.containsKey("pls")) {
						sp.edit().putString("pls", _childValue.get("pls").toString()).commit();
					}
					if (_childValue.containsKey("merchant")) {
						sp.edit().putString("pls", _childValue.get("merchant").toString()).commit();
					}
					if (_childValue.containsKey("secret")) {
						sp.edit().putString("pls", _childValue.get("secret").toString()).commit();
					}
					if (_childValue.containsKey("poin")) {
						sp.edit().putString("poin", _childValue.get("poin").toString()).commit();
					}
					if (_childValue.containsKey("kuota")) {
						sp.edit().putString("kuota", _childValue.get("kuota").toString()).commit();
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("key")) {
					if (_childValue.containsKey("gm")) {
						sp.edit().putString("gm", _childValue.get("gm").toString()).commit();
					}
					if (_childValue.containsKey("pls")) {
						sp.edit().putString("pls", _childValue.get("pls").toString()).commit();
					}
					if (_childValue.containsKey("poin")) {
						sp.edit().putString("poin", _childValue.get("poin").toString()).commit();
					}
					if (_childValue.containsKey("kuota")) {
						sp.edit().putString("kuota", _childValue.get("kuota").toString()).commit();
					}
				}
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		pengaturan.addChildEventListener(_pengaturan_child_listener);
		
		_hasil_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("key")) {
					if (_childValue.containsKey("hasil")) {
						profit = Double.parseDouble(_childValue.get("hasil").toString());
						sp.edit().putString("profit", String.valueOf((long)(profit))).commit();
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("key")) {
					if (_childValue.containsKey("hasil")) {
						profit = Double.parseDouble(_childValue.get("hasil").toString());
						sp.edit().putString("hasil", String.valueOf((long)(profit))).commit();
					}
				}
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		hasil.addChildEventListener(_hasil_child_listener);
		
		_cektransaksi_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				pgg.dismiss();
				Map = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());
				if (Map.containsKey("status")) {
					st1 = Map.get("status").toString();
				}
				if (st1.contains("gagal")) {
					if (Map.containsKey("sn")) {
						st2 = Map.get("sn").toString();
					}
					if (Map.containsKey("ref_id")) {
						st3 = Map.get("ref_id").toString();
					}
					if (map.containsKey("trx_id")) {
						st4 = Map.get("trx_id").toString();
						hasill = st1.concat("".concat("".concat("".concat(st3.concat("".concat(st4.concat("")))))));
					}
					dd.setTitle("STATUS TRANSAKSI");
					dd.setMessage(hasill);
					dd.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dd.create().show();
					map = new HashMap<>();
					map.put("respon", st1);
					transaksi.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat(st3)).updateChildren(map);
					map.clear();
					map = new HashMap<>();
					map.put("Authorization", "CV!9Ktc4pNZy4QqR#FaM");
					map.put("target", sp.getString("target", ""));
					map.put("message", hasill);
					wagateway.setParams(map, RequestNetworkController.REQUEST_PARAM);
					wagateway.setHeaders(map);
					wagateway.startRequestNetwork(RequestNetworkController.POST, "https://api.fonnte.com/send", "", _wagateway_request_listener);
				}
				else {
					if (Map.containsKey("sn")) {
						st2 = Map.get("sn").toString();
					}
					if (Map.containsKey("ref_id")) {
						st3 = Map.get("ref_id").toString();
					}
					if (Map.containsKey("trx_id")) {
						st4 = Map.get("trx_id").toString();
						hasill = "Produk : ".concat(nama_produk.getText().toString().concat("STATUS : ".concat(st1.concat("SN :".concat(st2.concat("Reff ID : ".concat(st3.concat("Transaksi ID : ".concat(st4.concat("No Tujuan : ".concat(tujuan.getText().toString().concat("Kode Produk : ".concat(kode_produk.getText().toString())))))))))))));
					}
					map = new HashMap<>();
					map.put("respon", st1);
					transaksi.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat(st3)).updateChildren(map);
					map.clear();
					dddd.setTitle("STATUS TRANSAKSI");
					dddd.setMessage(hasill);
					dddd.setPositiveButton("OK", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dddd.create().show();
					Map = new HashMap<>();
					Map.put("username", "VIA DIGITAL PAYMENT");
					Map.put("content", hasill);
					webhook.setParams(Map, RequestNetworkController.REQUEST_PARAM);
					webhook.startRequestNetwork(RequestNetworkController.POST, "https://discord.com/api/webhooks/1172710764541390868/6ZmpEcuKFHA_QBIPmZCJwAtrF2ko7iEyCbRfqVlLybLixPlWLi8R0k9ynD09iFl6tSsF", "A", _webhook_request_listener);
					SketchwareUtil.showMessage(getApplicationContext(), "Silahkan Periksa Kemajuan Transaksi Di Menu History");
					target1 = targett;
					message = hasill;
					map = new HashMap<>();
					map.put("Authorization", "CV!9Ktc4pNZy4QqR#FaM");
					map.put("target", sp.getString("target", ""));
					map.put("message", hasill);
					wagateway.setParams(map, RequestNetworkController.REQUEST_PARAM);
					wagateway.setHeaders(map);
					wagateway.startRequestNetwork(RequestNetworkController.POST, "https://api.fonnte.com/send", "", _wagateway_request_listener);
					tg.startRequestNetwork(RequestNetworkController.POST, "https://api.telegram.org/bot".concat("6772308288:AAEArzwhcYKxlFXhcNerejNNEnTzCcvNJqc".concat("/sendMessage?chat_id=".concat(" @viadigital_project_tes".concat("&text=".concat(hasill))))), "EGSKETCHWARE", _tg_request_listener);
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				pgg.dismiss();
				SketchwareUtil.showMessage(getApplicationContext(), _message);
			}
		};
		
		_deposit_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		deposit.addChildEventListener(_deposit_child_listener);
		
		_wagateway_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_kirim_ke_customer_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_tg_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		saldo = Double.parseDouble(sp.getString("saldo", ""));
		layar_rincian.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
		textview18.setVisibility(View.GONE);
		
		targett = sp.getString("target", "");
		pesan = "Pembelian Produk Kamu Di Nurul Cell Berhasil Di Prosess. Silahkan Periksa Dan Berikut Detailnya.\n";
		footer = "Nurul Cell Agregator SERVER Pulsa H2H, Alamat Jl.raya Salopa Arah GN. Tanjung Tasikmalaya, Jawa Barat.\nPendaftaran Agen Baru HUB: 082125143422 ( GRATIS ) !!!";
		tes.edit().putString("header", pesan).commit();
		tes.edit().putString("footer", footer).commit();
	}
	
	
	@Override
	public void onResume() {
		super.onResume();
		edittext1.setText(getIntent().getStringExtra("no"));
	}
	public void _subscribeFCMTopic(final String _name) {
		if (_name.matches("[a-zA-Z0-9-_.~%]{1,900}")) {
			String topicName = java.text.Normalizer.normalize(_name, java.text.Normalizer.Form.NFD);
			topicName = topicName.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
			FirebaseMessaging.getInstance().subscribeToTopic(topicName).addOnCompleteListener(new OnCompleteListener<Void>() {
				@Override
				public void onComplete(@NonNull Task<Void> task) {
					if (task.isSuccessful()) {
						
					} else {
						SketchwareUtil.showMessage(getApplicationContext(), "Couldn't Subscribe");
					}}});
		}
		else {
			SketchwareUtil.showMessage(getApplicationContext(), "Badly Formated Topic");
		}
	}
	
	
	public void _getDeviceFCMToken() {
		FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
			@Override
			public void onComplete(@NonNull Task<InstanceIdResult> task) {
				if (task.isSuccessful()) {
					token = task.getResult().getToken();
					SketchwareUtil.showMessage(getApplicationContext(), "Fcm Token generated !");
				} else {
					SketchwareUtil.showMessage(getApplicationContext(), "Unknown Error Occurred");
				}}});
	}
	
	
	public void _sendFCMNotification(final String _key, final String _title, final String _content, final String _imageUrl, final String _topic, final String _token) {
		if (SketchwareUtil.isConnected(getApplicationContext())) {
			HashMap<String, Object> requestHeader = new HashMap<>();
			
			HashMap<String, Object> notificationBody = new HashMap<>();
			
			HashMap<String, Object> requestBody = new HashMap<>();
			requestHeader = new HashMap<>();
			requestHeader.put("Authorization", "key=".concat(_key));
			requestHeader.put("Content-Type", "application/json");
			
			notificationBody = new HashMap<>();
			notificationBody.put("title", _title);
			notificationBody.put("body", _content);
			notificationBody.put("image", _imageUrl);
			
			requestBody = new HashMap<>();
			if (!_topic.equals("null")) {
				requestBody.put("to", "/topics/".concat(_topic));
			} else {
				requestBody.put("to", _token);
			}
			requestBody.put("notification", notificationBody);
			requestNetwork.setHeaders(requestHeader);
			requestNetwork.setParams(requestBody, RequestNetworkController.REQUEST_BODY);
			requestNetwork.startRequestNetwork(RequestNetworkController.POST, "https://fcm.googleapis.com/fcm/send", "", _requestNetwork_request_listener);
		}
		else {
			SketchwareUtil.showMessage(getApplicationContext(), "No Internet Connection");
		}
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}