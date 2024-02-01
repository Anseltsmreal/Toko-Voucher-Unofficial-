package com.anseltsm.viadigital;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
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
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.bumptech.glide.Glide;
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
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

public class DepoActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String key = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String nom_str = "";
	private double kode = 0;
	private String email = "";
	private String title = "";
	private String pesan = "";
	private double filterr = 0;
	private String filter = "";
	private String ftt = "";
	private String uuid = "";
	private String statuss = "";
	private String serverKey = "";
	private String dana = "";
	private String bri = "";
	private String bca = "";
	private String tg = "";
	private String token = "";
	private String chatid = "";
	
	private ArrayList<String> str_bank = new ArrayList<>();
	private ArrayList<String> str_nom = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> depos = new ArrayList<>();
	
	private LinearLayout linear1;
	private CardView cardview1;
	private LinearLayout linear2;
	private LinearLayout layar_title;
	private LinearLayout layar_nominal_bank;
	private LinearLayout linear10;
	private LinearLayout linear12;
	private LinearLayout linear14;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private Button button1;
	private LinearLayout layar_bank;
	private LinearLayout layar_nominal_cepat;
	private Spinner bank;
	private Spinner input_cepat;
	private TextView bank_name;
	private TextView nomm;
	private TextInputLayout textinputlayout1;
	private LinearLayout linear13;
	private EditText edittext1;
	private Button button2;
	private TextView textview2;
	private MaterialButton materialbutton1;
	private TextView textview1;
	private ListView listview1;
	
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
	
	private DatabaseReference deposit = _firebase.getReference("deposit");
	private ChildEventListener _deposit_child_listener;
	private Calendar c = Calendar.getInstance();
	private DatabaseReference mutasi = _firebase.getReference("mutasi");
	private ChildEventListener _mutasi_child_listener;
	private DatabaseReference kon = _firebase.getReference("pengaturan/koneksi");
	private ChildEventListener _kon_child_listener;
	private SharedPreferences sp;
	private Intent i = new Intent();
	private Calendar cc = Calendar.getInstance();
	private RequestNetwork requestNetwork;
	private RequestNetwork.RequestListener _requestNetwork_request_listener;
	private RequestNetwork tege;
	private RequestNetwork.RequestListener _tege_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.depo);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		cardview1 = findViewById(R.id.cardview1);
		linear2 = findViewById(R.id.linear2);
		layar_title = findViewById(R.id.layar_title);
		layar_nominal_bank = findViewById(R.id.layar_nominal_bank);
		linear10 = findViewById(R.id.linear10);
		linear12 = findViewById(R.id.linear12);
		linear14 = findViewById(R.id.linear14);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		button1 = findViewById(R.id.button1);
		layar_bank = findViewById(R.id.layar_bank);
		layar_nominal_cepat = findViewById(R.id.layar_nominal_cepat);
		bank = findViewById(R.id.bank);
		input_cepat = findViewById(R.id.input_cepat);
		bank_name = findViewById(R.id.bank_name);
		nomm = findViewById(R.id.nomm);
		textinputlayout1 = findViewById(R.id.textinputlayout1);
		linear13 = findViewById(R.id.linear13);
		edittext1 = findViewById(R.id.edittext1);
		button2 = findViewById(R.id.button2);
		textview2 = findViewById(R.id.textview2);
		materialbutton1 = findViewById(R.id.materialbutton1);
		textview1 = findViewById(R.id.textview1);
		listview1 = findViewById(R.id.listview1);
		auth = FirebaseAuth.getInstance();
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		requestNetwork = new RequestNetwork(this);
		tege = new RequestNetwork(this);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		bank.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					bank_name.setText("QRIS");
				}
				if (_position == 1) {
					bank_name.setText("DANA");
				}
				if (_position == 2) {
					bank_name.setText("BCA");
				}
				if (_position == 3) {
					bank_name.setText("BRI");
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		input_cepat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					nomm.setText("10000");
				}
				if (_position == 1) {
					nomm.setText("20000");
				}
				if (_position == 2) {
					nomm.setText("50000");
				}
				if (_position == 3) {
					nomm.setText("100000");
				}
				if (_position == 4) {
					nomm.setText("150000");
				}
				if (_position == 5) {
					nomm.setText("200000");
				}
				if (_position == 6) {
					nomm.setText("500000");
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				nomm.setText(edittext1.getText().toString());
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				kode = SketchwareUtil.getRandom((int)(100), (int)(999));
				c = Calendar.getInstance();
				if (nomm.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Nominal Kosong");
				}
				else {
					if (bank_name.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "PILIH METODE DEPOSIT");
					}
					else {
						key = mutasi.push().getKey();
						map = new HashMap<>();
						map.put("total", nomm.getText().toString().replace("000", "").concat(String.valueOf((long)(kode))));
						map.put("kode", String.valueOf((long)(kode)));
						map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
						map.put("tgl", new SimpleDateFormat("dd/MM/yyyy").format(c.getTime()));
						map.put("jam", new SimpleDateFormat("HH:mm:ss").format(c.getTime()));
						map.put("jenis", "pending");
						map.put("jenis2", "pending");
						map.put("id_depo", "ID".concat(new SimpleDateFormat("ddMMyyyyHHmmss").format(c.getTime())));
						map.put("key", key);
						map.put("metode", bank_name.getText().toString());
						map.put("email", email);
						mutasi.child(key).updateChildren(map);
						map.clear();
						map = new HashMap<>();
						map.put("total", nomm.getText().toString());
						map.put("kode", String.valueOf((long)(kode)));
						map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
						map.put("tgl", new SimpleDateFormat("dd/MM/yyyy").format(c.getTime()));
						map.put("jam", new SimpleDateFormat("HH:mm:ss").format(c.getTime()));
						map.put("jenis", "pending");
						map.put("jenis2", "pending");
						map.put("id_depo", "ID".concat(new SimpleDateFormat("ddMMyyyyHHmmss").format(c.getTime())));
						map.put("metode", bank_name.getText().toString());
						map.put("email", email);
						deposit.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat(new SimpleDateFormat("ddMMyyyyHHmmss").format(c.getTime()))).updateChildren(map);
						map.clear();
						if (title.trim().equals("") && pesan.trim().equals("")) {
							SketchwareUtil.showMessage(getApplicationContext(), "Please enter details...");
						}
						else {
							_sendFCMNotification(serverKey, title, pesan, "null", "all", "null");
							SketchwareUtil.showMessage(getApplicationContext(), "Tiket Deposit Terkirim, Silahkan Lakukan Pembayaran Dan Konfirmasi ");
						}
						i.setClass(getApplicationContext(), DetailDepoActivity.class);
						i.putExtra("total", nomm.getText().toString());
						i.putExtra("kode", String.valueOf((long)(kode)));
						i.putExtra("jam", new SimpleDateFormat("HH:mm:ss").format(c.getTime()));
						i.putExtra("tgl", new SimpleDateFormat("dd/MM/yyyy").format(c.getTime()));
						i.putExtra("id", "ID".concat(new SimpleDateFormat("ddMMyyyyHHmmss").format(c.getTime())));
						i.putExtra("metode", bank_name.getText().toString());
						i.putExtra("dana", dana);
						i.putExtra("bca", bca);
						i.putExtra("bri", bri);
						startActivity(i);
					}
				}
			}
		});
		
		_deposit_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				deposit.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						depos = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								depos.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(depos));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				deposit.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						depos = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								depos.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						listview1.setAdapter(new Listview1Adapter(depos));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
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
		
		_mutasi_child_listener = new ChildEventListener() {
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
		mutasi.addChildEventListener(_mutasi_child_listener);
		
		_kon_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("key")) {
					sp.edit().putString("tittle", _childValue.get("tittle").toString()).commit();
					sp.edit().putString("pesan", _childValue.get("pesan").toString()).commit();
					sp.edit().putString("serverKey", _childValue.get("serverKey").toString()).commit();
					serverKey = _childValue.get("serverKey").toString();
					dana = _childValue.get("dana").toString();
					bri = _childValue.get("bri").toString();
					bca = _childValue.get("bca").toString();
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("key")) {
					sp.edit().putString("tittle", _childValue.get("tittle").toString()).commit();
					sp.edit().putString("pesan", _childValue.get("pesan").toString()).commit();
					bri = _childValue.get("bri").toString();
					bca = _childValue.get("bca").toString();
					dana = _childValue.get("dana").toString();
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
		kon.addChildEventListener(_kon_child_listener);
		
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
		
		_tege_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				SketchwareUtil.showMessage(getApplicationContext(), "Silahkan Tunggu Konfirmasi Deposit Kamu");
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
		_bankk();
		_nom();
		
		serverKey = sp.getString("serverKey", "");
		title = sp.getString("tittle", "");
		pesan = sp.getString("pesan", "");
		tg = "Member Kamu Di Aplikasi Via Digital Melakukan Deposit".concat("\n Total : ".concat(nomm.getText().toString().concat("\n Kode Unik: ".concat(String.valueOf((long)(kode)).concat("\n Tgl / Jam : ".concat(new SimpleDateFormat("dd/MM/yyyy").format(c.getTime()).concat(new SimpleDateFormat("HH:mm:ss").format(c.getTime()).concat("\n Metode: ".concat(bank_name.getText().toString().concat("\n Silahkan Periksa Dan Konfirmasi. Info Lengkap, Periksa Aplikasi "))))))))));
		
	}
	
	public void _bankk() {
		str_bank.add("QRIS");
		str_bank.add("DANA");
		str_bank.add("BCA");
		str_bank.add("BRI");
		bank.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, str_bank));
		((ArrayAdapter)bank.getAdapter()).notifyDataSetChanged();
	}
	
	
	public void _nom() {
		str_nom.add("10.000");
		str_nom.add("20.000");
		str_nom.add("50.000");
		str_nom.add("100.000");
		str_nom.add("150.000");
		str_nom.add("200.000");
		str_nom.add("500.000");
		input_cepat.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, str_nom));
		((ArrayAdapter)input_cepat.getAdapter()).notifyDataSetChanged();
	}
	
	
	public void _setting() {
		layar_title.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
		layar_nominal_bank.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
		layar_bank.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
		layar_nominal_cepat.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
		bank.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
		input_cepat.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
		linear2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)30, (int)5, 0xFF000000, 0xFF9E9E9E));
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
	
	
	public void _glideFromURL(final String _url, final ImageView _imageview) {
		
		Glide.with(getApplicationContext())
		.load(_url)
		.diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.ALL)
		.error(R.drawable.app_icon)
		.into(_imageview);
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.his, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final TextView id_produk = _view.findViewById(R.id.id_produk);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final LinearLayout layar_status = _view.findViewById(R.id.layar_status);
			final TextView tgl = _view.findViewById(R.id.tgl);
			final TextView jam = _view.findViewById(R.id.jam);
			final TextView teks_status = _view.findViewById(R.id.teks_status);
			final TextView id_transaksi = _view.findViewById(R.id.id_transaksi);
			
			linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
			cc = Calendar.getInstance();
			filter = new SimpleDateFormat("dd/MM/yyyy").format(cc.getTime());
			ftt = _data.get((int)_position).get("tgl").toString();
			uuid = _data.get((int)_position).get("uid").toString();
			statuss = _data.get((int)_position).get("jenis").toString();
			if (filter.equals(ftt)) {
				linear1.setVisibility(View.VISIBLE);
				if (FirebaseAuth.getInstance().getCurrentUser().getUid().contains(uuid)) {
					id_transaksi.setText(_data.get((int)_position).get("total").toString());
					id_produk.setText(_data.get((int)_position).get("id_depo").toString());
					tgl.setText(_data.get((int)_position).get("tgl").toString());
					jam.setText(_data.get((int)_position).get("jam").toString());
					layar_status.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
					if (statuss.contains("Failed")) {
						teks_status.setText("GAGAL");
						layar_status.setBackgroundColor(0xFFF44336);
					}
					else {
						teks_status.setText("SUKSES");
						layar_status.setBackgroundColor(0xFF4CAF50);
						if (statuss.contains("pending")) {
							teks_status.setText("PENDING");
							layar_status.setBackgroundColor(0xFF2196F3);
						}
					}
				}
				else {
					linear1.setVisibility(View.GONE);
				}
			}
			else {
				linear1.setVisibility(View.GONE);
			}
			
			return _view;
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