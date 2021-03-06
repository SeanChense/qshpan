package org.qinshuihepan.bbs.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.qinshuihepan.bbs.R;
import org.qinshuihepan.bbs.api.Api;
import org.qinshuihepan.bbs.data.Request;
import org.qinshuihepan.bbs.util.MD5;
import org.qinshuihepan.bbs.util.TaskUtils;
import org.qinshuihepan.bbs.util.Utils;
import org.qinshuihepan.bbs.util.sharedpreference.Athority;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by liurongchan on 14-4-29.
 */
public class LoginActivity extends Activity {


    private Context mContext;

    @InjectView(R.id.username)
    public EditText usernameText;

    @InjectView(R.id.password)
    public EditText passwordText;

    @InjectView(R.id.confirm)
    public Button confirm;

    private ProgressDialog progressDialog;

    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.inject(this);
        mContext = this;
        ActionBar actionBar = getActionBar();
        actionBar.hide();

        confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                username = usernameText.getText().toString();
                password = passwordText.getText().toString();
                if(!Utils.isNetworkOn(mContext)){
                	Toast.makeText(mContext, getString(R.string.offline), Toast.LENGTH_SHORT)
                    .show();
                	return;
                }
                if (username.equals("")) {
                    Toast.makeText(mContext, "用户名不能为空！", Toast.LENGTH_SHORT)
                            .show();
                } else if (password.equals("")) {
                    Toast.makeText(mContext, "密码不能为空！", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    MD5 m = new MD5();
                    password = m.getMD5ofStr(password);
                    progressDialog = ProgressDialog.show(mContext, null, "请稍后");
                    TaskUtils.executeAsyncTask(new AsyncTask<Void, Void, Boolean>() {
                        @Override
                        protected Boolean doInBackground(Void... voids) {

                            return isLoginSuccess();
                        }

                        @Override
                        protected void onPostExecute(Boolean success) {
                            super.onPostExecute(success);
                            if (!success) {
                                progressDialog.dismiss();
                                Toast.makeText(mContext, "用户名或密码错误!", Toast.LENGTH_SHORT)
                                        .show();
                                usernameText.setText("");
                                passwordText.setText("");
                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(mContext, "登录成功!", Toast.LENGTH_SHORT)
                                        .show();
                                Intent intent = new Intent(mContext, MainActivity.class);
                                mContext.startActivity(intent);
                                finish();
                            }
                        }
                    });
                }
            }
        });

    }


	private boolean isLoginSuccess() {
        Document doc = null;
        String formhash = null;
        String loginaction = null;
        Map<String, String> datas = new HashMap<String, String>();
        Map<String, String> cookies = new HashMap<String, String>();
        try {
            Connection.Response before_login = Request.execute(Api.COOKIE_LOGIN, "Mozilla", Connection.Method.POST);
            doc = before_login.parse();
            Element hash = doc.getElementById("scbar_form");
            Elements hashs = hash.getElementsByTag("input");
            for (Element element : hashs) {
                if (element.attr("name").equals("formhash")) {
                    formhash = element.attr("value");
                }
            }

            Elements login = doc.getElementsByClass("cl");
            loginaction = login.attr("action");
            loginaction = loginaction.replace("amp", "");
            datas.put("formhash", formhash);
            datas.put("referer", Api.HOST);
            datas.put("loginfield", "username");
            datas.put("password", password);
            datas.put("questionid", "0");
            datas.put("loginsubmit", "true");
            datas.put("username", username);
            cookies = before_login.cookies();
            cookies.put("sendmail", "1");
            Connection.Response logining = Request.execute(String.format(Api.LOGIN, loginaction), "Mozilla", datas, cookies, Connection.Method.POST);
            if (logining.cookie("v3hW_2132_auth") == null) {
                return false;
            } else {
                cookies = logining.cookies();
                cookies.put("v3hW_2132_saltkey", before_login.cookie("v3hW_2132_saltkey"));
                cookies.put("login", "yes");
                Athority.addCookies(cookies);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (progressDialog != null) {
			progressDialog.dismiss();
			progressDialog = null;
	    }
	}

}
