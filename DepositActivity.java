package com.anseltsm.viadigital;

import android.animation.*;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
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
import java.text.DecimalFormat;
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

public class DepositActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private double kodeunik = 0;
	private HashMap<String, Object> map = new HashMap<>();
	private String fin = "";
	private String id = "";
	private String key = "";
	private String id_depo = "";
	private String bca = "";
	private String briva = "";
	private String title = "";
	private String pesan = "";
	private String serverKey = "";
	private String token = "";
	
	private ArrayList<String> str = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout layar_menu;
	private TextView textview1;
	private TextInputLayout textinputlayout1;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private EditText edittext1;
	private MaterialButton materialbutton6;
	private MaterialButton materialbutton2;
	private MaterialButton materialbutton3;
	private MaterialButton materialbutton4;
	private Spinner spinner1;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear11;
	private LinearLayout linear12;
	private LinearLayout linear10;
	private MaterialButton materialbutton1;
	private TextView textview2;
	private TextView nominal;
	private TextView unik;
	private TextView textview6;
	private TextView textview4;
	private TextView metode;
	private TextView textview5;
	private TextView email;
	private TextView bank;
	private ImageView imageview2;
	private ImageView imageview1;
	
	private Intent i = new Intent();
	private AlertDialog.Builder d;
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
	
	private DatabaseReference mutasi = _firebase.getReference("mutasi");
	private ChildEventListener _mutasi_child_listener;
	private Calendar c = Calendar.getInstance();
	private DatabaseReference member = _firebase.getReference("member");
	private ChildEventListener _member_child_listener;
	private DatabaseReference kon = _firebase.getReference("pengaturan/koneksi");
	private ChildEventListener _kon_child_listener;
	private DatabaseReference deposit = _firebase.getReference("deposit");
	private ChildEventListener _deposit_child_listener;
	private RequestNetwork requestNetwork;
	private RequestNetwork.RequestListener _requestNetwork_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.deposit);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		layar_menu = findViewById(R.id.layar_menu);
		textview1 = findViewById(R.id.textview1);
		textinputlayout1 = findViewById(R.id.textinputlayout1);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		linear6 = findViewById(R.id.linear6);
		edittext1 = findViewById(R.id.edittext1);
		materialbutton6 = findViewById(R.id.materialbutton6);
		materialbutton2 = findViewById(R.id.materialbutton2);
		materialbutton3 = findViewById(R.id.materialbutton3);
		materialbutton4 = findViewById(R.id.materialbutton4);
		spinner1 = findViewById(R.id.spinner1);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		linear11 = findViewById(R.id.linear11);
		linear12 = findViewById(R.id.linear12);
		linear10 = findViewById(R.id.linear10);
		materialbutton1 = findViewById(R.id.materialbutton1);
		textview2 = findViewById(R.id.textview2);
		nominal = findViewById(R.id.nominal);
		unik = findViewById(R.id.unik);
		textview6 = findViewById(R.id.textview6);
		textview4 = findViewById(R.id.textview4);
		metode = findViewById(R.id.metode);
		textview5 = findViewById(R.id.textview5);
		email = findViewById(R.id.email);
		bank = findViewById(R.id.bank);
		imageview2 = findViewById(R.id.imageview2);
		imageview1 = findViewById(R.id.imageview1);
		d = new AlertDialog.Builder(this);
		auth = FirebaseAuth.getInstance();
		requestNetwork = new RequestNetwork(this);
		
		materialbutton6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext1.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Masukan Nominal Top Up");
				}
				else {
					unik.setVisibility(View.VISIBLE);
					nominal.setText(new DecimalFormat("#,###").format(Double.parseDouble(edittext1.getText().toString())));
					textview6.setText(edittext1.getText().toString());
					if (Double.parseDouble(edittext1.getText().toString()) > 500000) {
						d.setTitle("PERINGATAN");
						d.setMessage("NOMINAL LEBIH DARI 500.000 PERLU VERIFIKASI IDENTITAS YANG BERLAKU!");
						d.setPositiveButton("OK", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						d.create().show();
						edittext1.setText("100000");
						nominal.setText(new DecimalFormat("#,###").format(Double.parseDouble("100000")));
						textview6.setText("100000");
					}
					else {
						
					}
				}
			}
		});
		
		materialbutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setText("100000");
			}
		});
		
		materialbutton3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setText("150000");
			}
		});
		
		materialbutton4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext1.setText("200000");
			}
		});
		
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					
				}
				if (_position == 1) {
					metode.setText("QRIS");
					imageview1.setVisibility(View.VISIBLE);
					Glide.with(getApplicationContext()).load(Uri.parse("https://firebasestorage.googleapis.com/v0/b/pulsakita-9bc04.appspot.com/o/IMG-20231128-WA0000.jpg?alt=media&token=83ccaedb-fdcd-4c09-a262-d1b18ac402c3")).into(imageview1);
					linear12.setVisibility(View.GONE);
				}
				if (_position == 2) {
					metode.setText("DANA");
					bank.setText(bca);
					linear12.setVisibility(View.VISIBLE);
					imageview1.setVisibility(View.GONE);
				}
				if (_position == 3) {
					metode.setText("LINK AJA");
					bank.setText(briva);
					linear12.setVisibility(View.VISIBLE);
					imageview1.setVisibility(View.GONE);
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				c = Calendar.getInstance();
				if (nominal.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Nominal Kosong");
				}
				else {
					if (metode.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "PILIH METODE DEPOSIT");
					}
					else {
						key = mutasi.push().getKey();
						map = new HashMap<>();
						map.put("total", nominal.getText().toString());
						map.put("kode", unik.getText().toString());
						map.put("cr", textview6.getText().toString());
						map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
						map.put("tgl", new SimpleDateFormat("dd/MM/yyyy").format(c.getTime()));
						map.put("jam", new SimpleDateFormat("HH:mm:ss").format(c.getTime()));
						map.put("jenis", "pending");
						map.put("jenis2", "pending");
						map.put("id_depo", "ID".concat(new SimpleDateFormat("ddMMyyyyHHmmss").format(c.getTime())));
						map.put("key", key);
						map.put("metode", metode.getText().toString());
						map.put("email", email.getText().toString());
						mutasi.child(key).updateChildren(map);
						map.clear();
						map = new HashMap<>();
						map.put("total", nominal.getText().toString());
						map.put("kode", unik.getText().toString());
						map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
						map.put("tgl", new SimpleDateFormat("dd/MM/yyyy").format(c.getTime()));
						map.put("jam", new SimpleDateFormat("HH:mm:ss").format(c.getTime()));
						map.put("jenis", "pending");
						map.put("jenis2", "pending");
						map.put("id_depo", "ID".concat(new SimpleDateFormat("ddMMyyyyHHmmss").format(c.getTime())));
						map.put("metode", metode.getText().toString());
						map.put("email", email.getText().toString());
						deposit.child(FirebaseAuth.getInstance().getCurrentUser().getUid().concat(new SimpleDateFormat("ddMMyyyyHHmmss").format(c.getTime()))).updateChildren(map);
						map.clear();
						SketchwareUtil.showMessage(getApplicationContext(), "Tiket Deposit Terkirim, Silahkan Tunggu Konfirmasi Atau hubungi Customer Service");
						if (title.trim().equals("") && pesan.trim().equals("")) {
							SketchwareUtil.showMessage(getApplicationContext(), "Please enter details...");
						}
						else {
							_sendFCMNotification(serverKey, title, pesan, "null", "all", "null");
						}
					}
				}
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", bank.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "Disalin");
			}
		});
		
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
		
		_member_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					if (_childValue.containsKey("email")) {
						email.setText(_childValue.get("email").toString());
					}
				}
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
		member.addChildEventListener(_member_child_listener);
		
		_kon_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("key")) {
					if (_childValue.containsKey("bca")) {
						bca = _childValue.get("bca").toString();
					}
					if (_childValue.containsKey("briva")) {
						briva = _childValue.get("briva").toString();
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("key")) {
					if (_childValue.containsKey("bca")) {
						bca = _childValue.get("bca").toString();
					}
					if (_childValue.containsKey("briva")) {
						briva = _childValue.get("briva").toString();
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
		kon.addChildEventListener(_kon_child_listener);
		
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
		str.add("PILIH");
		str.add("QRIS ");
		str.add("DANA");
		str.add("LINK AJA");
		spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, str));
		((ArrayAdapter)spinner1.getAdapter()).notifyDataSetChanged();
		layar_menu.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
		kodeunik = SketchwareUtil.getRandom((int)(100), (int)(999));
		unik.setText(String.valueOf((long)(kodeunik)));
		unik.setVisibility(View.GONE);
		imageview1.setVisibility(View.GONE);
		linear12.setVisibility(View.GONE);
		textview6.setVisibility(View.GONE);
		
		title = "Konfirmasi Deposit Member";
		pesan = "Member Kamu Melakukan Deposit, Silahkan Periksa";
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